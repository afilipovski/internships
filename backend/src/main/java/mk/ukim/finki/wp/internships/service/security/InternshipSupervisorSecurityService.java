package mk.ukim.finki.wp.internships.service.security;

import mk.ukim.finki.wp.internships.config.FacultyUserDetails;
import mk.ukim.finki.wp.internships.model.internships.InternshipSupervisor;
import org.springframework.stereotype.Service;

@Service
public class InternshipSupervisorSecurityService {

    public boolean checkIfRequesterIsApartOfSupervisorsCompany(InternshipSupervisor supervisor){
        FacultyUserDetails userDetails = SecurityUtil.getAuthUserDetails();

        return userDetails.getSupervisor() != null &&
                supervisor.getCompany().equals(userDetails.getSupervisor().getCompany());
    }
}
