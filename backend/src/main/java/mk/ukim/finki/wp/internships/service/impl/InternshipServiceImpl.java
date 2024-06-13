package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.InternshipPostingNotFoundException;
import mk.ukim.finki.wp.internships.exception.StudentNotFoundException;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.repository.StudentRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipPostingRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipPostingRepository internshipPostingRepository;
    private final StudentRepository studentRepository;

    @Override
    public Internship create(String studentId, String postingId) {
        Internship internship = new Internship(
                studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId)),
                internshipPostingRepository.findById(postingId).orElseThrow(() -> new InternshipPostingNotFoundException(postingId))
        );

        return internshipRepository.save(internship);
    }


}
