import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JFrameview3 extends JFrame implements Observer {

    private DataModel Model;
    private JPanel jp = new JPanel(); //
    private undo_button undo_btn = new undo_button("undo");
    private JPanel jp1 = new JPanel(); // for button

    public JFrameview3(DataModel model) {
        Model = model;
        undo_btn.setEnabled(false);
        undo_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                undo_btn.undo();

            }
        });
        for (int i = 0; i < 9; i++) {

            MyButton btn = new MyButton(i, Model);
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    btn.actionPerformed(e);
                    if (btn.getUndo_count() != 3) {
                        undo_btn.set_undo_button(btn);
                        undo_btn.setEnabled(true);
                    } else if (btn.getUndo_count() == 3) {
                        System.out.println("undo_count " + btn.getUndo_count());
                        undo_btn.setEnabled(false);
                        btn.setUndo_count(0);
                    }

                }
            });
            jp.add(btn);
        }

        jp.setLayout(new GridLayout(3, 3, 5, 5));
        jp1.setSize(300, 300);

        JButton style1 = new JButton("style1"); // two buttom
        JButton style2 = new JButton("style2");
        ActionListener Change = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton) e.getSource();
                if (jb.getText() == "style1") {
                    for (int i = 0; i < jp.getComponents().length; i++) {
                        MyButton mb = (MyButton) jp.getComponents()[i];
                        buttonstyle style = new ConcreteButtonStyle();

                        style.setborderline(mb);
                        style.setfont(mb);
                        style.settextcolor(mb);
                    }

                } else {
                    for (int i = 0; i < jp.getComponents().length; i++) {
                        buttonstyle style2 = new ConcreteButtonStyle2();
                        MyButton mb = (MyButton) jp.getComponents()[i];
                        style2.setborderline(mb);
                        style2.setfont(mb);
                        style2.settextcolor(mb);
                    }
                }
                remove(jp1);
                setLayout(new GridLayout(2, 1, 5, 5));
                jp.setVisible(true);

            }
        };

        style1.addActionListener(Change);
        style2.addActionListener(Change);
        jp1.add(style1);
        jp1.add(style2);
        jp.setVisible(false);

        add(jp);
        add(undo_btn);
        add(jp1);
        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void update(Observable o, Object arg) {
        undo_btn.setEnabled(false);
        if (Model.isWin()) {
            JOptionPane.showMessageDialog(null, "Win");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "draw");
            System.exit(0);
        }
        for (int i = 0; i < jp.getComponents().length; i++) {

            MyButton b = (MyButton) jp.getComponents()[i];

            b.setText("");

            b.setEnabled(false);
        }

    }
}
