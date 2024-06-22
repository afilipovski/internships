package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipPosting;
import mk.ukim.finki.wp.internships.service.InternshipPostingService;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final InternshipService internshipService;
    private final InternshipPostingService internshipPostingService;

    @GetMapping({"/","/list-internships"})
    public String index(Model model,
                        @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        List<Internship> internships = internshipService.findAllByStudentIndex(student.getIndex());

        model.addAttribute("student", student);
        model.addAttribute("internships", internships);

        return "students/index";
    }

    @GetMapping("/create-internship")
    public String createInternship(Model model,
                                   @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        List<InternshipPosting> postings = internshipPostingService.findAll();


        model.addAttribute("student", student);
        model.addAttribute("postings", postings);

        return "students/create-internship";
    }

    @PostMapping("/create-internship")
    public String createInternshipPost(@RequestParam String studentId,
                                       @RequestParam Long postingId) {
        internshipService.create(studentId,postingId);
        return "redirect:/students/";
    }
}
