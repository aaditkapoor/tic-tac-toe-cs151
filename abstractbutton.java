import java.awt.event.ActionEvent;

import javax.swing.JButton;

public abstract class abstractbutton extends JButton {
    protected int btn_No;
    static protected int opositionaction = 0;
    static protected int undo_count = 0;

    public static int getOpositionaction() {
        return opositionaction;
    }

    public static void setOpositionaction(int opositionaction) {
        abstractbutton.opositionaction = opositionaction;
    }

    public int getBtn_No() {
        return btn_No;
    }

    public void setBtn_No(int btn_No) {
        this.btn_No = btn_No;
    }

    public void setopposition() {
        if (opositionaction == 0) {
            opositionaction = 1;

        } else {
            opositionaction = 0;
        }
    }

    public abstract void undo();
}
