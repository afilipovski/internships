package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;

public interface InternshipCoordinatorService {
    InternshipCoordinator create(String professorId);

    InternshipCoordinator delete(Long id);

    InternshipCoordinator findById(Long id);

    void approveInternship(Long id, Long internshipId);

    void revokeApprovalInternship(Long id, Long internshipId);

    void assignRandom(Long internshipId);
}
