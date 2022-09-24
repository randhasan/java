import java.util.Scanner;

/**
 * @author Rand Hasan, Period 11
 * 9/17/2019
 * MorseCode.java Ch3 Decision Statements, Problem 1: Morse Code
 * Program asks user for input and converts it to morse code.
 */

public class MorseCode
{
    public static void main (String[] args)
    {
        System.out.println("This program converts your message to morse code.");
        System.out.print("Enter a sentence: ");
        Scanner input = new Scanner (System.in);
        String sentence = input.nextLine().toUpperCase();
        if (sentence.length() == 0) //if user pressed enter and didn't type anything
        {
            System.out.println("Please enter a sentence."); //user must run program again and enter a sentence
        }
        else
        {
            System.out.print("Converted message: ");
            for (int i = 0; i < sentence.length(); i ++) 
            {
                char character = sentence.charAt(i);
                switch (character)
                {
                case 'A' : 
                    System.out.print(".- ");
                    break;
                case 'B' : 
                    System.out.print("-... ");
                    break;
                case 'C' : 
                    System.out.print("-.-. ");
                    break;
                case 'D' :
                    System.out.print("-.. ");
                    break;
                case 'E' : 
                    System.out.print(". ");
                    break;
                case 'F' : 
                    System.out.print("..-. ");
                    break;
                case 'G' : 
                    System.out.print("--. ");
                    break;
                case 'H' : 
                    System.out.print(".... ");
                    break;
                case 'I' : 
                    System.out.print(".. ");
                    break;
                case 'J' : 
                    System.out.print(".--- ");
                    break;
                case 'K' : 
                    System.out.print("-.- ");
                    break;
                case 'L' : 
                    System.out.print(".-.. ");
                    break;
                case 'M' : 
                    System.out.print("-- ");
                    break;
                case 'N' : 
                    System.out.print("-. ");
                    break;
                case 'O' : 
                    System.out.print("--- ");
                    break;
                case 'P' : 
                    System.out.print(".--. ");
                    break;
                case 'Q' : 
                    System.out.print("--.- ");
                    break;
                case 'R' : 
                    System.out.print(".-. ");
                    break;
                case 'S' : 
                    System.out.print("... ");
                    break;
                case 'T' : 
                    System.out.print("- ");
                    break;
                case 'U' : 
                    System.out.print("..- ");
                    break;
                case 'V' : 
                    System.out.print("... -");
                    break;
                case 'W' : 
                    System.out.print(".-- ");
                    break;
                case 'X' : 
                    System.out.print("-..- ");
                    break;
                case 'Y' : 
                    System.out.print("-.-- ");
                    break;
                case 'Z' : 
                    System.out.print("--.. ");
                    break;
                case ' ' : 
                    System.out.print("   "); //several spaces are printed to show the separation between words.
                    break;
                }
                
            }
                 
        }
        
    }
    
}

 
/**
This program converts your message to morse code.
Enter a sentence: i am rand
Converted message: ..    .- --    .-. .- -. -.. 
 */
