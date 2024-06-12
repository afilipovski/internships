package mk.ukim.finki.wp.internships.service.impl;

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
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipPostingRepository internshipPostingRepository;
    private final StudentRepository studentRepository;
    private final InternshipSupervisorRepository supervisorRepository;
    private final InternshipCoordinatorRepository coordinatorRepository;

    public InternshipServiceImpl(InternshipRepository internshipRepository, InternshipPostingRepository internshipPostingRepository, StudentRepository studentRepository, InternshipSupervisorRepository supervisorRepository, InternshipCoordinatorRepository coordinatorRepository) {
        this.internshipRepository = internshipRepository;
        this.internshipPostingRepository = internshipPostingRepository;
        this.studentRepository = studentRepository;
        this.supervisorRepository = supervisorRepository;
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Internship create(String studentId, String postingId) {
        Internship internship = new Internship(
            studentRepository.findById(studentId).orElseThrow(),
            internshipPostingRepository.findById(postingId).orElseThrow()
        );

        return internshipRepository.save(internship);
    }

    public void assignSupervisor(String id, String supervisorId) throws Exception {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        InternshipSupervisor supervisor = supervisorRepository.findById(supervisorId).orElseThrow();

        if (!internship.getSupervisor().getCompany().id.equals(supervisor.getCompany().id)) {
            throw new Exception();
        }

        internship.setSupervisor(supervisor);
        internshipRepository.save(internship);
    }

    // should also handle revoking approval - or be split into multiple methods
    public void setStatus(String id, String userId, InternshipStatus status) throws Exception {
        Internship internship = internshipRepository.findById(id).orElseThrow();

        if (internship.getStatus() == InternshipStatus.PENDING_COMPANY_REVIEW
                && status == InternshipStatus.PENDING_PROFFESSOR_REVIEW) {
            InternshipSupervisor supervisor = supervisorRepository.findById(userId).orElseThrow();
            if (!internship.getSupervisor().getId().equals(supervisor.getId())) {
                throw new Exception();
            }
            internship.setStatus(status);
        }
        else if (internship.getStatus() == InternshipStatus.PENDING_PROFFESSOR_REVIEW
                && status == InternshipStatus.DEPOSITED) {
            InternshipCoordinator coordinator = coordinatorRepository.findById(userId).orElseThrow();
            if (!internship.getCoordinator().getId().equals(coordinator.getId())) {
                throw new Exception();
            }
            internship.setStatus(status);
        }

        internshipRepository.save(internship);
    }
}
