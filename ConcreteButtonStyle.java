import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ConcreteButtonStyle implements buttonstyle {

    @Override
    public void setfont(JButton btn) {

        btn.setFont(new Font("Arial", Font.BOLD, 11));

    }

    @Override
    public void setborderline(JButton btn) {
        btn.setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public void settextcolor(JButton btn) {
        btn.setForeground(Color.RED);
    }

}
