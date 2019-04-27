package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Student;
import swing_jdbc.model.Entity.Teacher;
import swing_jdbc.model.Entity.TeacherStudent;

import java.sql.SQLException;
import java.util.List;

public interface TeacherStudentDAO {
    void insert(Student student, Teacher teacher) throws SQLException;
    boolean delete(String StudentCode,String TeacherCode) throws SQLException;
    boolean Update(Student student, Teacher teacher) throws SQLException;

    List<TeacherStudent> findStudnet(String TeacherCode, boolean check) throws SQLException;
    List<TeacherStudent> findTeacher(String StudentCode, boolean check) throws SQLException;


}
