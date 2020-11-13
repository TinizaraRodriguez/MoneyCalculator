
package moneycalculatorv4.persistence.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import moneycalculatorv4.model.Currency;
import moneycalculatorv4.model.ExchangeRate;
import moneycalculatorv4.persistence.ExchangeRateLoader;

public class RestExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try{
            return new ExchangeRate (from, to, read (from.getCode(), to.getCode()));
        }catch (MalformedURLException exception){
            System.out.println("ERROR: MAL FORMED URL " + exception.getMessage());
            return null;
        }catch (IOException exception){
            System.out.println("ERROR: LOAD IO" + exception.getMessage());
            return null;
        }
    }
    
    private double read (String from, String to) throws MalformedURLException, IOException {
        String line = read (new URL ("https://api.fixer.io/latest?base=" + from + "$symbols=" + to));
        return Double.parseDouble (line.substring(line.indexOf(to) + 5, line.indexOf(" } ")));
    }
    
    private String read (URL url) throws IOException{
        InputStream is = url.openStream();
        byte [] buffer = new byte [1024];
        int length = is.read(buffer);
        return new String (buffer, 0, length);
    }
    
    
}
