package swing_jdbc.Main;

import swing_jdbc.view.StudentsView;

import java.sql.SQLException;

public class MyApp {
    public static void main(String[] args) throws SQLException {
        new StudentsView().setVisible(true);
    }
}
