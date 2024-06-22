package mk.ukim.finki.wp.internships.exception;

public class SupervisorCompanyWithInternshipCompanyMismatchException extends BadRequestException{
    public SupervisorCompanyWithInternshipCompanyMismatchException(Long supervisorId, String supervisorCompanyId, Long internshipId) {
        super("Supervisor with id " + supervisorId + " and company id " + supervisorCompanyId +
                " has different company than internship with id " + internshipId);
    }
}
