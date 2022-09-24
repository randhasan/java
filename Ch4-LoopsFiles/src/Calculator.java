import java.util.*;

/*
@Rand Hasan Student, Period 11
10/4/2019
Calculator.java Ch4 Loops and Files, CHS Project 1 - A Simple Desk Calculator
This program implements a simple version of a Desk Calculator which uses postfix notation.
The first part outputs the number and character that were received. The second outputs the
the meanings of commands. The third is the implementation of the desk calculator.
*/

public class Calculator
{
    public static void main(String[] args)
    {
        try 
        {
            Scanner input = new Scanner(System.in);
            //part one
            System.out.print("Enter a number, a space, and a character: ");
            String sentence = input.nextLine();
            int space = sentence.indexOf(" ");
            double number = Double.parseDouble(sentence.substring(0,space));
            char ch = sentence.charAt((sentence.length()-1));
            System.out.println("The number is " + number);
            System.out.println("The character is " + ch + "\n");
            
            //part two
            System.out.print("Enter a number, a space, and a character: ");
            sentence = input.nextLine();
            space = sentence.indexOf(" ");
            number = Double.parseDouble(sentence.substring(0,space));
            ch = sentence.charAt((sentence.length()-1));
            if (ch=='E' || ch=='e')
            {
                System.out.println("End of Program");
            }
            while (ch!='E' && ch!='e')
            {
                if (ch == '+')
                {
                    System.out.println("Add by "+number);
                }
                else if (ch == '-')
                {
                    System.out.println("Subtract by "+number);
                }
                else if (ch == '*')
                {
                    System.out.println("Multiply by "+number);
                }
                else if (ch == '/')
                {
                    System.out.println("Divide by "+number);
                }
                else if (ch == 'S' || ch == 's') 
                {
                    System.out.println("Set accumulator to "+number);
                }
                else
                {
                    System.out.println("Invalid operator...");
                }
                if (ch!='E' && ch!='e') // loop continues
                {
                    System.out.print("Enter a number, a space, and a character: ");
                    sentence = input.nextLine();
                    space = sentence.indexOf(" ");
                    number = Double.parseDouble(sentence.substring(0,space));
                    ch = sentence.charAt((sentence.length()-1));
                }
                if (ch=='E' || ch=='e') // loop will terminate after this statement
                {
                    System.out.println("End of Program");
                }
               
            }
            
            //part three
            System.out.println("\nWelcome to my Java Simple Calculator...");
            double calcNum = 0.0;
            System.out.println("= "+calcNum);
            sentence = input.nextLine();
            space = sentence.indexOf(" ");
            number = Double.parseDouble(sentence.substring(0,space));
            ch = sentence.charAt((sentence.length()-1));
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