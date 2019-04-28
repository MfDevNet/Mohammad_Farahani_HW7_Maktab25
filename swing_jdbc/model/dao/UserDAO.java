package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.User;

import java.sql.SQLException;

public interface UserDAO {
    void insert(User user) throws SQLException;
    boolean delete(String UserCode) throws SQLException;
    boolean update(User user) throws SQLException;

    User find(String username) throws SQLException;

}
