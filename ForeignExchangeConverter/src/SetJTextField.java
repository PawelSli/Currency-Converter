import javax.swing.*;

public class SetJTextField implements SetText{
    @Override
    public void setText(Object object,String string){
        ((JTextField)object).setText(string);
    }
}
