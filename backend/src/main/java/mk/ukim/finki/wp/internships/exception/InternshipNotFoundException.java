package mk.ukim.finki.wp.internships.exception;

public class InternshipNotFoundException extends EntityNotFoundException{
    public InternshipNotFoundException(String internshipId) {
        super("Internship with id " + internshipId + " not found");
    }
}
