/**
 * @author Rand Hasan, Period 11
 * 3/30/2020
 * SpecialCheckingAccount.java Banking Account Project
 * This program models a special checking account which is a subclass of a checking account
*/

public class SpecialCheckingAccount extends CheckingAccount
{
    private double minBalance;
    private double interestRate;
    public SpecialCheckingAccount(int idNumber, String owner, double startBal, double chkCharge)
    {
        super(idNumber, owner, startBal, chkCharge);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @return the minimum balance the account can have
     */
    public double getMinBalance()
    {
        return minBalance;
    }
    
    /**
     * @param minBalance the minimum balance the account can have
     */
    public void setMinBalance(double minBalance)
    {
        this.minBalance = minBalance;
    }
    
    /**
     * Calculates the monthly interest if current balance is above the minimum balance
     */
    public double monthlyInterest()
    {
        if (super.currentBalance()>this.getMinBalance())
        {
            System.out.println(super.currentBalance());
            System.out.println(interestRate);
            return super.currentBalance()*this.getInterestRate()/12.0;
        }
        else
            return super.monthlyInterest(); //will be zero
    }
    
    /**
     * Prints out all the data the account has
     */
    public String toString()
    {
        String str = super.toString();
        str += String.format("%s$%.2f","Minimum Balance: ",minBalance);
        return str;
    }
}
