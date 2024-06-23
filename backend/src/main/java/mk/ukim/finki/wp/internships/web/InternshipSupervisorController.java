package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Company;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.service.CompanyService;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/supervisor")
@AllArgsConstructor
public class InternshipSupervisorController {
    private final InternshipSupervisorService internshipSupervisorService;
    private final CompanyService companyService;

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

    @GetMapping("/")
    public String getAllSupervisors(Model model) {
        List<InternshipSupervisor> supervisors = internshipSupervisorService.findAll();
        model.addAttribute("supervisors", supervisors);
        return "supervisor/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("supervisor", new InternshipSupervisor());
        model.addAttribute("companies", companies);
        return "supervisor/form";
    }

    @PostMapping("/create")
    public String createSupervisor(@ModelAttribute InternshipSupervisor supervisor) {
        internshipSupervisorService.create(supervisor.getCompany().getId(),
                supervisor.getEmail(),
                supervisor.getFullName());
        return "redirect:/supervisor/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        InternshipSupervisor supervisor = internshipSupervisorService.findById(id);
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("supervisor", supervisor);
        model.addAttribute("companies", companies);
        return "supervisor/form";
    }

    @PostMapping("/edit/{id}")
    public String updateSupervisor(@PathVariable Long id, @ModelAttribute InternshipSupervisor supervisor) {
        supervisor.setId(id);
        internshipSupervisorService.update(supervisor);
        return "redirect:/supervisor/";
    }


}
