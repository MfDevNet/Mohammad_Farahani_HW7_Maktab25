package swing_jdbc.model.dao;

import swing_jdbc.model.Entity.User;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp extends JFrame implements UserDAO {
    ConnectionToDB conn = new ConnectionToDB();

    @Override
    public void insert(User user) throws SQLException {
        conn.initConn();
        String query = "insert into user(username, password, email) VALUES (\'" + user.getUserName() + "\',\'" + user.getPassWord() + "\',\'" + user.getEmail() + "\')";
        System.out.println(query);
        conn.getStatement().executeUpdate(query);
        conn.closeConn();


    }

    /*
    delete from user where username='';
    update user set password ='' ,email='' where username='';
    select username,password,email from user where username='';
    */


    @Override
    public boolean delete(String UserCode) throws SQLException {
        conn.initConn();
        String query = "delete from user where username=\'" + UserCode + "\'";
        System.out.println(query);

        int result = conn.getStatement().executeUpdate(query);
        conn.closeConn();
        if (result == 1)
            return true;
        else return false;

    }

    @Override
    public boolean update(User user) throws SQLException {
        conn.initConn();
        String query = "update user set password = \'" + user.getPassWord() +"\', email = \'"+user.getEmail()+"\' where username = \'"+user.getUserName()+"\'";
        System.out.println(query);

        int result = conn.getStatement().executeUpdate(query);
        conn.closeConn();
        if (result == 1)
            return true;
        else return false;
    }

    @Override
    public User find(String username) throws SQLException {
        conn.initConn();
        User user=new User();
        String query ="select username,password,email from user where username=\'"+username+"\'";

        System.out.println(query);

        ResultSet rs = conn.getStatement().executeQuery(query);
        while (rs.next()){
            if (rs.getString("username").equals(username)){
                user=new User(rs.getString("username"),rs.getString("password"),rs.getString("email"));
            }
        }
        conn.closeConn();
        return user;
    }
}
