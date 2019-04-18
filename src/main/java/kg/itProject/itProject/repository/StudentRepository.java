package kg.itProject.itProject.repository;

import kg.itProject.itProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select sum(p.sum) from Payment p inner join p.student s " +
            "where s.id = :idStudent ")
    BigDecimal getContract(@Param("idStudent") Long idStudent);

    @Query("select s from Student s where s.login = :login ")
    Student getStudentByLogin(@Param("login") String login);

}
