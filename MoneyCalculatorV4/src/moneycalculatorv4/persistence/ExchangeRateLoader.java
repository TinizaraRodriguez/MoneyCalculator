
package moneycalculatorv4.persistence;

import moneycalculatorv4.model.Currency;
import moneycalculatorv4.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate load(Currency from, Currency to);
    
    
}
