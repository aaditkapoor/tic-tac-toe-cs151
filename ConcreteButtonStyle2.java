import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ConcreteButtonStyle2 implements buttonstyle {

    @Override
    public void setfont(JButton btn) {
        btn.setFont(new Font("Calibri", Font.ITALIC, 15));
    }

    @Override
    public void setborderline(JButton btn) {
        btn.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    @Override
    public void settextcolor(JButton btn) {
        btn.setForeground(Color.RED);

    }

}
