import javax.swing.*;
import java.awt.*;

public class AdjustJTextField implements AdjustComponent {
    @Override
    public void setComponent(LayoutManager layoutManager, JPanel jPanel, String string, Component component,boolean value) {
        MyJPanel jPanel1=(layoutManager==null)?new MyJPanel():new MyJPanel(layoutManager);
        JLabel jLabel=new JLabel(string);
        jLabel.setLabelFor(component);
        ((JTextField)component).setEditable(value);
        jPanel1.add(jLabel);
        jPanel1.add(component);
        jPanel.add(jPanel1);
    }
}
