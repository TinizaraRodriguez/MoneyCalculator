
package moneycalculatorv4;

import moneycalculatorv4.persistence.CurrencyListLoader;
import moneycalculatorv4.persistence.ExchangeRateLoader;
import moneycalculatorv4.persistence.file.FileCurrencyListLoader;
import moneycalculatorv4.persistence.rest.RestExchangeRateLoader;

public class MoneyCalculatorV4 {

    public static void main(String[] args) {
        CurrencyListLoader currencyListLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        
        MoneyCalculatorFrame moneyCalculatorFrame = new MoneyCalculatorFrame(currencyListLoader.currencies());
        
        
        
    }
    
}
