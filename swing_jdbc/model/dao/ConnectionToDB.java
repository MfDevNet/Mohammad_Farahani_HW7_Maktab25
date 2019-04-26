package swing_jdbc.model.dao;

import java.sql.*;

public class ConnectionToDB {

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection conn;
    private static Statement statement;
    private static ResultSet rs;

    public Connection getConn() {

        return conn;

    }

    public  Statement getStatement() {
        return statement;
    }

    public  void initConn() throws SQLException {

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = conn.createStatement();

    }

    public  void closeConn() throws SQLException {

        statement.close();
        conn.close();
    }
}
