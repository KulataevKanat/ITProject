package kg.itProject.itProject.repository;

import kg.itProject.itProject.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p join fetch p.student s " +
            "where s.id = :studentId")
    List<Payment> getStudentPayments(@Param("studentId") Long studentId);

    @Query("select p from Payment p join fetch p.student s " +
            "where s.login = coalesce(:login, s.login) " +
            "and s.fullname = coalesce(:fullname, s.fullname) " +
            "and p.status = coalesce(:status, p.status) " +
            "")
    List<Payment> getPaymentsByParam(@Param("login") String login,
                                     @Param("fullname") String fullname,
                                     @Param("status") String status);
}
