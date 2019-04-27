package swing_jdbc.model.Entity;

public class Teacher {
    private String teacherCode;
    private String firstName;
    private String lastName;

    public Teacher() {
    }

    public Teacher(String teacherCode, String firstName, String lastName) {
        this.teacherCode = teacherCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
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
