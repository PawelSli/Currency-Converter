import javax.swing.*;

public class CheckIfNumber {
    public static boolean isNumeric(String text, JFrame jFrame){
        if(text==null){
            JOptionPane.showMessageDialog(jFrame,"Wprowadź dane!");
            return false;
        }
        try{
            double d=Double.parseDouble(text);

        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(jFrame,"Wprowadź liczbe całkowitą lub zmiennoprzecinkową bez odstępów!");
            return false;
        }
        return true;
    }
}
