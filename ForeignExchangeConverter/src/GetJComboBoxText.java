import javax.swing.*;

public class GetJComboBoxText implements GetText{
    @Override
    public  String getText(Object object) {
        return ((JComboBox)object).getSelectedItem().toString();
    }

}
