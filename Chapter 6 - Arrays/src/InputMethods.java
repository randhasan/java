import java.util.*;

import javax.swing.JOptionPane;

public class InputMethods {
	/**
	 * @param num1 lowest value to accept, inclusive
	 * @param num2 highest value to accept inclusive
	 * @pre:num1%lt;num2
	 * @return num%lt;= inputValue%lt;= num2
	 */
	public static int getIntBetweenJOP(int num1, int num2)
	{
		boolean done = false;
		int num = Integer.MAX_VALUE;
		
		do
		{
			try
			{
				num = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between " + num1 + " and " + num2));
				if (num>= num1 && num<=num2)
					done = true;
			}
			
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "Please enter a valid integer");
			}
		} while (!done);
		return num;
	}
	
	public static double getDoubleBetweenJOP(double num1, double num2)
	{
		boolean done = false;
		double num = Double.MAX_VALUE;
		
		do
		{
			try
			{
				double run = Double.parseDouble(JOptionPane.showInputDialog("Enter a number between " + num1 + " and " + num2));
				if (num>= num1 && num<=num2)
					done = true;
			}
			
			catch (NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "Please enter a real number");
			}
		} while (!done);
		return num;
	}

	public static int getIntBetween(int num1, int num2)
	{
		Scanner input = new Scanner(System.in);
		boolean done = false;
		int num = Integer.MAX_VALUE;
		
		do
		{
			try
			{
				System.out.print("Enter a number between " + num1 + " and " + num2 +": ");
				num = input.nextInt();
				if (num>= num1 && num<=num2)
					done = true;
			}
			
			catch (InputMismatchException ex)
			{
				input.nextLine();
				JOptionPane.showMessageDialog(null, "Please enter a valid integer");
			}
		} while (!done);
		return num;
	}
	
	/**
	 * @param min - min value to generate
	 * @param max - max value to generate
	 */
	
	public static int getRandom(int min, int max)
	{
		Random r = new Random();
		return r.nextInt((max-min)+1)+min;
	}
	
	public static String getChoiceYN(String question)
	{
		boolean done = false;
		String choice;
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.print(question+"(Enter y or n): ");
			choice = input.next().toLowerCase();
			
			if(choice.substring(0,1).equals("y"))
			{
				return "y";
			}
			else if(choice.substring(0,1).equals("n"))
			{
				return "n";
			}
			else
			{
				System.out.println("Invalid input: enter y or n");
			}
			
		} while (!done);
		return ""; //should never happen
	}
	
	
	public static String getChoiceYNJOP(String question)
	{
		if (JOptionPane.showConfirmDialog(null, question, "Choose an Option", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		{
			return "y";
		}
		else
		{
			return "n";
		}
	}
	
	
	/**
	 * Gets choice from list of values
	 * @param question to ask user
	 * @param choices of options to choose
	 * @return user's choice as an integer in the first version
	 */
	public static int menuConsole(String question, String[] choices)
	{
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do
		{
			try {
				System.out.println(question+"\n");
				for (int i = 0; i< choices.length; i++)
				{
					System.out.println(i + ". " + choices[i]);
				}
				System.out.println("/nEnter choice: ");
				choice = input.nextInt();
				if (choice < 0 || choice > choices.length-1)
					System.out.println("Error- invalid entry");
			} 
			catch (InputMismatchException ex){
				System.out.println("Error - invalid entry");
			}
		} while (choice < 0 || choice >= choices.length);
		return choice;
	}
	
	/**
	 * Gets choice from list of values
	 * @param question to ask user
	 * @param choices of options to choose
	 * @return user's choice as an integer in the first version
	 */
	public static int menuJOP(String question, String[] choices)
	{
		return JOptionPane.showOptionDialog(null, question, "Choose an option",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
		
	}
}