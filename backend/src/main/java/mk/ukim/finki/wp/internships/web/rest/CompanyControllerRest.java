package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@ControllerAdvice
@RestController("/company")
public class CompanyControllerRest {
//    private final CompanyService companyService;
//
//    @GetMapping
//    public List<Company> list(){
//        return companyRepository.findAll();
//    }
//
//    @GetMapping("/{companyId}")
//    public ResponseEntity<Company> getCompany(@PathVariable String companyId){
//        Company company = companyRepository.findCompanyById(companyId)
//                .orElse(() -> new CompanyNotFoundException(companyId));
//        return ResponseEntity.ok(company);
//    }
}
