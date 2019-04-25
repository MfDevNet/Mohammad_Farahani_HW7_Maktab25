package swing_jdbc.model.dao;


import swing_jdbc.model.Entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    void insert(Student student) throws SQLException;
    boolean delete(int StudentCode) throws SQLException;
    boolean changeInfo(Student student);

    Student find(int StudentCode) throws SQLException;
    List<Student> find(String FirstName, String LastName) throws SQLException;





}
