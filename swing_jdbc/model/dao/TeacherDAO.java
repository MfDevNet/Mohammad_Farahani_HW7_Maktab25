package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.Teacher;

public interface TeacherDAO {

    void insert(Teacher student);
    boolean delete(int TeacherCode);
    boolean changeInfo(Teacher student);

    Teacher find(int TeacherCode);
    Teacher find(String FirstName,String LastName);
}
