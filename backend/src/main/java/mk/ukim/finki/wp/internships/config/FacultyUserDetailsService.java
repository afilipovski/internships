package mk.ukim.finki.wp.internships.config;

import mk.ukim.finki.wp.internships.model.Professor;
import mk.ukim.finki.wp.internships.model.User;
import mk.ukim.finki.wp.internships.exception.InvalidUsernameException;
import mk.ukim.finki.wp.internships.exception.ProfessorNotFoundException;
import mk.ukim.finki.wp.internships.repository.ProfessorRepository;
import mk.ukim.finki.wp.internships.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FacultyUserDetailsService implements UserDetailsService {

    @Value("${system.authentication.password}")
    String systemAuthenticationPassword;

    final UserRepository userRepository;

    final ProfessorRepository professorRepository;

    final PasswordEncoder passwordEncoder;

    public FacultyUserDetailsService(UserRepository userRepository, ProfessorRepository professorRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.professorRepository = professorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElseThrow(InvalidUsernameException::new);
        if (user.getRole().isProfessor()) {
            Professor professor = professorRepository.findById(username).orElseThrow(ProfessorNotFoundException::new);
            return new FacultyUserDetails(user, professor, passwordEncoder.encode(systemAuthenticationPassword));
        } else {
            return new FacultyUserDetails(user, passwordEncoder.encode(systemAuthenticationPassword));
        }
    }
}
