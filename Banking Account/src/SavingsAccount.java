/**
 * @author Rand Hasan, Period 11
 * 3/30/2020
 * SavingsAccount.java Banking Account Project
 * This program models a savings account which has an interest rate
*/

public class SavingsAccount extends Account
{
    public double interestRate; //annual interest rate
    
    public SavingsAccount(int idNumber, String person, double startBal, double rate)
    {
        super(idNumber, person, startBal);
        interestRate = rate;
    }
    
    /**
     * Withdraws a positive amount of money that doesn't exceed the current balance
     * @param amount the amount which the balance decreases
     */
    public void withdraw(double amount)
    {
        if (amount>0 && amount<=this.currentBalance())
        {
            this.setBalance(this.currentBalance()-amount);
        }
    }
    
    /**
     * @return the interest rate of the account
     */
    public double getInterestRate()
    {
        return interestRate;
    }

    @Override
    /**
     * Returns the monthly interest due
     */
    public double monthlyInterest()
    {
        return super.currentBalance()*interestRate/12.0;
    }
}