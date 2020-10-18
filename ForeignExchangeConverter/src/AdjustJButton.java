import javax.swing.*;
import java.awt.*;

public class AdjustJButton implements AdjustComponent {
    @Override
    public void setComponent(LayoutManager layoutManager, JPanel jPanel, String string, Component component, boolean value) {
        MyJPanel jPanel1=new MyJPanel();
        ((JButton)component).setBackground(new Color(0,137,123));
        jPanel1.add(component);
        jPanel.add(jPanel1);

    }
}
