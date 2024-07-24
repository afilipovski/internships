package mk.ukim.finki.wp.internships.web.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentControllerRest {
    private final StudentService studentService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Student> getStudentByUserId(@PathVariable String userId) {
        Student student = studentService.getStudentByUserId(userId);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Student> getStudentByIndex(@PathVariable String index) {
        Student student = studentService.getStudentByIndex(index);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}/approve-internship/{internshipId}")
    public ResponseEntity<Void> approveInternship(@PathVariable String id, @PathVariable Long internshipId) {
        studentService.approveInternship(id, internshipId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/revoke-internship-approval/{internshipId}")
    public ResponseEntity<Void> revokeApprovalInternship(@PathVariable String id, @PathVariable Long internshipId) {
        studentService.revokeApprovalInternship(id, internshipId);
        return ResponseEntity.noContent().build();
    }
}
