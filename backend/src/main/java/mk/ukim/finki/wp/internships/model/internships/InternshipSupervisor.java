package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import mk.ukim.finki.wp.internships.model.Company;

@Entity
public class InternshipSupervisor {
    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    private Company company;
}
