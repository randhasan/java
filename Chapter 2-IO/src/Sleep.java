import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rand Hasan, Period 11
 * 9/8/2019
 * Sleep.java Ch2 Input, Problem 2: Sleep
 * Program calculates number of hours of your life that you've spent sleeping.
 */


public class Sleep {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        try
        {
            System.out.print("Enter year born: ");
            int yearBorn = input.nextInt();
            System.out.print("Enter month # born: ");
            int monthBorn = input.nextInt();
            System.out.print("Enter day # of month born: ");
            int dayBorn = input.nextInt();
            
            System.out.print("\nEnter current year: ");
            int currentYear = input.nextInt();
            System.out.print("Enter current month #: ");
            int currentMonth = input.nextInt();
            System.out.print("Enter current day #: ");
            int currentDay = input.nextInt();
            
            int daysAlive = ((currentYear-yearBorn)*365)+(currentMonth*30+currentDay)-(monthBorn*30+dayBorn);
            System.out.format("\nYou have been alive for %,d days.", daysAlive);
            System.out.format("\nYou have slept for %,d hours.", daysAlive*8);
        }
        
        catch(InputMismatchException ex)
        {
            System.out.println("Please enter a valid number.");
        }
        
    }

}

/**
Enter year born: 1996
Enter month # born: 9
Enter day # of month born: 8

Enter current year: 2015
Enter current month #: 2
Enter current day #: 4

You have been alive for 6,721 days.
You have slept for 53,768 hours.
 */