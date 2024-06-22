package mk.ukim.finki.wp.internships.model.internships;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.wp.internships.model.Company;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InternshipSupervisor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Company company;

    public InternshipSupervisor(Company company) {
        this.company = company;
    }
}
