package mk.ukim.finki.wp.internships.web;

import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.internships.model.DTO.StudentDto;
import mk.ukim.finki.wp.internships.model.Student;
import mk.ukim.finki.wp.internships.model.StudyProgram;
import mk.ukim.finki.wp.internships.service.interfaces.StudentService;
import mk.ukim.finki.wp.internships.service.interfaces.StudyProgramService;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/students")
public class StudentController {

    private final StudentService studentService;

    private final StudyProgramService studyProgramService;

    public StudentController(StudentService studentService,
                             StudyProgramService studyProgramService) {
        this.studentService = studentService;
        this.studyProgramService = studyProgramService;
    }

    @GetMapping
    public String list(Model model,
                       @RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "20") Integer results,
                       @RequestParam(required = false) String nameOrIndex,
                       @RequestParam(name = "studyProgram", required = false) String studyProgramCode) {

        Page<Student> result = studentService.find(pageNum, results, nameOrIndex, studyProgramCode);

        model.addAttribute("page", result);


        List<StudyProgram> studyPrograms = studyProgramService.findAll();
        model.addAttribute("studyPrograms", studyPrograms);

        return "students/list";
    }


    @PostMapping("/import")
    public void importStudents(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        List<StudentDto> students = importRepository.readTypeList(file, StudentDto.class);

        List<StudentDto> invalidEnrollments = studentService.importStudents(students);

        String fileName = "invalid_students.tsv";
        response.setContentType("text/tab-separated-values");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        try (OutputStream outputStream = response.getOutputStream()) {
            importRepository.writeTypeList(StudentDto.class, invalidEnrollments, outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
