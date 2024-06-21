package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import mk.ukim.finki.wp.internships.model.Company;

@Entity
@Getter
public class InternshipPosting {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    private Company company;

    private Integer plannedWeeks;

    private String position;

    private String description;
}
