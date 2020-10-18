import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
    public MyJPanel() {
        super();
        this.setBackground(new Color(255,153,102));
    }

    public MyJPanel(LayoutManager layout) {
        super(layout);
        this.setBackground(new Color(255,153,102));
    }

    public MyJPanel(Dimension dimension, JFrame jFrame, String string){
        super();
        this.setBackground(new Color(255,153,102));
        this.setPreferredSize(dimension);
        jFrame.add(this,string);
    }
}