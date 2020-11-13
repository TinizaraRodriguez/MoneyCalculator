
package moneycalculatorv4.persistence.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import moneycalculatorv4.model.Currency;
import moneycalculatorv4.persistence.CurrencyListLoader;

public class FileCurrencyListLoader implements CurrencyListLoader {
    private final String fileName;
    
    public FileCurrencyListLoader (String fileName){
        this.fileName = fileName;
       
    }
    
     private Currency currencyOf(String line) {
        String [] splitedData = line.split(" , ");
        return new Currency (splitedData[0], splitedData[1], splitedData[2]);
    }

    @Override
    public List<Currency> currencies() {
        List <Currency> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader (new FileReader (new File (this.fileName)));
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                list.add (currencyOf(line));
            }
        }catch (FileNotFoundException exception){
            System.out.println("ERROR File not found" + exception.getMessage());
        }catch (IOException exception){
            System.out.println("ERROR: IO" + exception.getMessage());
        }
        
        return list;
    }

   
    
    
}
