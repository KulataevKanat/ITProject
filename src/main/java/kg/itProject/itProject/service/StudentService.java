package kg.itProject.itProject.service;

import kg.itProject.itProject.Entity.Student;

import java.math.BigDecimal;
import java.util.List;

public interface StudentService {

    Student addStudent(Student s);

    List<Student> getAllStudents();

    Student changeActiveStatus(Student s);

    BigDecimal getContract(Long id);

    Student getStudentbyId(Long id);

    Student getStudentByLogin(String login);

    String checkStudent(String login);

}
