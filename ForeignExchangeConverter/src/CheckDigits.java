import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckDigits extends KeyAdapter {
    private JTextField jTextField;
    public CheckDigits(JTextField jTextField){
        this.jTextField=jTextField;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if((e.getKeyChar()>='0'&&e.getKeyChar()<='9')||(e.getKeyChar()=='.')||(e.getKeyChar()=='\b')){
            jTextField.setEditable(true);
        }else{
            jTextField.setEditable(false);
        }
    }
}
