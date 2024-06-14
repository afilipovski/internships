package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;

public interface InternshipSupervisorService {
    InternshipSupervisor create(String companyId);
    InternshipSupervisor findById(String id);

    void approveInternship(String id, String internshipId);

    void revokeApprovalInternship(String id, String internshipId);

    void assign(String id, String internshipId);
}
