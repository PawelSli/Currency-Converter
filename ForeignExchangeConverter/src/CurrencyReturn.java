public class CurrencyReturn {
    public static String[] returnNames(CurrencyList currencyList){
        return currencyList.getCurrencyMap().keySet().toArray(new String[0]);
    }
}
