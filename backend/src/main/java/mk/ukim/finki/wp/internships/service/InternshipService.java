package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;

import java.util.List;

public interface InternshipService {
    Internship create(String studentId, String postingId);

    Internship delete(String id);

    List<Internship> findAllByStudentIndex(String studentId);

    List<Internship> findAllBySupervisorId(String supervisorId);

    List<Internship> findAllByProfessorId(String coordinatorId);

    List<Internship> findAllByStudentIdAndStatus(String studentId, InternshipStatus status);

    List<Internship> findAllBySupervisorIdAndStatus(String supervisorId, InternshipStatus status);

    List<Internship> findAllByProfessorIdAndStatus(String coordinatorId, InternshipStatus status);

    Internship findById(String id);

    void addInternshipWeek(String id, String weekId);


}
