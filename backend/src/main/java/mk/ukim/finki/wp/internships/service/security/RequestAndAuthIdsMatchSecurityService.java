package mk.ukim.finki.wp.internships.service.security;

import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import org.springframework.stereotype.Service;

@Service
public class RequestAndAuthIdsMatchSecurityService {
    public boolean check(String requestId) {
        FacultyUserDetails userDetails = SecurityUtil.getAuthUserDetails();

        String authId = null;
        if (userDetails.getProfessor() != null) authId = userDetails.getProfessor().getId();
        else if (userDetails.getSupervisor() != null) authId = userDetails.getSupervisor().getId().toString();
        else if (userDetails.getStudent() != null) authId = userDetails.getStudent().getIndex();

        System.out.println("ALOOOOOOOOOOOOOOO");
        System.out.println(requestId);
        System.out.println(authId);

        return requestId.equals(authId);
    }
}
