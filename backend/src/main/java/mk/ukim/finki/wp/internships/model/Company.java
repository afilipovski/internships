package mk.ukim.finki.wp.internships.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import mk.ukim.finki.wp.internships.model.internships.InternshipPosting;

import java.util.List;

@Entity
public class Company {

    @Id
    public String id;

    public String name;

    public String phone;

    public String email;

    @Column(length = 10_000)
    public String companyDescription;

    public String websiteUrl;

    public byte[] logoImage;

    public byte[] banner;

    public Boolean active;

    @OneToMany(mappedBy="company")
    public List<InternshipPosting> postings;

}
