package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.User;

public interface UserDAO {
    void insert(User user);
    boolean delete(int UserCode);
    boolean changeInfo(User user);

    User find(String username);

}
