package mk.ukim.finki.wp.internships.model.enums;

public enum AppRole {
    PROFESSOR, ADMIN, GUEST;


    public String roleName() {
        return "ROLE_" + this.name();
    }
}
