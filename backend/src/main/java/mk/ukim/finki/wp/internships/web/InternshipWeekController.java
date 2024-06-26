package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;
import mk.ukim.finki.wp.internships.service.InternshipService;
import mk.ukim.finki.wp.internships.service.InternshipWeekService;
import mk.ukim.finki.wp.internships.service.StudentService;
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
    private final StudentService studentService;

    @GetMapping("/create")
    public String createWeek(@RequestParam Long internshipId,
                             @RequestParam String index,
                             Model model) {
        model.addAttribute("internship", internshipService.findById(internshipId));
        model.addAttribute("student", studentService.getStudentByIndex(index));
        return "redirect:/internships/"+internshipId+"/"+index+"/";
    }

    @GetMapping("/{id}/edit/{index}")
    public String editWeek(@PathVariable Long id,
                           @PathVariable String index,
                             Model model) {
        InternshipWeek internshipWeek = internshipWeekService.findById(id);
        Long internshipId=internshipWeek.getInternship().getId();
        Student student=studentService.getStudentByIndex(index);
        model.addAttribute("internship",
                internshipService.findById(internshipWeek.getInternship().getId()));
        model.addAttribute("week", internshipWeek);
        model.addAttribute("student", student);
        return "/student/details";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id,
                       @RequestParam LocalDate startDate,
                       @RequestParam LocalDate endDate,
                       @RequestParam Long internshipId,
                       @RequestParam String description,
                        @RequestParam String index) {

        if (id == null) {
            internshipWeekService.create(startDate,endDate,internshipId,description);
        }
        else {
            internshipWeekService.update(id,startDate,endDate,internshipId,description);
        }
        return "redirect:/internships/"+internshipId+"/"+index+"/";
    }

    @PostMapping("/{id}/delete/{index}")
    public String delete(@PathVariable Long id,@PathVariable String index) {
        InternshipWeek internshipWeek = internshipWeekService.delete(id);
        System.out.println("VLAGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        return "redirect:/internships/"+internshipWeek.getInternship().getId()+"/"+index+"/";
    }
}
