package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.wp.internships.model.Professor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InternshipCoordinator {
    @Id
    @Column(name = "id")
    private String id;


    @OneToOne
    private Professor professor;
    public InternshipCoordinator(Professor professor) {
        this.professor = professor;
    }
}
