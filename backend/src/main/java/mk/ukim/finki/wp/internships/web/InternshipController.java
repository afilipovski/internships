package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import mk.ukim.finki.wp.internships.service.InternshipService;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internship")
@ControllerAdvice
@AllArgsConstructor
public class InternshipController {
    private final InternshipService internshipService;

    @PostMapping("/create")
    public Internship createInternship(@RequestParam String studentId, @RequestParam String postingId) {
        return internshipService.create(studentId, postingId);
    }

}
