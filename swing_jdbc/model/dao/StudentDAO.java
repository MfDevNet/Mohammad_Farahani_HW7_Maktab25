package swing_jdbc.model.dao;


import swing_jdbc.model.Entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    void insert(Student student) throws SQLException;
    boolean delete(String StudentCode) throws SQLException;
    boolean Update(Student student) throws SQLException;

    Student find(String StudentCode,boolean check) throws SQLException;
    List<Student> find(String StudentCode,String FirstName, String LastName) throws SQLException;





}
