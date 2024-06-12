package mk.ukim.finki.wp.internships.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProfessorNotFoundException extends EntityNotFoundException {
    public ProfessorNotFoundException(Long professorId) {
        super("Professor with id " + professorId + " not found");
    }
}

