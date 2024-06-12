package mk.ukim.finki.wp.internships.exception;

public class UserNotInternshipSupervisorException extends BadRequestException{
    public UserNotInternshipSupervisorException(String supervisorId, String internshipId) {
        super("Internship with id " + internshipId + " does not have supervisor with id " + supervisorId);
    }
}
