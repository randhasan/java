import java.util.Scanner;

/*
@Rand Hasan
This program implements a simple version of a Desk Calculator which uses 
postfix notation.
*/

public class CalcP3
{
    public static void main(String[] args)
    {
        try 
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to my Java Simple Calculator...");
            double calcNum = 0.0;
            System.out.println("= "+calcNum);
            String sentence = input.nextLine();
            int space = sentence.indexOf(" ");
            double number = Double.parseDouble(sentence.substring(0,space));
            char ch = sentence.charAt((sentence.length()-1));
            while (ch!='E' && ch!='e')
            {
                if (ch == '+')
                {
                    calcNum += number;
                }
                else if (ch == '-')
                {
                    calcNum -= number;
                }
                else if (ch == '*')
                {
                    calcNum *= number;
                }
                else if (ch == '/')
                {
                    if (number != 0.0)
                        calcNum /= number;
                    else // cannot divide by zero
                        System.out.println("Divide by 0.0 is undefined...");
                }
                else if (ch == 'S' || ch == 's') 
                {
                    calcNum = number; // sets accumulator
                }
                else
                {
                    System.out.println("Invalid operator...");
                }
                System.out.println("= "+calcNum);
                if (ch!='E' && ch!='e')
                {
                    sentence = input.nextLine();
                    space = sentence.indexOf(" ");
                    number = Double.parseDouble(sentence.substring(0,space));
                    ch = sentence.charAt((sentence.length()-1));
                }
                if (ch=='E' || ch=='e')
                {
                    System.out.println("= "+calcNum);
                    System.out.print("End of Program");
                }
            }  
        }
        
        // exceptions so program does not crash
        catch (StringIndexOutOfBoundsException e) // user doesn't enter a space
        {
            System.out.println("Please make sure to enter a number, a space, and a character.");
        }
        catch (NumberFormatException e) // user doesn't enter a number
        {
            System.out.println("Please make sure to enter a number, a space, and a character.");
        }
    }
}
