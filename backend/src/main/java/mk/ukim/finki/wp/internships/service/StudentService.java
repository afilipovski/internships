package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.Student;

public interface StudentService {
    Student getStudentByUserId(String userId);

    Student getStudentByIndex(String index);

    void approveInternship(String id, Long internshipId);

    void revokeApprovalInternship(String id, Long internshipId);
}
