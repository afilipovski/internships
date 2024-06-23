package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;

import java.util.List;

public interface InternshipSupervisorService {
    InternshipSupervisor create(String companyId, String email, String fullName);

    InternshipSupervisor findById(Long id);

    void approveInternship(Long id, Long internshipId);

    void revokeApprovalInternship(Long id, Long internshipId);

    void assign(Long id, Long internshipId);

    List<InternshipSupervisor> findAll();

    void save(InternshipSupervisor supervisor);

    void update(InternshipSupervisor supervisor);
}
