import java.awt.event.ActionEvent;

public class undo_button extends abstractbutton {

    private MyButton Btn;
    private int state;

    public undo_button(String str) {
        setText(str);
    }

    public void set_undo_button(MyButton btn) {
        Btn = btn;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void actionPerformed(ActionEvent event) {
        undo();
    }

    @Override
    public void undo() {
        if (Btn == null)
            return;
        Btn.undo();
        setEnabled(false);
        System.out.println(Btn.getUndo_count());
    }

}
