package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.User;

import java.util.List;

@Entity
public class Internship {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    private InternshipSupervisor supervisor;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private User studentAdmin;

    @Enumerated
    private InternshipStatus status;

    @OneToMany
    private List<InternshipWeek> journal;

    @ManyToOne
    private InternshipPosting posting;
}
