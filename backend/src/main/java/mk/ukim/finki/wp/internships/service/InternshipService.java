package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.internships.Internship;

public interface InternshipService {
    Internship create(String studentId, String postingId);
}
