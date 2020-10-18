import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationListener implements ActionListener {
    private ApplicationView applicationView;
    private ApplicationModel applicationModel;
    private Currency currency;
    private Currency currency2;
    private CurrencyList currencyList;

    public CalculationListener(ApplicationView applicationView,ApplicationModel applicationModel,Currency currency,Currency currency2,CurrencyList currencyList){
        this.applicationView=applicationView;
        this.applicationModel=applicationModel;
        this.currency=currency;
        this.currency2=currency2;
        this.currencyList=currencyList;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        GetText getText=new GetJComboBoxText();
        GetText getText1=new GetJTextFieldText();
        SetText setText=new SetJTextField();
        String temp=getText.getText(applicationView.getjComboBox());
        String temp2=getText.getText(applicationView.getjComboBox2());
        int index=currencyList.getCurrencyMap().get(temp);
        int index2=currencyList.getCurrencyMap().get(temp2);
        try {
            currency=applicationModel.extractData(index);
            currency2=applicationModel.extractData(index2);
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (SAXException saxException) {
            saxException.printStackTrace();
        }
        if(CheckIfNumber.isNumeric(getText1.getText(applicationView.getjTextField()),applicationView)){
            double value=Double.parseDouble(getText1.getText(applicationView.getjTextField()));
            BigDecimal solution=CalculateConversion.calculateConversion(value,currency,currency2);
            setText.setText(applicationView.getjTextField2(),String.valueOf(solution.setScale(2,RoundingMode.HALF_UP)));
        }
    }
}
