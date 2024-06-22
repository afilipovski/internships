package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

import java.util.List;

public interface InternshipRepository extends JpaSpecificationRepository<Internship, Long> {
    List<Internship> findAllByCoordinatorProfessorId(String professorId);
    List<Internship> findAllBySupervisorId(Long supervisorId);
    List<Internship> findAllByStudentIndex(String studentIndex);
    List<Internship> findAllByPostingCompanyId(String companyId);

    List<Internship> findAllByCoordinatorProfessorIdAndStatus(String professorId, InternshipStatus status);
    List<Internship> findAllBySupervisorIdAndStatus(Long supervisorId, InternshipStatus status);
    List<Internship> findAllByStudentIndexAndStatus(String studentIndex, InternshipStatus status);
    List<Internship> findAllByPostingCompanyIdAndStatus(String companyId, InternshipStatus status);
}
