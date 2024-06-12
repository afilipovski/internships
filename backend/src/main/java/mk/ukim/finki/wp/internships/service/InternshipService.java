package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.Internship;
import mk.ukim.finki.wp.internships.model.internships.InternshipStatus;

public interface InternshipService {
    public Internship create(String studentId, String postingId);
    public void setStatus(String id, String userId, InternshipStatus status);
    public void assignSupervisor(String id, String supervisorId);
}
