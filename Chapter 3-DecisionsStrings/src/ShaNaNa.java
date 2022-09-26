import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rand Hasan
 * ShaNaNa.java
 * Program takes in three words of input from the user and asks the user to choose
 * an option (1-4).  Based on the option chosen, a variation of the three words
 * is outputted.
 */

public class ShaNaNa
{
    public static void main(String[] args)
    {
        System.out.println("Sha-Na-Na");
        System.out.println("-------------------");
        System.out.print("Enter a line of text (three words): ");
        
        Scanner input = new Scanner (System.in);
        String sentence = input.nextLine();
        int spaceCount = 0;
        for (int i = 0; i < sentence.length(); i++)
        {
            char character = sentence.charAt(i);
            if (character == ' ')
                spaceCount++;
        }
        
        if (spaceCount == 2) //two spaces means there are three words
        {
            int space1 = sentence.indexOf(" ");
            int space2 = sentence.lastIndexOf(" ");
            try //makes sure user enters a valid option
            {
                System.out.println("\nSelect an option (1-4): ");
                System.out.println("\n1 - sha");
                System.out.println("2 - na");
                System.out.println("3 - sha na na");
                System.out.println("4 - ava");
                System.out.print("\nYour choice: ");
                String option = input.nextLine();
                int optionNum = Integer.parseInt(option);
                System.out.println("");
                
                if (optionNum<=4 && optionNum>=1) //if the option is in the range (1-4)
                {
                    switch (optionNum)
                    {
                    case 1: //add 'sha' to the beginning of every word
                        System.out.print("sha" + sentence.substring(0, space1+1) + "sha" + sentence.substring(space1+1, space2+1) + "sha" + sentence.substring(space2+1));
                        break; 
                    case 2: //add 'na' to the end of every word
                        System.out.print(sentence.substring(0, space1) + "na" + sentence.substring(space1, space2) + "na" + sentence.substring(space2) + "na");
                        break;
                    case 3: //add 'sha' to the beginning and 'na na' to the end of every word
                        System.out.print("sha" + sentence.substring(0, space1) + "na na sha" + sentence.substring(space1+1, space2) + "na na sha" + sentence.substring(space2+1) + "na na");
                        break;
                    case 4: //move first letter to end of the word and add ava to the end of the word
                        System.out.print(sentence.substring(1, space1) + sentence.substring(0,1) + "ava " + sentence.substring(space1+2, space2) + sentence.substring(space1+1, space1+2) + "ava " + sentence.substring(space2+2) + sentence.substring(space2+1, space2+2) + "ava");
                        break;
                    }
                }
                
                else //if the option is not in the range (1-4)
                {
                    System.out.print("Please choose an option in the range (1-4).");
                }
                
            }
            
            catch (NumberFormatException ex) //user enters an invalid option (not a number)
            {
                System.out.print("\nPlease enter a valid option (1-4).");
            }
            
        }
        
        else //user enters less or more than three words
        {
            System.out.print("\nPlease enter a sentence with three words.");
        }  
    }
}

/**
Sha-Na-Na
-------------------
Enter a line of text (three words): Java programming language

Select an option (1-4): 

1 - sha
2 - na
3 - sha na na
4 - ava

Your choice: 2

Javana programmingna languagena
 */
