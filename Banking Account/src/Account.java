/**
 * @author Rand Hasan, Period 11
 * 3/30/2020
 * Account.java Banking Account Project
 * This abstract class models a bank account with different data and operations
*/

public abstract class Account implements Comparable<Account>
{
    private int idNum; //identity number for this account
    private String owner; //account owner
    private double balance; //current balance for this account
    private String type;
    
    /** Creates an Account with identity number idNumber & current balance startBal.
    * @param idNumber the identity number for the account
    * @param startBal the starting balance for the account
    * Precondition: startBal ≥ 0.0
    */
    public Account(int idNumber, String person, double startBal)
    { 
        idNum = idNumber;
        owner = person;
        balance = startBal;
    }
    
    /** 
     * @return the idNum of this account.
    */
    public int getIDNumber()
    { 
        return idNum;
    }
    
    /**
     * @return the owner of this account.
    */
    public String getOwner()
    {
        return owner;
    }
    
    /** 
     * @return the current balance for this account.
    */
    public double currentBalance()
    { 
        return balance;
    }
    
    /**
     * @param amount the amount of money the account currently has
     */
    public void setBalance(double amount)
    { 
        balance = amount;
    }
    
    /** Increases the current balance of this account by amount.
    * @param amount the amount to be deposited into the account
    * Postcondition: money deposited if amount>0
    * @return true if successful deposit; false if amount<=0
    */
    public boolean deposit (double amount)
    {
        if (amount>0)
        {
            balance+=amount;
            return true;
        }
        return false; 
    }
    
    /** Decreases the current balance of this account by amount.
    * @param amount the amount to be removed from the account
    *
    * Postcondition: money withdrawn if sufficient funds
    * @return true if successful withdrawal; false if insufficient funds to withdraw
    */
    public boolean decreaseBalance (double amount)
    {
        if (amount<=balance)
        {
            balance-=amount;
            return true;
        }
        return false;
    }
    
    /**Transfers money from the bank account to another account
    * @param amount the amount to transfer
    * @param other the other account
    * @return true if successful transfer made, false otherwise
     */
    public boolean transfer(double amount, Account other)
    {
        if (this.decreaseBalance(amount) && other.deposit(amount))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Displays information about the account
     */
    public String toString()
    {
        String str = "Owner: "+owner+"\n";
        str+="ID Number: "+idNum+"\n";
        str+=String.format("%s$%.2f\n", "Balance: ",balance);
        return str;
    }
    
    /**
     Compares accounts by balance
     @return an integer value based on which account has a greater balance
    **/
    public int compareTo(Account other)
    {
        if (balance>other.currentBalance())
            return 1;
        else if (balance<other.currentBalance())
            return -1;
        return 0; //equal
    }
    
    /**
     * @return the type of account the account is
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * @param t the type of account the account is
     */
    public void setType(String t)
    {
        type = t;
    }
    
    /** 
     * @return the monthly interest due for this account.
    */
    public abstract double monthlyInterest();
}