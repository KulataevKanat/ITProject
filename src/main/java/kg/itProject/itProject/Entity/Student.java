package kg.itProject.itProject.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idStudent;

    private String login;

    private String fullname;

    private boolean isActive;

    public Student() {
    }

    public Student(long idStudent, String login, String fullname, boolean isActive) {
        this.idStudent = idStudent;
        this.login = login;
        this.fullname = fullname;
        this.isActive = isActive;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
