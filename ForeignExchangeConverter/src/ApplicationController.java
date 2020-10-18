import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Key;

public class ApplicationController {
    private  ApplicationView applicationView;
    private  ApplicationModel applicationModel;
    private CalculationListener calculationListener;
    private CurrencyList currencyList;
    private  Currency currency;
    private  Currency currency2;


    public ApplicationController() throws IOException, SAXException, ParserConfigurationException {
        this.currencyList=new CurrencyList();
        this.applicationView=new ApplicationView(CurrencyReturn.returnNames(currencyList));
        this.applicationModel=new ApplicationModel();
        this.calculationListener=new CalculationListener(applicationView,applicationModel,currency,currency2,currencyList);
        this.applicationView.addConversionListener(calculationListener);
    }

}
