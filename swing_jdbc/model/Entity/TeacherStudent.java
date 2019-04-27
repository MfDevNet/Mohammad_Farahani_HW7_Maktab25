package swing_jdbc.model.Entity;

public class TeacherStudent {
    private String studentFirstname;
    private String studentLastName;
    private String teacherFirstname;
    private String teacherLastName;

    public TeacherStudent() {
    }

    public TeacherStudent(String studentFirstname, String studentLastName, String teacherFirstname, String teacherLastName) {
        this.studentFirstname = studentFirstname;
        this.studentLastName = studentLastName;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastName = teacherLastName;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }
}
