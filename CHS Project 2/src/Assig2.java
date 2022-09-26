import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rand Hasan
 * Assig2.java
 * This is the main program for the game of Roulette itself.  It allows the user to play the game of
 * Roulette in a user-friendly way.
*/

public class Assig2 {
	
	public static void main(String[] args) {
		RoulettePlayer player = getPlayer();
		double initialMoney = player.getMoney(); //initialized at a random value just so while loop runs
		double bet = 0.0;
		while (initialMoney!=0) {
			int rounds = -1; //starts at -1 in case they quit so the number of rounds will be 0
			boolean quit = false;
			double winnings = 0.0;
			while (quit == false)
			{
				double money = player.getMoney();
				if (money > 0)
				{
					rounds ++;
					while (bet == -1 || bet == 0) //if bet == -1 then user wants to quit and if bet == 0 then user's bet was not within a valid range
					{
						bet = getBet(money);
						if (bet == -1.0) //user typed 0 meaning they want to quit
						{
							quit = true;
							break;
						}
					}
					if(bet!=-1.0)
					{
						winnings = getGuess(bet);
						player.updateMoney(winnings);
					}
					System.out.println();
					bet = 0;
				}
				else
				{
					quit = true;
					break;
				}
			}
			double money = player.getMoney();
			System.out.println("Thanks for playing "+player.getName()+" -- come again soon!");
			System.out.println("Here are your results: ");
			System.out.println("\tRounds played: "+rounds);
			System.out.println("\tStarting money: "+initialMoney);
			System.out.println("\tEnding money: "+money);
			if (initialMoney > money)
				System.out.println("\tNet loss: "+(money-initialMoney));
			else if (initialMoney < money)
				System.out.println("\tWinnings: "+(money-initialMoney));
			else
				System.out.println("\tYou broke even!");
			System.out.println();
			player = getPlayer();
			money = player.getMoney();
			
			if (initialMoney == 0.0) //game ends
			{
				rounds = 0;
				System.out.println("Sorry "+player.getName()+" you are out of money! Better luck next time");
				System.out.println("Here are your results: ");
				System.out.println("\tRounds played: 0"+rounds);
				System.out.println("\tStarting money: "+initialMoney);
				System.out.println("\tEnding money: "+money);
				System.out.println("\tYou broke even!");
				break;
			}
		}
	}
	
	/**
	 * Method performs the act of the betting and returns the winnings the player gets from betting
	 * @param betAmount the amount of money the user wants to bet
	 * @return the winnings the user gets
	 */
	public static double getGuess(double betAmount)
	{
		Scanner input = new Scanner(System.in);
		boolean chosen = false; //initializes boolean value that describes whether the user has chosen the type of their bet
		boolean chosen1 = false; //initializes boolean value that describes whether the user has specifically chosen a value of the type they chose
		String type = "";
		String strChoice = "";
		int intChoice = 0;
		
		while (chosen == false) {
			System.out.println("Please enter the type of your bet: [Value, Color, Range, Parity]");
			type = input.nextLine();
			for (int i = 0; i<4; i++)
			{
				if ((type.toUpperCase().equals("VALUE") && i == 0 ) || (type.toUpperCase().equals("COLOR") && i == 1) || (type.toUpperCase().equals("RANGE") && i == 2) || (type.toUpperCase().equals("PARITY") && i == 3))
				{
					chosen = true;
					System.out.println("Your bet type is "+type);
					while (chosen1 == false)
					{
						if (i == 0) //type of bet is value
						{
							System.out.print("Enter your number [0-36]: ");
							intChoice = input.nextInt();
							if (intChoice>-1 && intChoice<37)
								chosen1 = true;
						}
						else if (i == 1) //type of bet is color
						{
							System.out.print("Enter your color [Red, Black]: ");
							strChoice = input.nextLine();
							if (strChoice.toUpperCase().equals("RED") || strChoice.toUpperCase().equals("BLACK"))
								chosen1 = true;
						}
						else if (i == 2) //type of bet is range
						{
							System.out.print("Enter your range [Low, High]: ");
							strChoice = input.nextLine();
							if (strChoice.toUpperCase().equals("LOW") || strChoice.toUpperCase().equals("HIGH"))
								chosen1 = true;
						}
						else //type of bet is parity
						{
							System.out.print("Enter your range [Even, Odd]: ");
							strChoice = input.nextLine();
							if (strChoice.toUpperCase().equals("EVEN") || strChoice.toUpperCase().equals("ODD"))
								chosen1 = true;
						}	
					}
				}
			}
		}
		RouletteWheel wheel = new RouletteWheel(); //initializes wheel
		RouletteResult X = wheel.spinWheel(); //spins wheel
		RouletteBet bet1 = new RouletteBet(null, strChoice);
		System.out.println("Spin result: " + X);
		if (type.toUpperCase().equals("VALUE"))
		{
			bet1 = new RouletteBet(RBets.Value, Integer.toString(intChoice));
		}
		else if (type.toUpperCase().equals("COLOR"))
		{
			bet1 = new RouletteBet(RBets.Color, strChoice.substring(0, 1).toUpperCase()+ strChoice.substring(1));
		}
		else if (type.toUpperCase().equals("RANGE"))
		{
			bet1 = new RouletteBet(RBets.Range, strChoice.substring(0, 1).toUpperCase()+ strChoice.substring(1));
		}
		else if (type.toUpperCase().equals("PARITY"))
		{
			bet1 = new RouletteBet(RBets.Parity, strChoice.substring(0, 1).toUpperCase()+ strChoice.substring(1));
		}
		double winnings = testBet(wheel, bet1, betAmount); //gets winnings
		return winnings;
	}
	
	/**
	 * Gets winnings based on the comparison between the player's bet at the wheel
	 * @param w the RouletteWheel object used for comparison
	 * @param b the RouletteBet object used to be compared to the wheel
	 * @param userB the user's bet
	 * @return the winnings the player gets
	 */
	public static double testBet(RouletteWheel w, RouletteBet b, double userB)
	{
		System.out.println("Bet: " + b);
		int res = w.checkBet(b);
		double winnings = 0;
		if (res == 0) //player loses
		{
			winnings = -1*userB;
			System.out.println("Sorry but you lose your bet of "+userB);
		}
			
		else if (res == 1)
		{
			winnings = userB;
			System.out.println("Even money winner gets "+winnings);
		}
			
		else if (res == 35) //player guesses value
		{
			winnings = 35*userB;
			System.out.println("Big winner! You get "+winnings);
		}
		return winnings;
	}
	
	/**
	 * Get the amount of money the user wishes to bet
	 * @param pMoney the amount of money the user has
	 * @return the bet if valid or other numbers that will cause other actions to perform
	 */
	public static double getBet(double pMoney)
	{
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("How much do you want to bet? (<="+pMoney+")");
			System.out.print("(Enter 0 if you want to quit): ");
			double bet = input.nextDouble();
			if (bet == 0.0)
				return -1; //user wishes to quit
			else if (bet>0 && bet<=pMoney)
				return bet;
			return 0; //this method will be called again
		}
		catch (InputMismatchException e)
		{
			return 0;
		}
	}
	
	/**
	 * Initializes a RoulettePlayer object
	 * @return a RoulettePlayer object with a name typed by the user and money either typed by the user or from a previous game
	 */
	public static RoulettePlayer getPlayer()
	{
		try {
			Scanner input = new Scanner(System.in);
			String name = "";
			while (name.length() == 0)
			{
				System.out.print("Please enter your name: ");
				name = input.nextLine();
			}
			File f = new File(name+".txt");
			if (f.exists())
			{
				double money = tryFile(name); //will get money the user ended with in the last game they played
				RoulettePlayer player = new RoulettePlayer(name, money);
				return player;
			}
			else //file does not exist so new user
			{
				try {
					double money = 0.0;
					FileWriter file = new FileWriter(name+".txt",true);
					file.write(name+": \n");
					System.out.println("Welcome "+name);
					while (money==0.0)
					{
						System.out.print("Please enter an amount of money: ");
						money = input.nextDouble();
					}
					file.write(Double.toString(money)+"\n");
					file.close();
					RoulettePlayer player = new RoulettePlayer(name, money);
					return player;
				}
				catch (IOException e)
				{
					getPlayer();
				}
			}
		}
		catch (InputMismatchException e)
		{
			getPlayer();
		}
		return null;
	}
	
	/**
	 * Gets the amount of money a user had in the last game they played
	 * @param n the name of the user
	 * @return the amount of money the user ended with in the last game they played
	 */
	private static double tryFile(String n)
	{
		try {
			File f = new File(n+".txt");
			FileWriter file = new FileWriter(n+".txt",true);	
			Scanner chop = new Scanner(f);
			BufferedReader r = new BufferedReader(new FileReader(n+".txt"));	
			System.out.println("Welcome Back "+n);
			String line = chop.nextLine().trim();
			String st;
			while ((st = r.readLine()) != null) //goes to last line
			{
				line = st;
			}
			file.write(n+":\n");
			double money = Double.parseDouble(line);
			file.write(Double.toString(money)+"\n");
			file.close();
			return money;
		}
		catch (IOException e)
		{
			tryFile(n);
		}
		return 0.0;
	}
}
