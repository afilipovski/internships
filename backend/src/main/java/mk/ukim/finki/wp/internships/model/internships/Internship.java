package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.wp.internships.model.Student;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Internship {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    private InternshipSupervisor supervisor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne
    private InternshipCoordinator coordinator;

    @Enumerated(EnumType.STRING)
    private InternshipStatus status;

    @OneToMany(mappedBy = "internship")
    private List<InternshipWeek> journal;

    @ManyToOne
    private InternshipPosting posting;

    public Internship(Student student, InternshipPosting posting) {
        this.student = student;
        this.posting = posting;
    }
}
