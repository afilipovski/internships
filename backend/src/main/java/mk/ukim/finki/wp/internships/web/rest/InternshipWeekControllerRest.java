package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;
import mk.ukim.finki.wp.internships.service.InternshipWeekService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/internship-week")
@ControllerAdvice
@AllArgsConstructor
public class InternshipWeekControllerRest {
    InternshipWeekService internshipWeekService;

    @PostMapping("/create")
    public InternshipWeek createInternshipWeek(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return internshipWeekService.create(startDate, endDate);
    }

    @PutMapping("/update-description")
    public InternshipWeek updateDescription(@RequestParam String id, @RequestParam String description){
        return internshipWeekService.updateDescription(id, description);
    }
}
