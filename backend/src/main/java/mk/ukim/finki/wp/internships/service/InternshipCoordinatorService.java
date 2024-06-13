package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;

public interface InternshipCoordinatorService {
    InternshipCoordinator findById(String id);

    void approveInternship(String id, String internshipId);

    void revokeApprovalInternship(String id, String internshipId);

    void assignRandom(String internshipId);
}
