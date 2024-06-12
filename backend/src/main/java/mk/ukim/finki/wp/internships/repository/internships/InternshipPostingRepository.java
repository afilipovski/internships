package mk.ukim.finki.wp.internships.repository.internships;

import mk.ukim.finki.wp.internships.model.internships.InternshipPosting;
import mk.ukim.finki.wp.internships.repository.JpaSpecificationRepository;

import java.util.List;

public interface InternshipPostingRepository extends JpaSpecificationRepository<InternshipPosting, String> {
    public List<InternshipPosting> findAllByCompanyId(String companyId);
}
