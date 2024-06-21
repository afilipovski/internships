package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internship")
@ControllerAdvice
@AllArgsConstructor
public class InternshipControllerRest {
    private final InternshipService internshipService;

    @PostMapping("/create")
    public Internship createInternship(@RequestParam String studentId, @RequestParam String postingId) {
        return internshipService.create(studentId, postingId);
    }

}
