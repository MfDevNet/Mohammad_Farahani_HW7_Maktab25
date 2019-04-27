package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDAO {

    void insert(Teacher student) throws SQLException;
    boolean delete(String TeacherCode) throws SQLException;
    boolean Update(Teacher student) throws SQLException;

    Teacher find(String TeacherCode,boolean check) throws SQLException;
    List<Teacher> find(String TeacherCode, String FirstName, String LastName) throws SQLException;
}
