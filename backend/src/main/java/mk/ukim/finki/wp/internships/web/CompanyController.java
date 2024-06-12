package mk.ukim.finki.wp.internships.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.exception.CompanyNotFoundException;
import mk.ukim.finki.wp.internships.model.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@ControllerAdvice
@RestController("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public List<Company> list(){
        return companyRepository.findAll();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompany(@PathVariable Long companyId){
        Company company = companyRepository.findCompanyById(companyId)
                .orElse(() -> new CompanyNotFoundException(companyId));
        return ResponseEntity.ok(company);
    }
}
