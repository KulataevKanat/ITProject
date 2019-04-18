package kg.itProject.itProject.bootstrap;

import kg.itProject.itProject.Entity.Student;
import kg.itProject.itProject.repository.StudentRepository;
import kg.itProject.itProject.service.PaymentService;
import kg.itProject.itProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrap implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setFullname("Kanat");
        s1.setActive(true);
        s1.setLogin("Login_Kanat");
        studentService.addStudent(s1);

        Student s2 = new Student();
        s2.setFullname("Bektur");
        s2.setActive(true);
        s2.setLogin("Login_Bektur");
        studentService.addStudent(s2);

//        Student s3 = new Student();
//        s3.setFullname("");
//        s3.setActive(true);
    }
}
