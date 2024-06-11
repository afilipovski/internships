package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class InternshipWeek {
    @Id
    @Column(name = "id")
    private String id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;
}
