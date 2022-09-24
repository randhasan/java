import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author Rand Hasan, Period 11
 * 9/18/2019
 * PropertyTax.java Ch3 Decision Statements, Option A: Problem 3: Property Tax
 * Program asks what type of home the user lives in and the value of their property.
 * The program uses the input and applies a tax rate and recycling fee to output the property tax.
 */

public class PropertyTax
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner (System.in);
        String type = JOptionPane.showInputDialog(null, "Do you live in a single-family or multi-family home?");
        
        if (type.toLowerCase().equals("single-family") || type.toLowerCase().equals("multi-family"))
        {
            String value = JOptionPane.showInputDialog(null, "What is the value of your property?");
            double doubleVal = Double.parseDouble(value);
            double tax = doubleVal/100; //taxes are calculated against each $100 of the property's value
            
            if (type.toLowerCase().equals("single-family"))
            {
                tax *= 1.004;   //tax rate
                tax += 20.00;   //recycling fee
                JOptionPane.showMessageDialog(null, String.format("The property tax for your %s home with a value of $%,.2f is: $%,.2f", type.toLowerCase(), doubleVal, tax));
            }
            else if (type.toLowerCase().equals("multi-family"))
            {
                tax *= 1.054;   //tax rate
                tax += 500.00;  //recycling fee
                JOptionPane.showMessageDialog(null, String.format("The property tax for your %s home with a value of $%,.2f is: $%,.2f", type.toLowerCase(), doubleVal, tax));
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Please enter a correct type of dwelling."); //user did not enter 'single-family' or 'multi-family'
        }  
        
    }

}
