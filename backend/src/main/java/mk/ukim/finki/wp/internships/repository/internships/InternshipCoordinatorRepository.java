package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

import java.util.Optional;

public interface InternshipCoordinatorRepository extends JpaSpecificationRepository<InternshipCoordinator, Long> {
    Optional<InternshipCoordinator> findByProfessorId(String professorId);
}
