import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JButton;
import java.awt.Dimension;
public class HideArrowButton extends BasicComboBoxUI{
    public JButton createArrowButton(){
        JButton btn = new JButton();
        btn.setVisible(false);
        return btn;
    }
}