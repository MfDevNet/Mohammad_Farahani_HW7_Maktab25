package swing_jdbc.model.dao;


import swing_jdbc.model.Entity.Student;

public interface StudentDAO {

    void insert(Student student);
    boolean delete(int StudentCode);
    boolean changeInfo(Student student);

    Student find(int StudentCode);
    Student find(String FirstName,String LastName);





}
