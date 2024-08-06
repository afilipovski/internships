package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

import java.util.Optional;

public interface InternshipSupervisorRepository extends JpaSpecificationRepository<InternshipSupervisor, Long> {
    Optional<InternshipSupervisor> findById(String id);
    InternshipSupervisor findByEmail(String email);
}
