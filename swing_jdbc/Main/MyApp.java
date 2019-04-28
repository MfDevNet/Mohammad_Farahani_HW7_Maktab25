package swing_jdbc.Main;

import swing_jdbc.view.Login;
import swing_jdbc.view.StudentsView;

import javax.swing.*;
import java.sql.SQLException;

public class MyApp {
    public static void main(String[] args) throws SQLException {
        new Login().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new Login().setVisible(true);


    }
}
