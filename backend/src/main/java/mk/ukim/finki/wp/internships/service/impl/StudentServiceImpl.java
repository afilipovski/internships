package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.IllegalInternshipStatusOperation;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.User;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.repository.StudentRepository;
import mk.ukim.finki.wp.internships.repository.UserRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final InternshipRepository internshipRepository;

    @Override
    public Student getStudentByUserId(String userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return studentRepository.findByEmail(user.getEmail());
    }

    @Override
    public void approveInternship(String id, Long internshipId) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow();
        if (internship.getStatus() != InternshipStatus.ONGOING) {
            throw new IllegalInternshipStatusOperation(internship.getStatus(), InternshipStatus.PENDING_COMPANY_REVIEW);
        }
        internship.setStatus(InternshipStatus.PENDING_COMPANY_REVIEW);
        internshipRepository.save(internship);
    }

    @Override
    public void revokeApprovalInternship(String id, Long internshipId) {
        Internship internship = internshipRepository.findById(internshipId).orElseThrow();
        if (internship.getStatus() != InternshipStatus.PENDING_COMPANY_REVIEW) {
            throw new IllegalInternshipStatusOperation(internship.getStatus(), InternshipStatus.ONGOING);
        }
        internship.setStatus(InternshipStatus.ONGOING);
        internshipRepository.save(internship);
    }
}
