package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImp implements TeacherDAO {
    ConnectionToDB connection = new ConnectionToDB();
    @Override
    public void insert(Teacher teacher) throws SQLException {
        connection.initConn();
        String query = "insert into teachers(teachercode, firstname, lastname)values(\'" + teacher.getTeacherCode() + "\',\'" + teacher.getFirstName() + "\',\'" + teacher.getLastName() + "\')";
        System.out.println(query);
        connection.getStatement().executeUpdate(query);
        connection.closeConn();
    }

    @Override
    public boolean delete(String TeacherCode) throws SQLException {
        connection.initConn();
        int result = 0;
        if (find(TeacherCode, true) != null) {
            connection.initConn();
            String query = "delete from teachers where teachercode = " + TeacherCode;
            System.out.println(query);
            result = connection.getStatement().executeUpdate(query);
        }
        connection.closeConn();
        if (result == 1) return true;
        else return false;
    }


    @Override
    public boolean Update(Teacher teacher) throws SQLException {
        connection.initConn();
        int result = 0;
        if (find(teacher.getTeacherCode(), true) != null) {
            String query = "update teachers set firstname =\'" + teacher.getFirstName() + "\', lastname =\'" + teacher.getLastName() + "\' where teachercode = " + teacher.getTeacherCode();
            System.out.println(1);
            System.out.println(query);
            connection.initConn();
            result=connection.getStatement().executeUpdate(query);
        }
        connection.closeConn();
        if (result == 1) return true;
        return false;    }

    @Override
    public Teacher find(String TeacherCode,boolean check) throws SQLException {
        connection.initConn();
        Teacher teacher = null;
        String query = null;
        if (check == true) {
            query = "select teachercode,firstname,lastname from teachers  where teachercode = " + TeacherCode;
        } else {
            query = "select teachercode,firstname,lastname from teachers where teachercode like '" + TeacherCode + "%'";
        }
        System.out.println(query);
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next()) {
            teacher = new Teacher(rs.getString("teachercode"), rs.getString("firstname"), rs.getString("lastname"));
        }

        connection.closeConn();
        return teacher;    }

    @Override
    public List<Teacher> find(String TeacherCode, String FirstName, String LastName) throws SQLException {
        connection.initConn();
        List<Teacher> teacherList = new ArrayList<>();
        String query = null;
        if (!FirstName.equals("") && !LastName.equals("")) {
            query = "SELECT teachercode,firstname,lastname FROM teachers where firstname ='" + FirstName + "' and lastname = '" + LastName + "';\n";
        } else if (FirstName.equals("") && !LastName.equals("")) {
            query = "SELECT teachercode,firstname,lastname FROM teachers where lastname like \'" + LastName + "%\'";
        } else if (!FirstName.equals("") && LastName.equals("")) {
            query = "SELECT teachercode,firstname,lastname FROM teachers where firstname like \'" + FirstName + "%\'";
        }
        System.out.println(query);
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next())
            teacherList.add(new Teacher(rs.getString("teachercode"),
                    rs.getString("firstname"), rs.getString("lastname")));


        connection.closeConn();
        return teacherList;    }

    public List<Teacher> show() throws SQLException {

        connection.initConn();
        List<Teacher> teacherList = new ArrayList<>();
        String query = "SELECT teachercode,firstname,lastname FROM teachers ";
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next()) {
            teacherList.add(new Teacher(rs.getString("teachercode"),
                    rs.getString("firstname"), rs.getString("lastname")));
        }

        connection.closeConn();
        return teacherList;
    }




}
