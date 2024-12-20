package mk.ukim.finki.wp.internships.service;

import mk.ukim.finki.wp.internships.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company findById(String id);

    void save(String id, String name, String phone, String email, String description,String websiteUrl, byte[] logoImage,byte[] banner,boolean active);

    void edit(String id,String name, String phone, String email, String companyDescription,String websiteUrl, byte[] logoImage,byte[] banner,boolean active);

}
