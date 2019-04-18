package kg.itProject.itProject.service;

import kg.itProject.itProject.Entity.Student;
import kg.itProject.itProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student changeActiveStatus(Student s) {
        s.setActive(!s.isActive());
        return studentRepository.save(s);
    }

    @Override
    public BigDecimal getContract(Long id) {
        return studentRepository.getContract(id);
    }

    @Override
    public Student getStudentbyId(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student getStudentByLogin(String login) {
        return studentRepository.getStudentByLogin(login);
    }

    @Override
    public String checkStudent(String login) {
        Student student = studentRepository.getStudentByLogin(login);
        if (student != null) {
            return student.getFullname();
        } else {
            return "Student not found";
        }
    }
}
