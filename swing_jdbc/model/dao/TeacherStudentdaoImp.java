package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Student;
import swing_jdbc.model.Entity.Teacher;
import swing_jdbc.model.Entity.TeacherStudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeacherStudentdaoImp implements TeacherStudentDAO {
    ConnectionToDB connection = new ConnectionToDB();

    @Override
    public void insert(Student student, Teacher teacher) throws SQLException {

    }

    @Override
    public boolean link(String StudentCode, String TeacherCode) throws SQLException {
        connection.initConn();
        String query = "insert into ths(thcode, stcode) VALUES (\'" + TeacherCode + "\',\'" + StudentCode + "\')";
        System.out.println(query);
        int result = connection.getStatement().executeUpdate(query);
        connection.closeConn();

        if (result == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean unlink(String StudentCode, String TeacherCode) throws SQLException {
        connection.initConn();
        String query = "delete from  ths where stcode =\'"+StudentCode+"\' and thcode =\'"+TeacherCode+"\'";
        System.out.println(query);
        int result = connection.getStatement().executeUpdate(query);
        connection.closeConn();

        if (result == 1)
            return true;
        else
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
            System.out.println(1);
            teacherStudents.add(new TeacherStudent(rs.getString("stfname"),
                    rs.getString("stlname"), rs.getString("thfname"), rs.getString("thlname")));
        }
        System.out.println(Arrays.toString(new List[]{teacherStudents}));
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
