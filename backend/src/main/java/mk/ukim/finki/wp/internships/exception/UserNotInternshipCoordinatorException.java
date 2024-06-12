package mk.ukim.finki.wp.internships.exception;

public class UserNotInternshipCoordinatorException extends BadRequestException{
    public UserNotInternshipCoordinatorException(String coordinatorId, String internshipId) {
        super("Internship with id " + internshipId + " does not have coordinator with id " + coordinatorId);
    }
}
