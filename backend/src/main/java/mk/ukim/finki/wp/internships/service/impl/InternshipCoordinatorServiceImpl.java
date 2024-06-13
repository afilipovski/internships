package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.IllegalInternshipStatusOperation;
import mk.ukim.finki.wp.internships.exception.InternshipNotFoundException;
import mk.ukim.finki.wp.internships.exception.SupervisorNotFoundException;
import mk.ukim.finki.wp.internships.exception.UserNotInternshipCoordinatorException;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipCoordinator;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.repository.internships.InternshipCoordinatorRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.service.InternshipCoordinatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class InternshipCoordinatorServiceImpl implements InternshipCoordinatorService {
    private final InternshipCoordinatorRepository internshipCoordinatorRepository;
    private final InternshipRepository internshipRepository;

    @Override
    public InternshipCoordinator findById(String id) {
        return internshipCoordinatorRepository.findById(id).orElseThrow(() -> new SupervisorNotFoundException(id));
    }

    private void changeInternshipStatus(String id, String internshipId, InternshipStatus from, InternshipStatus to) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow(() -> new InternshipNotFoundException(internshipId));

        if (internship.getStatus() != from) {
            throw new IllegalInternshipStatusOperation(from, to);
        }

        if (!internship.getCoordinator().getId().equals(id)) {
            throw new UserNotInternshipCoordinatorException(id,internshipId);
        }

        internship.setStatus(to);
        internshipRepository.save(internship);
    }

    @Override
    public void approveInternship(String id, String internshipId) {
        changeInternshipStatus(id,internshipId,InternshipStatus.PENDING_PROFFESSOR_REVIEW, InternshipStatus.DEPOSITED);
    }

    @Override
    public void revokeApprovalInternship(String id, String internshipId) {
        changeInternshipStatus(id,internshipId,InternshipStatus.DEPOSITED, InternshipStatus.PENDING_PROFFESSOR_REVIEW);
    }

    @Override
    public void assignRandom(String internshipId) {
        Internship internship = internshipRepository
                .findById(internshipId)
                .orElseThrow(() -> new InternshipNotFoundException(internshipId));

        Random random = new Random();
        List<InternshipCoordinator> coordinators = internshipCoordinatorRepository.findAll();
        InternshipCoordinator coordinator = coordinators.get(random.nextInt(0,coordinators.size()));

        internship.setCoordinator(coordinator);
        internshipRepository.save(internship);
    }
}
