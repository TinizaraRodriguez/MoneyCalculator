
package moneycalculatorv4.model;

public class ExchangeRate {
    
    private final Currency from, to;
    private  final double amount;
    
    public ExchangeRate (Currency from, Currency to, double amount){
        
        this.from = from;
        this.amount = amount;
        this.to = to;
         
    }
    
    public Currency getFrom(){
        return from;
    }
    
    public Currency getTo(){
        return to;
    }
    
    public double getAmount(){
        return amount;
    }
    
    
}
