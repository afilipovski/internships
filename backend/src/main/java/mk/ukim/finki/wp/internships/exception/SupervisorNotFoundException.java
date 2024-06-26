package mk.ukim.finki.wp.internships.exception;

public class SupervisorNotFoundException extends EntityNotFoundException{
    public SupervisorNotFoundException(Long supervisorId) {
        super("Internship supervisor with id " + supervisorId + " not found");
    }
}
