/**
 * @author Rand Hasan, Period 11
 * 4/25/2020
 * LongDistanceCall.java Long Distance Calls
 * This program is a class that calculates the cost of the user's phone call
*/
public class LongDistanceCall
{
    private int minutes;
    
    /**
     * Calculates the cost of the user's phone call
     * @param rate the rate of the time the user chose
     * @return the call's cost
     */
    public double getCost(double rate)
    {
        return getMinutes()*rate;
    }
    
    /**
     * Gets the length of the user's call
     * @return how long the user's call is
     */
    public int getMinutes()
    {
        return minutes;
    }
    
    /**
     * Allows user to set the length of their phone call
     * @param minutes the length of the user's call
     */
    public void setMinutes(int minutes)
    {
        this.minutes = minutes;
    }
    
}