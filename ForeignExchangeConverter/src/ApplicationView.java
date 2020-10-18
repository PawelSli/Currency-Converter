import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ApplicationView extends JFrame {

    private JButton jButton=new JButton("Przelicz wartość");
    private JTextField jTextField=new JTextField(12);
    private JTextField jTextField2=new JTextField(12);
    private JComboBox jComboBox;
    private JComboBox jComboBox2;
    private boolean firstTime=true;

    public JTextField getjTextField() {
        return jTextField;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JComboBox getjComboBox() {
        return jComboBox;
    }

    public JComboBox getjComboBox2() {
        return jComboBox2;
    }

    public void addConversionListener(ActionListener actionListener){
        jButton.addActionListener(actionListener);
    }




    public ApplicationView(String[] countryNames){
        JFrame jFrame=new JFrame("Przelicznik walutowy");
        jFrame.setSize(500,350);
        jFrame.setLayout(new BorderLayout());
        jComboBox=new JComboBox(countryNames);
        jComboBox2=new JComboBox(countryNames);
        AdjustComponent adjustComponent=new AdjustJButton();
        AdjustComponent adjustComponentTwo=new AdjustJComboBox();
        AdjustComponent adjustComponentThree=new AdjustJTextField();
        GetJTextFieldText getJTextFieldText=new GetJTextFieldText();
        SetJTextField setJTextField=new SetJTextField();


        MyJPanel main=new MyJPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));

        adjustComponentTwo.setComponent(new FlowLayout(),main,"Waluta źródłowa :",jComboBox,true);
        adjustComponentTwo.setComponent(new FlowLayout(),main,"Waluta docelowa :",jComboBox2,true);
        adjustComponentThree.setComponent(new FlowLayout(),main,"Wprowadź kwotę :",jTextField,true);
        adjustComponent.setComponent(null,main,null,jButton,true);
        adjustComponentThree.setComponent(null,main,"Wyliczona kwota :",jTextField2,false);
        jTextField.addKeyListener(new CheckDigits(jTextField));

        MyJPanel jPanelStart=new MyJPanel(new Dimension(500,50),jFrame,BorderLayout.PAGE_START);
        MyJPanel jLineStart=new MyJPanel(new Dimension(50,300),jFrame,BorderLayout.LINE_START);
        jFrame.add(main,BorderLayout.CENTER);
        MyJPanel jLineEnd=new MyJPanel(new Dimension(50,300),jFrame,BorderLayout.LINE_END);
        MyJPanel jPageEnd=new MyJPanel(new Dimension(500,50),jFrame,BorderLayout.PAGE_END);


        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }


}
