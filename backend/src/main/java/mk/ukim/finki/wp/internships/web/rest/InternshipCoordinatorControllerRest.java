package mk.ukim.finki.wp.internships.web.rest;

import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internship-coordinators")
public class InternshipCoordinatorControllerRest {

    private final InternshipCoordinatorService coordinatorService;

    public InternshipCoordinatorControllerRest(InternshipCoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping("/create")
    public InternshipCoordinator createInternshipCoordinator(@RequestParam String professorId) {
        return coordinatorService.create(professorId);
    }

    @DeleteMapping("/delete/{professorId}")
    public InternshipCoordinator deleteInternshipCoordinator(@PathVariable String professorId) {
        return coordinatorService.delete(professorId);
    }

    @GetMapping("/{professorId}")
    public InternshipCoordinator getInternshipCoordinator(@PathVariable String professorId) {
        return coordinatorService.findById(professorId);
    }

    @PutMapping("/approve/{professorId}/{internshipId}")
    public void approveInternship(@PathVariable String professorId, @PathVariable Long internshipId) {
        coordinatorService.approveInternship(professorId, internshipId);
    }

    @PutMapping("/revoke-approval/{professorId}/{internshipId}")
    public void revokeApprovalInternship(@PathVariable String professorId, @PathVariable Long internshipId) {
        coordinatorService.revokeApprovalInternship(professorId, internshipId);
    }

    @PutMapping("/assign-random/{internshipId}")
    public void assignRandomCoordinator(@PathVariable Long internshipId) {
        coordinatorService.assignRandom(internshipId);
    }
}
