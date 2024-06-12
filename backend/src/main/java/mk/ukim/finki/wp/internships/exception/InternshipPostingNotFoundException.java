package mk.ukim.finki.wp.internships.exception;

public class InternshipPostingNotFoundException extends EntityNotFoundException{
    public InternshipPostingNotFoundException(String internshipPostingId) {
        super("Internship Posting with id " + internshipPostingId + " not found");
    }
}
