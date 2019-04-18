package kg.itProject.itProject.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idContract;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    private BigDecimal sum;

    private String status;

    private LocalDateTime localDateTime;

    public Payment() {

    }

    public Payment(long idContract, Student student, BigDecimal sum, String status) {
        this.idContract = idContract;
        this.student = student;
        this.sum = sum;
        this.status = status;
        this.localDateTime = LocalDateTime.now();
    }

    public Payment(Student student, BigDecimal sum) {
        this.student = student;
        this.sum = sum;
        this.localDateTime = LocalDateTime.now();
        if (this.sum.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.ZERO)) {
            this.status = "Оплата успешно завершена";
        } else {
            this.status = "Ошибка";
        }
    }

    public long getIdContract() {
        return idContract;
    }

    public void setIdContract(long idContract) {
        this.idContract = idContract;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
