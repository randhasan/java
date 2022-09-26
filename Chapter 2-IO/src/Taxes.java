import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rand Hasan
 * Taxes.java
 * Program takes input of the user's annual salary to display a table of values
 * displaying the gross pay, taxes, and net pay for several different pay schedules.
 */

public class Taxes {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        final double TAX_RATE = .31; // constant used to find the amount user must pay in taxes based on their gross pay
        DecimalFormat df = new DecimalFormat("$#,###.00");
        
        try
        {
        System.out.print("Enter annual salary: ");
        double annualSalary = input.nextDouble();
        System.out.println("With your annual salary of " + df.format(annualSalary) + " you can use the table of values to \nfind your gross pay, taxes, and net pay for the following pay schedules."); // using DecimalFormat class
        
        System.out.printf("\n%s\t\t\t %s\t\t %s\t\t %s\n", "Paid", "Gross", "Taxes", "Net Pay"); //using formatting zones
        double taxes = annualSalary*TAX_RATE;
        System.out.printf("%-24s $%-,14.2f $%-,14.2f $%-,20.2f\n", "Annually", annualSalary, taxes, annualSalary-taxes); //using formatting zones
        taxes = (annualSalary/12)*TAX_RATE;
        System.out.printf("%-24s $%-,14.2f $%-,14.2f $%-,20.2f\n", "Monthly", annualSalary/12, taxes, (annualSalary/12)-taxes); //using formatting zones
        taxes = (annualSalary/24)*TAX_RATE;
        System.out.printf("%-24s $%-,14.2f $%-,14.2f $%-,20.2f\n", "Semi-Monthly", annualSalary/24, taxes, (annualSalary/24)-taxes); //using formatting zones
        taxes = (annualSalary/26)*TAX_RATE;
        System.out.printf("%-24s $%-,14.2f $%-,14.2f $%-,20.2f\n", "Bi-Weekly", annualSalary/26, taxes, (annualSalary/26)-taxes); //using formatting zones
        taxes = (annualSalary/52)*TAX_RATE;
        System.out.printf("%-24s $%-,14.2f $%-,14.2f $%-,20.2f\n", "Weekly", annualSalary/52, taxes, (annualSalary/52)-taxes); //using formatting zones
        }
        
        catch(InputMismatchException ex)
        {
            System.out.println("Please enter valid number.");
        }
    }

}

/**
Enter annual salary: 125000
With your annual salary of $125,000.00 you can use the table of values to find 
your gross pay, taxes, and net pay for the following pay schedules.

Paid                     Gross           Taxes           Net Pay
Annually                 $125,000.00     $38,750.00      $86,250.00           
Monthly                  $10,416.67      $3,229.17       $7,187.50            
Semi-Monthly             $5,208.33       $1,614.58       $3,593.75            
Bi-Weekly                $4,807.69       $1,490.38       $3,317.31            
Weekly                   $2,403.85       $745.19         $1,658.65  
 */
