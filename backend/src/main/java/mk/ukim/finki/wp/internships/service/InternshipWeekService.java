package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;

import java.time.LocalDate;

public interface InternshipWeekService {
    InternshipWeek create(LocalDate startDate, LocalDate endDate);

    InternshipWeek updateDescription(String id, String description);

}
