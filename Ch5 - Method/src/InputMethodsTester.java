import java.util.Scanner;

import javax.swing.JOptionPane; 

/**
 * @author Valerie Klosky
 * @since 10/09/2019
 * 
 * File to test static methods in class InputMethods
 * <strong>Note:</strong> that all methods in InputMethods are static, so methods are called with 
 * the class name, not with a declared object.
 *
 */
public class InputMethodsTester
{



	public static void main(String[] args) 
	{
		int min, max, randomNum = 0;		//minimum and maximum random number
		Scanner input = new Scanner (System.in);
		
		//Test Integer inputs
		min = InputMethods.getIntBetween(1,100);
		
	
	
		max = InputMethods.getIntBetweenJOP(min,100);
		
		System.out.println("Min is " + min + "\nMax is "+max);
	
		//test random numbers
		
		randomNum = InputMethods.getRandom(min, max);
		System.out.println("The Random number is: " + randomNum);
		
		/*
		//Test double inputs
		JOptionPane.showMessageDialog(null, "Enter investment amount");
		double money= InputMethods.getDoubleBetweenJOP(500, 1000);
		System.out.printf("Money invested: $%.2f%n",money );
		
	
		double doubleVal = InputMethods.getDoubleBetween(2.5, 2.6);
		System.out.println("You entered: " + doubleVal);
		
		*/

		if (InputMethods.getChoiceYN("\nIs today your birthday?").equals("y"))
			System.out.println("\nHappy Birthday!");
		
		if(InputMethods.getChoiceYNJOP("Is it raining outside?").equals("y"))
			JOptionPane.showMessageDialog(null, "That's too bad");
		else 
			JOptionPane.showMessageDialog(null, "Enjoy your day!");
		

		String[] choices= {"Monday","Tuesday","Wednesday","Thursday","Friday"};
		
		//if(InputMethods.menuJOP("On what day is Christmas this year?", choices)==2)
		//	JOptionPane.showMessageDialog(null, "Fa la la la la, la la la la!");
		//else 
		//{
		//	JOptionPane.showMessageDialog(null, "Bah Humbug!");
		//}
		
		if(InputMethods.menuConsole("On what day is Thanksgiving this year?", choices)==3)
			System.out.println("You are so smart!");
		else
			System.out.println("Gobble gobble...you missed turkey day!");
		
	}
	
	
	
}
