package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Student;
import swing_jdbc.model.Entity.Teacher;
import swing_jdbc.model.Entity.TeacherStudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherStudentdaoImp implements TeacherStudentDAO {
    ConnectionToDB connection = new ConnectionToDB();

    @Override
    public void insert(Student student, Teacher teacher) throws SQLException {

    }

    @Override
    public boolean delete(String StudentCode, String TeacherCode) throws SQLException {
        return false;
    }

    @Override
    public boolean Update(Student student, Teacher teacher) throws SQLException {
        return false;
    }

    @Override
    public List<TeacherStudent> findStudnet(String TeacherCode, boolean check) throws SQLException {
        connection.initConn();
        List<TeacherStudent> teacherStudents = new ArrayList<>();
        String query = "select  students.firstname as stfname,students.lastname as stlname,teachers.firstname as thfname,teachers.lastname as thlname from students join ths on students.studentcode = ths.stcode join teachers on ths.thcode = teachers.teachercode where teachers.teachercode =\'" + TeacherCode + "\'";
        ResultSet rs = connection.getStatement().executeQuery(query);
        System.out.println(query);
        while (rs.next()) {
            teacherStudents.add(new TeacherStudent(rs.getString("stfname"),
                    rs.getString("stlname"), rs.getString("thfname"), rs.getString("thlname")));
        }

        connection.closeConn();
        return teacherStudents;
    }

    @Override
    public List<TeacherStudent> findTeacher(String StudentCode, boolean check) throws SQLException {
        connection.initConn();
        List<TeacherStudent> teacherStudents = new ArrayList<>();
        String query = "select  students.firstname as stfname,students.lastname as stlname,teachers.firstname as thfname,teachers.lastname as thlname from students join ths on students.studentcode = ths.stcode join teachers on ths.thcode = teachers.teachercode where students.studentcode =\'" + StudentCode + "\'";
        ResultSet rs = connection.getStatement().executeQuery(query);
        System.out.println(query);
        while (rs.next()) {
            teacherStudents.add(new TeacherStudent(rs.getString("stfname"),
                    rs.getString("stlname"), rs.getString("thfname"), rs.getString("thlname")));
        }

        connection.closeConn();
        return teacherStudents;
    }


    public List<TeacherStudent> show() throws SQLException {

        connection.initConn();
        List<TeacherStudent> teacherStudents = new ArrayList<>();
        String query = "select  students.firstname as stfname,students.lastname as stlname,teachers.firstname as thfname,teachers.lastname as thlname from students join ths on students.studentcode = ths.stcode join teachers on ths.thcode = teachers.teachercode ";
        ResultSet rs = connection.getStatement().executeQuery(query);
        while (rs.next()) {
            teacherStudents.add(new TeacherStudent(rs.getString("stfname"),
                    rs.getString("stlname"), rs.getString("thfname"), rs.getString("thlname")));
        }

        connection.closeConn();
        return teacherStudents;
    }
}
