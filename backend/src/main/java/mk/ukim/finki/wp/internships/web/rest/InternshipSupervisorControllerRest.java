package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/internship-supervisor")
@ControllerAdvice
@AllArgsConstructor
public class InternshipSupervisorControllerRest {
    private final InternshipSupervisorService internshipSupervisorService;

    @GetMapping ("/{id}")
    public InternshipSupervisor getSupervisor(@PathVariable Long id){
        return internshipSupervisorService.findById(id);
    }

    @PutMapping("/approve-internship")
    public void approveInternship(@RequestParam Long supervisorId, @RequestParam Long internshipId){
        internshipSupervisorService.approveInternship(supervisorId, internshipId);
    }

    @PutMapping("/revoke-approval-internship")
    public void revokeApprovalInternship(@RequestParam Long supervisorId, @RequestParam Long internshipId){
        internshipSupervisorService.revokeApprovalInternship(supervisorId, internshipId);
    }

    @PutMapping("/assign")
    public void assignSupervisor(@RequestParam Long supervisorId, @RequestParam Long internshipId){
        internshipSupervisorService.assign(supervisorId, internshipId);
    }
}
