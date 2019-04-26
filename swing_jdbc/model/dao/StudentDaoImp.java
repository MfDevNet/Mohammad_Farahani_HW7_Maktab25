package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentDAO {
    ConnectionToDB connection = new ConnectionToDB();

    @Override
    public void insert(Student student) throws SQLException {
        connection.initConn();
        String query = "insert into students(studentcode, firstname, lastname)values(" + student.getStudentCode() + ",\'" + student.getFirstName() + "\',\'" + student.getLastName() + "\')";
        System.out.println(query);


        connection.getStatement().executeUpdate(query);
        connection.closeConn();
    }

    @Override
    public boolean delete(int StudentCode) throws SQLException {
        connection.initConn();
        int result = 0;
        if (find(StudentCode) != null) {
            String query = "delete from students where studentcode = " + StudentCode;
            result = connection.getStatement().executeUpdate(query);
        }
        connection.closeConn();
        if (result == 1) return true;
        else return false;
    }

    @Override
    public boolean changeInfo(Student student) {

        return false;
    }

    @Override
    public Student find(int StudentCode) throws SQLException {
        connection.initConn();
        Student student = null;

//        String query = "select studentcode,firstname,lastname from students where studentcode = " + StudentCode;
        String query = "select studentcode,firstname,lastname from students where studentcode LIKE '"+ StudentCode+"%'";
        System.out.println(query);
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next())
            student = new Student(rs.getInt("studentcode"), rs.getString("firstname"), rs.getString("lastname"));


        connection.closeConn();
        return student;
    }

    @Override
    public List<Student> find(String FirstName, String LastName) throws SQLException {
        connection.initConn();
        List<Student> listStudent = new ArrayList<>();
        String query = null;
        if (!FirstName.equals("") && !LastName.equals("")) {
            query = "SELECT studentcode,firstname,lastname FROM students where firstname ='" + FirstName + "' and lastname = '" + LastName + "';\n";
        } else if (FirstName.equals("") && !LastName.equals("")) {
            query = "SELECT studentcode,firstname,lastname FROM students where lastname like \'" + LastName + "%\'";
        } else if (!FirstName.equals("") && LastName.equals("")) {
            query = "SELECT studentcode,firstname,lastname FROM students where firstname like \'" + FirstName + "%\'";
        }
        System.out.println(query);
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next())
            listStudent.add(new Student(rs.getInt("studentcode"),
                    rs.getString("firstname"), rs.getString("lastname")));


        connection.closeConn();
        return listStudent;
    }

    public List<Student> show() throws SQLException {

        connection.initConn();
        List<Student> listStudent = new ArrayList<>();
        String query = "SELECT studentcode,firstname,lastname FROM students ";
        ResultSet rs = connection.getStatement().executeQuery(query);

        while (rs.next()) {
            listStudent.add(new Student(rs.getInt("studentcode"),
                    rs.getString("firstname"), rs.getString("lastname")));
        }

        connection.closeConn();
        return listStudent;
    }

}
