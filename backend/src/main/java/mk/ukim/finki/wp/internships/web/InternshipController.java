package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.internships.*;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import mk.ukim.finki.wp.internships.service.InternshipPostingService;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/internships")
@AllArgsConstructor
public class InternshipController {
    private final InternshipService internshipService;
    private final InternshipPostingService internshipPostingService;
    private final InternshipCoordinatorService internshipCoordinatorService;

    private String studentIndex(Student student, Model model) {
        List<Internship> internships = internshipService.findAllByStudentIndex(student.getIndex());
        model.addAttribute("internships", internships);
        model.addAttribute("student", student);
        return "student/index";
    }

    private String supervisorIndex(InternshipSupervisor supervisor, Model model) {
        model.addAttribute("supervisor", supervisor);
        model.addAttribute("supervisor_internships", internshipService.findAllBySupervisorIdOrderByStatusAsc(
                supervisor.getId()
        ));
        model.addAttribute("company_internships", internshipService.findAllByPostingCompanyIdAndSupervisorIdIsNull(
                supervisor.getCompany().getId()
        ));

        return "supervisor/index";
    }

    private String coordinatorIndex(Professor professor, Model model) {
        model.addAttribute("professor", professor);
        model.addAttribute("coordinator", internshipCoordinatorService.findById(professor.getId()));

        List<Internship> internships = internshipService.findAllByProfessorIdAndStatus(
                professor.getId(),
                InternshipStatus.PENDING_PROFFESSOR_REVIEW
        );
        internships.addAll(internshipService.findAllByProfessorIdAndStatus(
                professor.getId(),
                InternshipStatus.DEPOSITED
        ));
        model.addAttribute("internships", internships);

        return "coordinator/index";
    }

    @GetMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        InternshipSupervisor supervisor = principal.getSupervisor();
        Professor professor = principal.getProfessor();

        if (student != null) {
            return studentIndex(student, model);
        }
        if (supervisor != null) {
            return supervisorIndex(supervisor,model);
        }
        return coordinatorIndex(professor,model);
    }

    @GetMapping("/create")
    public String createInternship(Model model,
                                   @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        List<InternshipPosting> postings = internshipPostingService.findAll();


        model.addAttribute("student", student);
        model.addAttribute("postings", postings);

        return "student/create";
    }

    @PostMapping("/create")
    public String createInternshipPost(@RequestParam String studentId,
                                       @RequestParam Long postingId) {
        internshipService.create(studentId,postingId);
        return "redirect:/internships/";
    }

    @PostMapping("/{id}/delete")
    public String deleteInternship(@PathVariable Long id) {
        internshipService.delete(id);
        return "redirect:/internships/";
    }

    private String studentDetails(Long id, Model model) {
        return "student/details";
    }
    private String supervisorDetails(Long id, Model model) {
        return "supervisor/details";
    }
    private String coordinatorDetails(Long id, Model model) {
        return "coordinator/details";
    }

    @GetMapping("/{id}")
    public String internshipDetails(@PathVariable Long id,
                                    @AuthenticationPrincipal FacultyUserDetails principal,
                                    Model model) {
        Internship internship = internshipService.findById(id);
        model.addAttribute("internship",internship);

        if (principal.getStudent() != null)
            return studentDetails(id,model);
        if (principal.getSupervisor() != null)
            return supervisorDetails(id,model);
        return coordinatorDetails(id,model);
    }


}
