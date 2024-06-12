package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.wp.internships.model.Professor;

@Entity
@Getter
public class InternshipCoordinator {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    private Professor professor;
}
