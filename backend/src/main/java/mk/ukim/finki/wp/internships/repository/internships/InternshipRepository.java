package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

import java.util.List;

public interface InternshipRepository extends JpaSpecificationRepository<Internship, String> {
    public List<Internship> findAllByCoordinatorProfessorId(String professorId);
    public List<Internship> findAllBySupervisorId(String supervisorId);
    public List<Internship> findAllByStudentIndex(String studentIndex);
    public List<Internship> findAllByPostingCompanyId(String companyId);

    public List<Internship> findAllByCoordinatorProfessorIdAndStatus(String professorId, InternshipStatus status);
    public List<Internship> findAllBySupervisorIdAndStatus(String supervisorId, InternshipStatus status);
    public List<Internship> findAllByStudentIndexAndStatus(String studentIndex, InternshipStatus status);
    public List<Internship> findAllByPostingCompanyIdAndStatus(String companyId, InternshipStatus status);
}
