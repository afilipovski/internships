package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coordinator")
@AllArgsConstructor
public class InternshipCoordinatorController {
    private final InternshipCoordinatorService coordinatorService;

    @PostMapping("/opt-in")
    public String optIn(@AuthenticationPrincipal FacultyUserDetails principal) {
        Professor professor = principal.getProfessor();
        InternshipCoordinator coordinator = coordinatorService.findById(professor.getId());
        if (coordinator == null) {
            coordinatorService.create(professor.getId());
        }
        return "redirect:/internships/";
    }

    @PostMapping("/opt-out")
    public String optOut(@AuthenticationPrincipal FacultyUserDetails principal) {
        Professor professor = principal.getProfessor();
        InternshipCoordinator coordinator = coordinatorService.findById(professor.getId());
        if (coordinator != null) {
            coordinatorService.delete(professor.getId());
        }
        return "redirect:/internships/";
    }
}
