package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.*;
import mk.ukim.finki.wp.internships.model.Company;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.repository.CompanyRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipSupervisorRepository;
import mk.ukim.finki.wp.internships.service.InternshipSupervisorService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternshipSupervisorServiceImpl implements InternshipSupervisorService {
    private final InternshipSupervisorRepository supervisorRepository;
    private final InternshipRepository internshipRepository;
    private final CompanyRepository companyRepository;

    @Override
    public InternshipSupervisor create(String companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException(companyId));

        InternshipSupervisor supervisor = new InternshipSupervisor(company);

        return supervisorRepository.save(supervisor);
    }

    @Override
    public InternshipSupervisor findById(String id) {
        return supervisorRepository.findById(id).orElseThrow(() -> new SupervisorNotFoundException(id));
    }

    private void changeInternshipStatus(String id, String internshipId, InternshipStatus from, InternshipStatus to) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow(() -> new InternshipNotFoundException(internshipId));

        if (internship.getStatus() != from) {
            throw new IllegalInternshipStatusOperation(from, to);
        }

        if (!internship.getSupervisor().getId().equals(id)) {
            throw new UserNotInternshipSupervisorException(id,internshipId);
        }

        internship.setStatus(to);
        internshipRepository.save(internship);
    }

    @Override
    public void approveInternship(String id, String internshipId) {
        changeInternshipStatus(id,internshipId,InternshipStatus.PENDING_COMPANY_REVIEW, InternshipStatus.PENDING_PROFFESSOR_REVIEW);
    }

    @Override
    public void revokeApprovalInternship(String id, String internshipId) {
        changeInternshipStatus(id,internshipId,InternshipStatus.PENDING_PROFFESSOR_REVIEW, InternshipStatus.PENDING_COMPANY_REVIEW);
    }

    @Override
    public void assign(String id, String internshipId) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow(() -> new InternshipNotFoundException(internshipId));
        InternshipSupervisor supervisor = supervisorRepository.findById(id).orElseThrow(() -> new SupervisorNotFoundException(id));

        if (!internship.getSupervisor().getCompany().id.equals(supervisor.getCompany().id)) {
            throw new SupervisorCompanyWithInternshipCompanyMismatchException(id,
                    internship.getSupervisor().getCompany().id, internshipId);
        }

        internship.setSupervisor(supervisor);
        internshipRepository.save(internship);
    }
}
