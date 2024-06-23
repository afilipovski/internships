package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.Student;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Internship {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private InternshipSupervisor supervisor;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Professor professor;

    @Enumerated(EnumType.STRING)
    @NonNull
    private InternshipStatus status;

    @OneToMany(mappedBy = "internship",cascade = CascadeType.ALL)
    private List<InternshipWeek> journal;

    @ManyToOne
    private InternshipPosting posting;

    public Internship(Student student, InternshipPosting posting) {
        this.student = student;
        this.posting = posting;
    }
}
