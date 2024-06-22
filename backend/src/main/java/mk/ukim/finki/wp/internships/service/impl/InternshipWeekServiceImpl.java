package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.EntityNotFoundException;
import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;
import mk.ukim.finki.wp.internships.repository.internships.InternshipWeekRepository;
import mk.ukim.finki.wp.internships.service.InternshipWeekService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class InternshipWeekServiceImpl implements InternshipWeekService {
    InternshipWeekRepository internshipWeekRepository;

    @Override
    public InternshipWeek create(LocalDate startDate, LocalDate endDate) {
        InternshipWeek week = new InternshipWeek(startDate, endDate);
        return internshipWeekRepository.save(week);
    }

    @Override
    public InternshipWeek updateDescription(Long id, String description) {
        InternshipWeek week = internshipWeekRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("InternshipWeek with id "+id+" not found"));
        week.setDescription(description);
        return week;
    }
}
