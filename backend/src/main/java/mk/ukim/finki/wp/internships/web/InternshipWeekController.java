package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;
import mk.ukim.finki.wp.internships.service.InternshipService;
import mk.ukim.finki.wp.internships.service.InternshipWeekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/internship-weeks")
@AllArgsConstructor
public class InternshipWeekController {
    private final InternshipService internshipService;
    private final InternshipWeekService internshipWeekService;

    @GetMapping("/create")
    public String createWeek(@RequestParam Long internshipId,
                             Model model) {
        model.addAttribute("internship", internshipService.findById(internshipId));

        return "internship-weeks/form";
    }

    @GetMapping("/{id}/edit")
    public String editWeek(@PathVariable Long id,
                             Model model) {
        InternshipWeek internshipWeek = internshipWeekService.findById(id);

        model.addAttribute("internship",
                internshipService.findById(internshipWeek.getInternship().getId()));
        model.addAttribute("week", internshipWeek);

        return "internship-weeks/form";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam LocalDate startDate,
                       @RequestParam LocalDate endDate,
                       @RequestParam Long internshipId,
                       @RequestParam String description) {
        if (id == null) {
            internshipWeekService.create(startDate,endDate,internshipId,description);
        }
        else {
            internshipWeekService.update(id,startDate,endDate,internshipId,description);
        }
        return "redirect:/internships/"+internshipId;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        InternshipWeek internshipWeek = internshipWeekService.delete(id);
        return "redirect:/internships/"+internshipWeek.getInternship().getId();
    }
}
