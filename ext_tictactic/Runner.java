package ext_tictactic;

import java.awt.*;

public class Runner {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new TicTacTic().setVisible(true));
    }
}
