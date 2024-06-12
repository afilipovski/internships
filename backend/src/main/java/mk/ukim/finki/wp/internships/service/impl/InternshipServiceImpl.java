package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.*;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import mk.ukim.finki.wp.internships.repository.StudentRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipCoordinatorRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipPostingRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipSupervisorRepository;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipPostingRepository internshipPostingRepository;
    private final StudentRepository studentRepository;
    private final InternshipSupervisorRepository supervisorRepository;
    private final InternshipCoordinatorRepository coordinatorRepository;

    @Override
    public Internship create(String studentId, String postingId) {
        Internship internship = new Internship(
                studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId)),
                internshipPostingRepository.findById(postingId).orElseThrow(() -> new InternshipPostingNotFoundException(postingId))
        );

        return internshipRepository.save(internship);
    }

    @Override
    public void assignSupervisor(String internshipId, String supervisorId) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow(() -> new InternshipNotFoundException(internshipId));
        InternshipSupervisor supervisor = supervisorRepository.findById(supervisorId).orElseThrow(() -> new SupervisorNotFoundException(supervisorId));

        if (!internship.getSupervisor().getCompany().id.equals(supervisor.getCompany().id)) {
            throw new SupervisorCompanyWithInternshipCompanyMismatchException(supervisorId,
                    internship.getSupervisor().getCompany().id, internshipId);
        }

        internship.setSupervisor(supervisor);
        internshipRepository.save(internship);
    }

    // should also handle revoking approval - or be split into multiple methods
    @Override
    public void setStatus(String internshipId, String userId, InternshipStatus status) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow(() -> new InternshipNotFoundException(internshipId));

        if (internship.getStatus() == InternshipStatus.PENDING_COMPANY_REVIEW
                && status == InternshipStatus.PENDING_PROFFESSOR_REVIEW) {
            InternshipSupervisor supervisor = supervisorRepository.findById(userId).orElseThrow(() -> new SupervisorNotFoundException(userId));
            if (!internship.getSupervisor().getId().equals(supervisor.getId())) {
                throw new UserNotInternshipSupervisorException(supervisor.getId(), internshipId);
            }
            internship.setStatus(status);
        }

        else if (internship.getStatus() == InternshipStatus.PENDING_PROFFESSOR_REVIEW
                && status == InternshipStatus.DEPOSITED) {
            InternshipCoordinator coordinator = coordinatorRepository.findById(userId).orElseThrow(() -> new CoordinatorNotFoundException(userId));
            if (!internship.getCoordinator().getId().equals(coordinator.getId())) {
                throw new UserNotInternshipCoordinatorException(coordinator.getId(), internshipId);
            }
            internship.setStatus(status);
        }

        internshipRepository.save(internship);
    }
}
