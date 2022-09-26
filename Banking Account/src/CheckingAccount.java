/**
 * @author Rand Hasan
 * CheckingAccount.java
 * This program models a checking account which allows checks to be written on it
*/

public class CheckingAccount extends Account
{
    private double checkCharge; //per-check charge
    public double interestRate; //annual interest rate
    public CheckingAccount( int idNumber, String owner, double startBal, double chkCharge)
    {
        super(idNumber, owner, startBal);
        checkCharge = chkCharge;
    }
    
    /**
     * Clears a check for a given amount by decreasing the balance by the amount of the check plus the check per charge
     * @param amount decreases balance by this amount
     * @return a boolean value if check was cleared
     */
    public boolean clearCheck(double amount)
    {
        if (decreaseBalance(amount + checkCharge))
            return true;
        else
            return false;
    }
    
    /**
     * @return the interest rate
     */
    public double getInterestRate()
    {
        return interestRate;
    }
    
    /**
     * @param rate the interest rate of the account
     */
    public void setInterestRate(double rate)
    {
        interestRate = rate;
    }
    
    /**
     * A checking account doesn't have an interest rate
     */
    public double monthlyInterest()
    {
        return 0;
    }
    
    /**
     * @return the check per charge
     */
    public double getCheckCharge()
    {
        return checkCharge;
    }
    
    /**
     * @param c the check per charge of the account
     */
    public void setCheckCharge(double c)
    {
        checkCharge = c;
    }
    
    /**
     * Returns data of the account
     */
    public String toString()
    {
        String str = super.toString();
        str+=String.format("%s$%.2f\n","Check charge: ",checkCharge);
        return str;
    }
}
