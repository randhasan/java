/**
 * @author Rand Hasan, Period 11
 * 1/28/2019
 * RoulettePlayer.java CHS CS 401 Assignment 2
 * This program is a class for the game player which includes the player's name and money along with mutator and accessor methods for
 * manipulating and accessing the player's data.
*/
public class RoulettePlayer {
	
	private String name;
	private double money;

	/**
	 * Initializes a player object
	 */
	public RoulettePlayer() {
		name = "";
	    money = 0.0;
	}
	
	/**
	 * Initializes a player object with arguments that are written in the method call as parameters
	 * @param n the player's name
	 * @param m the amount of money the player has
	 */
	public RoulettePlayer(String n, double m) {
		name = n;
		money = m;
	}
	
	/**
	 * Updates the amount of money the player has by amount delta
	 * @param delta amount of money the player gains or loses
	 */
	public void updateMoney(double delta)
	{
		money += delta;
	}
	
	/**
	 * Accessor method for player's money
	 * @return the amount of money the player has
	 */
	public double getMoney()
	{
		return money;
	}
	
	/**
	 * Accessor method for the player's name
	 * @return the player's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Formats player's information
	 * @return the player's information in a nicely formattted String
	 */
	public String toString()
	{
		return "Name:"+name+" Cash:"+money;
	}
	
	/**
	 * Checks if player has money
	 * @return a boolean value based on whether the user has money or not
	 */
	public boolean hasMoney()
	{
		if (money>0)
			return true;
		return false;
	}	
}