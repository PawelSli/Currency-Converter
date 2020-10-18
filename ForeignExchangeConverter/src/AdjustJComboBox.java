import javax.swing.*;
import java.awt.*;

public class AdjustJComboBox implements AdjustComponent{
    @Override
    public void setComponent(LayoutManager layoutManager, JPanel jPanel, String string, Component component,boolean value) {
        MyJPanel jPanel1=new MyJPanel(layoutManager);
        JLabel jLabel=new JLabel(string);
        jLabel.setLabelFor(component);
        jPanel1.add(jLabel);
        jPanel1.add(component);
        jPanel.add(jPanel1);
    }
}
