import java.math.BigDecimal;
import java.math.MathContext;

public class CalculateConversion {

    public static BigDecimal calculateConversion(double value, Currency currency, Currency currency2){
        double solution=0.0;
        solution=(value*currency.getAverageRate())/currency.getConversionRate()/currency2.getAverageRate()*currency2.getConversionRate();
        return new BigDecimal(solution, MathContext.DECIMAL64);
    }
}
