package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supervisor")
@AllArgsConstructor
public class InternshipSupervisorController {
    private final InternshipSupervisorService internshipSupervisorService;

    @PostMapping("/{internshipId}/approve")
    public String approve(@PathVariable Long internshipId,
                          @AuthenticationPrincipal FacultyUserDetails facultyUserDetails) {
        InternshipSupervisor supervisor = facultyUserDetails.getSupervisor();
        internshipSupervisorService.approveInternship(supervisor.getId(), internshipId);
        return "redirect:/internships/"+internshipId;
    }

    @PostMapping("/{internshipId}/revoke-approval")
    public String revokeApproval(@PathVariable Long internshipId,
                                 @AuthenticationPrincipal FacultyUserDetails facultyUserDetails) {
        InternshipSupervisor supervisor = facultyUserDetails.getSupervisor();
        internshipSupervisorService.revokeApprovalInternship(supervisor.getId(), internshipId);
        return "redirect:/internships/"+internshipId;
    }

    @PostMapping("/{internshipId}/assign")
    public String assign(@PathVariable Long internshipId,
                         @AuthenticationPrincipal FacultyUserDetails facultyUserDetails) {
        InternshipSupervisor supervisor = facultyUserDetails.getSupervisor();
        internshipSupervisorService.assign(supervisor.getId(), internshipId);
        return "redirect:/internships/";
    }
}
