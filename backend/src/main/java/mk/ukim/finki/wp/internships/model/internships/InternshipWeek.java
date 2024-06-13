package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Setter
public class InternshipWeek {

    @Id
    @Column(name = "id")
    private String id;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;
    public InternshipWeek(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
