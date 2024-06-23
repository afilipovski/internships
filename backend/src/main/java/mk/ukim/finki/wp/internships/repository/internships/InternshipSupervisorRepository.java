package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

public interface InternshipSupervisorRepository extends JpaSpecificationRepository<InternshipSupervisor, Long> {
    InternshipSupervisor findByEmail(String email);
}
