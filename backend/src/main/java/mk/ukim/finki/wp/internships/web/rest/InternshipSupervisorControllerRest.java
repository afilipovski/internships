package mk.ukim.finki.wp.internships.web.rest;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internship-supervisors")
public class InternshipSupervisorControllerRest {

    private final InternshipSupervisorService supervisorService;

    public InternshipSupervisorControllerRest(InternshipSupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @PostMapping("/admin/create")
    public InternshipSupervisor createInternshipSupervisor(
            @RequestParam String companyId,
            @RequestParam String email,
            @RequestParam String fullName
    ) {
        return supervisorService.create(companyId, email, fullName);
    }

    @GetMapping("/{id}")
    public InternshipSupervisor getInternshipSupervisor(@PathVariable Long id) {
        return supervisorService.findById(id);
    }

    @PutMapping("/approve/{id}/{internshipId}")
    public void approveInternship(
            @PathVariable Long id,
            @PathVariable Long internshipId
    ) {
        supervisorService.approveInternship(id, internshipId);
    }

    @PutMapping("/revoke-approval/{id}/{internshipId}")
    public void revokeApprovalInternship(
            @PathVariable Long id,
            @PathVariable Long internshipId
    ) {
        supervisorService.revokeApprovalInternship(id, internshipId);
    }

    @PutMapping("/assign/{id}/{internshipId}")
    public void assignInternship(
            @PathVariable Long id,
            @PathVariable Long internshipId
    ) {
        supervisorService.assign(id, internshipId);
    }

    @GetMapping
    public List<InternshipSupervisor> getAllInternshipSupervisors() {
        return supervisorService.findAll();
    }

    //TODO
    @PutMapping("/update")
    public void updateInternshipSupervisor(@RequestBody InternshipSupervisor supervisor) {
        supervisorService.update(supervisor);
    }
}
