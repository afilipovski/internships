package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internship")
@ControllerAdvice
@AllArgsConstructor
public class InternshipControllerRest {
    private final InternshipService internshipService;

    @GetMapping("/forStudent/{index}")
    public List<Internship> getInternshipsForStudent(@PathVariable String index) {
        return internshipService.findAllByStudentIndex(index);
    }

    @GetMapping("/forSupervisor/{id}")
    public List<Internship> getInternshipsForSupervisor(@PathVariable Long id) {
        return internshipService.findAllBySupervisorIdOrderByStatusAsc(id);
    }

    @GetMapping("/forProfessor/{id}")
    public List<Internship> getInternshipsForProfessor(@PathVariable String id) {
        return internshipService.findAllByProfessorId(id);
    }


}
