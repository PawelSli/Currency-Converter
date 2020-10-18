import javax.swing.*;

public class GetJTextFieldText implements GetText{
    @Override
    public String getText(Object object) {
        JTextField jTextField=(JTextField) object;
        return jTextField.getText();
    }
}
