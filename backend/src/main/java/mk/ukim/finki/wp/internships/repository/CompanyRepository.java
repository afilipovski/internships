package mk.ukim.finki.wp.internships.repository;

import mk.ukim.finki.wp.internships.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
