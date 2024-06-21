package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internship-supervisor")
@ControllerAdvice
@AllArgsConstructor
public class InternshipSupervisorControllerRest {
    private final InternshipSupervisorService internshipSupervisorService;

    @GetMapping ("/{id}")
    public InternshipSupervisor getSupervisor(@PathVariable String id){
        return internshipSupervisorService.findById(id);
    }

    @PutMapping("/approve-internship")
    public void approveInternship(@RequestParam String supervisorId, @RequestParam String internshipId){
        internshipSupervisorService.approveInternship(supervisorId, internshipId);
    }

    @PutMapping("/revoke-approval-internship")
    public void revokeApprovalInternship(@RequestParam String supervisorId, @RequestParam String internshipId){
        internshipSupervisorService.revokeApprovalInternship(supervisorId, internshipId);
    }

    @PutMapping("/assign")
    public void assignSupervisor(@RequestParam String supervisorId, @RequestParam String internshipId){
        internshipSupervisorService.assign(supervisorId, internshipId);
    }
}
