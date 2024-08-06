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
    @Column(name="professor_id", insertable=false, updatable=false)
    private String professorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="professor_id")
    private Professor professor;


    public InternshipCoordinator(Professor professor) {
        this.professor = professor;
    }
}
