package swing_jdbc.model.dao;

public class Teacher {
    private int teacherCode;
    private String firstName;
    private String lastName;

    public Teacher() {
    }

    public Teacher(int teacherCode, String firstName, String lastName) {
        this.teacherCode = teacherCode;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(int teacherCode) {
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
