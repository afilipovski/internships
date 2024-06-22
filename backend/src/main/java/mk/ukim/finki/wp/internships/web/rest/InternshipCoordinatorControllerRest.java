package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internship-coordinator")
@ControllerAdvice
@AllArgsConstructor
public class InternshipCoordinatorControllerRest {
    private final InternshipCoordinatorService internshipCoordinatorService;

    @GetMapping("/{id}")
    public InternshipCoordinator getCoordinator(@PathVariable String id){
        return internshipCoordinatorService.findById(id);
    }

    @PutMapping("/approve-internship")
    public void approveInternship(@RequestParam String coordinatorId, @RequestParam String internshipId){
        internshipCoordinatorService.approveInternship(coordinatorId, internshipId);
    }

    @PutMapping("/revoke-approval-internship")
    public void revokeApproval(@RequestParam String coordinatorId, @RequestParam String internshipId){
        internshipCoordinatorService.revokeApprovalInternship(coordinatorId, internshipId);
    }

    @PutMapping("/assign-random")
    public void assignRandomCoordinator(@RequestParam String internshipId){
        internshipCoordinatorService.assignRandom(internshipId);
    }
}
