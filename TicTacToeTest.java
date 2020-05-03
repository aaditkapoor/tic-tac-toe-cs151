import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToeTest {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        JFrameview3 jf = new JFrameview3(model);
        model.addObserver(jf);
    }
}
