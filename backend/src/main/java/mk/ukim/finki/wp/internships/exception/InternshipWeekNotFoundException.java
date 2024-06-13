package mk.ukim.finki.wp.internships.exception;

public class InternshipWeekNotFoundException extends EntityNotFoundException {
    public InternshipWeekNotFoundException(String id) {
        super("Internship week with id " + id + " not found");
    }
}
