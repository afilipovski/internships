package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internship")
@ControllerAdvice
@AllArgsConstructor
public class InternshipController {
    InternshipService internshipService;

    @PostMapping("/create")
    public Internship createInternship(@RequestParam String studentId, @RequestParam String postingId) {
        return internshipService.create(studentId, postingId);
    }

    @PutMapping("/assign-supervisor")
    public void assignSupervisor(@RequestParam String internshipId, @RequestParam String supervisorId) {
        internshipService.assignSupervisor(internshipId, supervisorId);
    }

    @PutMapping("/set-status")
    public void changeInternshipStatus(@RequestParam String internshipId, @RequestParam String userId, @RequestParam InternshipStatus status){
        internshipService.setStatus(internshipId, userId, status);
    }
}
