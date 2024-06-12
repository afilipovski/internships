package mk.ukim.finki.wp.internships.exception;

public class CompanyNotFoundException extends EntityNotFoundException {
    public CompanyNotFoundException(Long entityId) {
        super("Company with id " + entityId + " not found");
    }
}