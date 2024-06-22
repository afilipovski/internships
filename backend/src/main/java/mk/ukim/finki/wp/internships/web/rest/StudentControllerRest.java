package mk.ukim.finki.wp.internships.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentControllerRest {

//    private final StudentService studentService;
//
//    private final StudyProgramService studyProgramService;
//
//    public StudentController(StudentService studentService,
//                             StudyProgramService studyProgramService) {
//        this.studentService = studentService;
//        this.studyProgramService = studyProgramService;
//    }
//
//    @GetMapping
//    public String list(Model model,
//                       @RequestParam(defaultValue = "1") Integer pageNum,
//                       @RequestParam(defaultValue = "20") Integer results,
//                       @RequestParam(required = false) String nameOrIndex,
//                       @RequestParam(name = "studyProgram", required = false) String studyProgramCode) {
//
//        Page<Student> result = studentService.find(pageNum, results, nameOrIndex, studyProgramCode);
//
//        model.addAttribute("page", result);
//
//
//        List<StudyProgram> studyPrograms = studyProgramService.findAll();
//        model.addAttribute("studyPrograms", studyPrograms);
//
//        return "students/list";
//    }
//
//
//    @PostMapping("/import")
//    public void importStudents(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
//        List<StudentDto> students = importRepository.readTypeList(file, StudentDto.class);
//
//        List<StudentDto> invalidEnrollments = studentService.importStudents(students);
//
//        String fileName = "invalid_students.tsv";
//        response.setContentType("text/tab-separated-values");
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//
//        try (OutputStream outputStream = response.getOutputStream()) {
//            importRepository.writeTypeList(StudentDto.class, invalidEnrollments, outputStream);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
