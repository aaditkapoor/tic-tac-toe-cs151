import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class MyButton extends abstractbutton {

    private DataModel Model;
    private int pre_player = 0;

    public int getCurrentplayer() {
        return opositionaction;
    }

    public void setCurrentplayer(int currentplayer) {
        opositionaction = currentplayer;
    }

    public MyButton(int btn_no, DataModel model) {
        btn_No = btn_no;
        Model = model;
        setText("");
        undo_count = 0;
    }

    public MyButton(String str, MyButton btn) {
        setText(str);
    }

    public void actionPerformed(ActionEvent event) {
        if (opositionaction == 0) {
            setText("X");
            if (pre_player != opositionaction) {
                pre_player = opositionaction;
                undo_count = 0;
            }

            Model.set_model(btn_No, 0);

        } else {
            setText("O");
            if (pre_player != opositionaction) {
                pre_player = opositionaction;
                undo_count = 0;
            }
            Model.set_model(btn_No, 1);
        }
        setopposition();
        setEnabled(false);
    }

    @Override
    public void undo() {
        setText("");
        setopposition();
        setEnabled(true);
        Model.undo();
        undo_count++;

    }

    public int getUndo_count() {
        return undo_count;
    }

    public void setUndo_count(int count) {
        undo_count = count;
    }

}
