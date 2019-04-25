package swing_jdbc.model.dao;

import java.sql.*;

public class ConnectionToDB {

        void conn() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs;
        }
}
