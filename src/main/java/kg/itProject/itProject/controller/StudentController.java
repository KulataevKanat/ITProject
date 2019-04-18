package kg.itProject.itProject.controller;

import kg.itProject.itProject.Entity.Student;
import kg.itProject.itProject.model.Contract;
import kg.itProject.itProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Student addStudent(@RequestBody Student s) {
        return studentService.addStudent(s);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Student changeStudent(@RequestBody Student s) {
        return studentService.changeActiveStatus(s);
    }

    @GetMapping("/contract/{id}")
    private Contract getContract(@PathVariable Long id) {
        return new Contract(studentService.getStudentbyId(id),
                studentService.getContract(id));
    }

    @GetMapping
    private List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    private Student getStudent(@PathVariable Long id) {
        return studentService.getStudentbyId(id);
    }

    @GetMapping("/check/{login}")
    private String checkStudentByLogin(@PathVariable String login) {
        return studentService.checkStudent(login);
    }


}
