package mk.ukim.finki.wp.internships.datainit;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.*;
import mk.ukim.finki.wp.internships.repository.StudentRepository;
import mk.ukim.finki.wp.internships.repository.StudyProgramRepository;
import mk.ukim.finki.wp.internships.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudyProgramRepository studyProgramRepository;


    @PostConstruct
    void addStudents() {
        if (!studentRepository.findAll().isEmpty()) {
            return;
        }

        Student s1 = new Student();
        s1.setEmail("aleksandar.filipovski@students.finki.ukim.mk");
        s1.setIndex("211999");
        s1.setName("Александар");
        s1.setLastName("Филиповски");
        s1.setParentName("pn1");
        s1.setStudyProgram(studyProgramRepository.findAll().getFirst());
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setEmail("vasil.strezov@students.finki.ukim.mk");
        s2.setIndex("213999");
        s2.setName("Васил");
        s2.setLastName("Стрезов");
        s2.setParentName("pn2");
        s2.setStudyProgram(studyProgramRepository.findAll().getFirst());
        studentRepository.save(s2);

        Student s3 = new Student();
        s3.setEmail("luka.krstikj@students.finki.ukim.mk");
        s3.setIndex("214999");
        s3.setName("Лука");
        s3.setLastName("Крстиќ");
        s3.setParentName("pn3");
        s3.setStudyProgram(studyProgramRepository.findAll().getFirst());
        studentRepository.save(s3);

        Student s4 = new Student();
        s4.setEmail("dimitrij.krstev@students.finki.ukim.mk");
        s4.setIndex("216999");
        s4.setName("Димитриј");
        s4.setLastName("Крстев");
        s4.setParentName("pn4");
        s4.setStudyProgram(studyProgramRepository.findAll().getFirst());
        studentRepository.save(s4);

        User user1 = new User();
        user1.setId("aleksandar.filipovski");
        user1.setEmail("aleksandar.filipovski@students.finki.ukim.mk");
        user1.setRole(UserRole.STUDENT);
        user1.setName("Александар Филиповски");
        userRepository.save(user1);

        User user2 = new User();
        user2.setId("vasil.strezov");
        user2.setEmail("vasil.strezov@students.finki.ukim.mk");
        user2.setRole(UserRole.STUDENT);
        user2.setName("Васил Стрезов");
        userRepository.save(user2);

        User user3 = new User();
        user3.setId("luka.krstikj");
        user3.setEmail("luka.krstikj@students.finki.ukim.mk");
        user3.setRole(UserRole.STUDENT);
        user3.setName("Лука Крстиќ");
        userRepository.save(user3);

        User user4 = new User();
        user4.setId("dimitrij.krstev");
        user4.setEmail("dimitrij.krstev@students.finki.ukim.mk");
        user4.setRole(UserRole.STUDENT);
        user4.setName("Димитриј Крстев");
        userRepository.save(user4);
    }
}
