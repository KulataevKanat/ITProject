package kg.itProject.itProject.model;

import kg.itProject.itProject.Entity.Student;

import java.math.BigDecimal;

public class Contract {
    private Student student;
    private BigDecimal contract;

    public Contract() {

    }

    public Contract(Student student, BigDecimal contract) {
        this.student = student;
        this.contract = contract;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public BigDecimal getContract() {
        return contract;
    }

    public void setContract(BigDecimal contract) {
        this.contract = contract;
    }
}
