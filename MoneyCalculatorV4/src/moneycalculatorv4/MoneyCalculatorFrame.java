
package moneycalculatorv4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculatorv4.model.Currency;
import moneycalculatorv4.ui.MoneyDialog;
import moneycalculatorv4.ui.MoneyDisplay;
import moneycalculatorv4.ui.swing.SwingMoneyDialog;
import moneycalculatorv4.ui.swing.SwingMoneyDisplay;

public class MoneyCalculatorFrame extends JFrame {
    private final List<Currency> currencies;
    
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    
    public MoneyCalculatorFrame (List<Currency>currencies){
        this.currencies = currencies;
        this.setTitle("MONEY CALCULATOR ");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(moneyDialog(currencies), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.SOUTH);
        this.add(toolbar(), BorderLayout.NORTH);
        this.setVisible(true);
   
    }

    private Component moneyDialog(List<Currency> currencies) {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog(currencies);
        this.moneyDialog = swingMoneyDialog;
        return swingMoneyDialog;
        
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay= new SwingMoneyDisplay ();
        this.moneyDisplay= swingMoneyDisplay;
        return swingMoneyDisplay;
        
        
    }

    private Component toolbar() {
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.add(calculate());
        return toolbarPanel;
    }

    private JButton calculateButton() {
        JButton button = new JButton ("calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate(){
        return new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent actionEvent){
                
            }
        };
    }
    
}
