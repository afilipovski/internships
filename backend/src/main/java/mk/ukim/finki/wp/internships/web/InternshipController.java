package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.model.internships.InternshipPosting;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
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

    @GetMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        InternshipSupervisor supervisor = principal.getSupervisor();
         Professor professor = principal.getProfessor();

        if (student != null) {
            List<Internship> internships = internshipService.findAllByStudentIndex(student.getIndex());
            model.addAttribute("internships", internships);
            model.addAttribute("student", student);
            return "internships/index";
        }
        if (supervisor != null) {
            model.addAttribute("supervisor", supervisor);
            return "internships/supervisor";
        }

        InternshipCoordinator coordinator = internshipCoordinatorService.findByProfessorId(professor.getId());
        model.addAttribute("coordinator", coordinator);
        return "internships/coordinator";
    }

    @GetMapping("/create")
    public String createInternship(Model model,
                                   @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        List<InternshipPosting> postings = internshipPostingService.findAll();


        model.addAttribute("student", student);
        model.addAttribute("postings", postings);

        return "internships/create";
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

    @GetMapping("/{id}")
    public String internshipDetails(@PathVariable Long id, Model model) {
        Internship internship = internshipService.findById(id);
        model.addAttribute("internship",internship);

        return "internships/details";
    }
}
