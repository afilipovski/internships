package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;

public interface InternshipSupervisorService {
    InternshipSupervisor create(String companyId);
    InternshipSupervisor findById(Long id);

    void approveInternship(Long id, Long internshipId);

    void revokeApprovalInternship(Long id, Long internshipId);

    void assign(Long id, Long internshipId);
}
