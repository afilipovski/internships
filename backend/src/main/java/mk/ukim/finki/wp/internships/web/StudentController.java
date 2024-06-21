package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.service.InternshipService;
import mk.ukim.finki.wp.internships.service.StudentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final InternshipService internshipService;

    @GetMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal FacultyUserDetails principal) {
        Student student = principal.getStudent();
        List<Internship> internships = internshipService.findAllByStudentIndex(student.getIndex());

        model.addAttribute("student", student);
        model.addAttribute("internships", internships);

        return "students/index";
    }
}
