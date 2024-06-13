package mk.ukim.finki.wp.internships.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.InternshipNotFoundException;
import mk.ukim.finki.wp.internships.exception.InternshipPostingNotFoundException;
import mk.ukim.finki.wp.internships.exception.InternshipWeekNotFoundException;
import mk.ukim.finki.wp.internships.exception.StudentNotFoundException;
import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;
import mk.ukim.finki.wp.internships.model.internships.InternshipWeek;
import mk.ukim.finki.wp.internships.repository.StudentRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipPostingRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipRepository;
import mk.ukim.finki.wp.internships.repository.internships.InternshipWeekRepository;
import mk.ukim.finki.wp.internships.service.InternshipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipPostingRepository internshipPostingRepository;
    private final StudentRepository studentRepository;
    private final InternshipWeekRepository weekRepository;

    @Override
    public Internship create(String studentId, String postingId) {
        Internship internship = new Internship(
                studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentId)),
                internshipPostingRepository.findById(postingId).orElseThrow(() -> new InternshipPostingNotFoundException(postingId))
        );

        return internshipRepository.save(internship);
    }

    @Override
    public List<Internship> findAllByStudentIndex(String studentIndex) {
        return internshipRepository.findAllByStudentIndex(studentIndex);
    }

    @Override
    public List<Internship> findAllBySupervisorId(String supervisorId) {
        return internshipRepository.findAllBySupervisorId(supervisorId);
    }

    @Override
    public List<Internship> findAllByProfessorId(String professorId) {
        return internshipRepository.findAllByCoordinatorProfessorId(professorId);
    }

    @Override
    public List<Internship> findAllByStudentIdAndStatus(String studentId, InternshipStatus status) {
        return internshipRepository.findAllByStudentIndexAndStatus(studentId,status);
    }

    @Override
    public List<Internship> findAllBySupervisorIdAndStatus(String supervisorId, InternshipStatus status) {
        return internshipRepository.findAllBySupervisorIdAndStatus(supervisorId,status);
    }

    @Override
    public List<Internship> findAllByProfessorIdAndStatus(String professorId, InternshipStatus status) {
        return internshipRepository.findAllByCoordinatorProfessorIdAndStatus(professorId,status);
    }

    @Override
    public Internship findById(String id) {
        return internshipRepository.findById(id).orElseThrow(() -> new InternshipNotFoundException(id));
    }

    @Override
    public void addInternshipWeek(String id, String weekId) {
        InternshipWeek week = weekRepository.findById(weekId).orElseThrow(() -> new InternshipWeekNotFoundException(weekId));

        Internship internship = findById(id);

        internship.getJournal().add(week);

        internshipRepository.save(internship);
    }


}
