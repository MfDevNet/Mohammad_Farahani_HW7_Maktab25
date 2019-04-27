package swing_jdbc.model.Entity;

public class Student {
    private String studentCode;
    private String firstName;
    private String lastName;

    public Student() {
    }

    public Student(String studentCode, String firstName, String lastName) {
        this.studentCode = studentCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
