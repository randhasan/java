import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Rand Hasan
 * BankingDriverStudent.java
 * This program models bank accounts and the data associated with accounts written in a file
*/

public class BankingDriverStudent
{
    private static ArrayList<Account> accounts;
    
    public static void main(String[] args) throws FileNotFoundException
    {
        accounts = new ArrayList<>();
        Account current,transferTo;
        DecimalFormat df=new DecimalFormat("$#,###0.00");
        //read and instantiate accounts
        loadAccountInfo("accounts.txt",accounts);  
        outputAccountList();
        
        //testing post interest
        System.out.println("\n\nPosting interest to all accounts");
        postMonthlyInterest();
        outputAccountList();
        
        //testing clear 2 checks- first one no per check, second w/ per check
        System.out.println("Testing Check Clear:");
        current = findAccount("name","Tyler Schlotterbeck");
        System.out.println("\n"+current);
        if (current!=null)
        {
            System.out.println("Withdrawing 2000 from " +current.getOwner());
            ((SpecialCheckingAccount) current).clearCheck(2000);
            System.out.println("\n"+current);
            
            System.out.println("\nWithdrawing 20 from " +current.getOwner());
            ((SpecialCheckingAccount) current).clearCheck(20);
            System.out.println("\n"+current);
        }
        current = findAccount("id","66666");
        
        if (current!=null)
        {
            System.out.println("\nAttempting to withdraw 8000 from account:");
            System.out.println(current);
            if(((CheckingAccount) current).clearCheck(8000))
                System.out.println("\n"+current);
            else
                System.out.println("Error, Insufficient funds: Balance: "+df.format(current.currentBalance())+"\n");
            
        }
        
        //testing withdrawal
        for(int i=0;i<accounts.size();i++)
        {
            if(accounts.get(i).decreaseBalance(100))
                System.out.println("$100 successfully withdrawn from account " + accounts.get(i).getIDNumber());
            else
                System.out.println("Insufficient funds for $100 withdrawal on account " + accounts.get(i).getIDNumber());
        
        }
        
        System.out.println("After withdrawal balances");
        outputAccountList();
        
        //testing Transfer
        System.out.println("\n\nTesting Transfer:");
        transferTo = findAccount("id", "88888");
        if(transferTo !=null)
        {
            if(current.transfer(2000, transferTo))
            {
                System.out.println("Transfer complete. $2000 transferred from");
                System.out.println(current+"\nto\n");
                System.out.println(transferTo);
                
            }
            else
            {
                System.out.println("There was a problem with this transfer");
            }
        }

        //testing deposits
        System.out.println("\nThe bank is giving everyone a  Bonus:");
        for(int i=0;i<accounts.size();i++)
        {
            accounts.get(i).deposit(1);
                
        }

        Collections.sort(accounts);
        outputAccountList();  
    }
    
    
    /**
     * reads all account information in the provided file into the allAccounts
     * @param filename- name of file storing banking data
     * @param allAccounts- list containing all customer accounts
     * @throws FileNotFoundException 
     */
    private static void loadAccountInfo(String filename, ArrayList<Account> allAccounts) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner chopper = new Scanner(file);
        while (chopper.hasNextLine())
        {
            String type = chopper.nextLine();
            int accNum = chopper.nextInt();
            chopper.nextLine();
            String owner = chopper.nextLine();
            double balance = chopper.nextDouble();
            chopper.nextLine();
            double charge = chopper.nextDouble();
            chopper.nextLine();
            String cont = chopper.nextLine();
            if (cont.equals("#"))
            {
                if (type.equals("SA"))
                {
                    charge/=100.0;
                    SavingsAccount acc = new SavingsAccount(accNum,owner,balance,charge);
                    acc.setType(type);
                    allAccounts.add(acc);
                }
                else if (type.equals("CA"))
                {
                    CheckingAccount acc = new CheckingAccount(accNum,owner,balance,charge);
                    acc.setType(type);
                    allAccounts.add(acc);
                }
            }
            else
            {
                double rate = Double.parseDouble(cont)/100.0;
                double minBalance = chopper.nextDouble();
                try {
                    chopper.nextLine();
                    SpecialCheckingAccount acc = new SpecialCheckingAccount(accNum, owner, balance, charge);
                    acc.setInterestRate(rate);
                    acc.setMinBalance(minBalance);
                    acc.setType(type);
                    allAccounts.add(acc);
                    chopper.nextLine();
                }
                catch (NoSuchElementException e)
                {
                    SpecialCheckingAccount acc = new SpecialCheckingAccount(accNum, owner, balance, charge);
                    acc.setInterestRate(rate);
                    acc.setMinBalance(minBalance);
                    acc.setType(type);
                    allAccounts.add(acc);
                }
            }
            
        }
    }
    
    /**
     * Posts the monthly interest to each account
     */
    private static void postMonthlyInterest()
    {
        for (Account a:accounts)
        {
            if (a.getType().equals("SA"))
            {
                ((SavingsAccount)a).deposit(((SavingsAccount)a).monthlyInterest());
            }
            else if (a.getType().equals("SCA"))
            {
                ((SpecialCheckingAccount)a).deposit(((SpecialCheckingAccount)a).monthlyInterest());
            }
        }
    }
    
    /**
     * Outputs a table of all account information
     */
    private static void outputAccountList()
    {
        System.out.println("\n\nAccount List");
        String fmtH ="%-6s%-10s%-25s%12s%8s%13s%13s%n";
        String fmt ="%-6s%-10d%-25s%12s%8s%13s%13s%n";
        
        DecimalFormat dfMoney = new DecimalFormat("$#,##0.00");
        DecimalFormat dfPercent = new DecimalFormat("0.0%");
        
        
        System.out.format(fmtH, "Type","Acct#","Owner","Balance","Rate","Chk Chg","Min Bal");
        System.out.format(fmtH, "----","-----","-----","-------","----","--- ---","--- ---");
        for (Account a:accounts)
        {
            if (a.getType().equals("SA")) //no checking change or min balance
            {
                System.out.format(fmt, a.getType(),a.getIDNumber(),a.getOwner(),dfMoney.format(a.currentBalance()),dfPercent.format(((SavingsAccount)a).getInterestRate()),dfMoney.format(0.0),dfMoney.format(0.0));
            }
            else if (a.getType().equals("CA")) //no min balance
            {
                System.out.format(fmt, a.getType(),a.getIDNumber(),a.getOwner(),dfMoney.format(a.currentBalance()),dfPercent.format(((CheckingAccount)a).getInterestRate()),dfMoney.format(((CheckingAccount)a).getCheckCharge()),dfMoney.format(0.0));
            }
            else if (a.getType().equals("SCA"))
            {
                System.out.format(fmt, a.getType(),a.getIDNumber(),a.getOwner(),dfMoney.format(a.currentBalance()),dfPercent.format(((SpecialCheckingAccount)a).getInterestRate()),dfMoney.format(((SpecialCheckingAccount)a).getCheckCharge()),dfMoney.format(((SpecialCheckingAccount)a).getMinBalance()));
            }
        }
    }

    /**
     * Finds an account by id or name
     * @param type id or name
     * @param value either the id number or the name for the account by which to search
     * @return Account based on type (id or name) and value or null if not found
     */
    public static Account findAccount(String type, String value)
    {
        if (type.equals("id"))
        {
            int val = Integer.parseInt(value);
            for (int i = 0; i<accounts.size();i++)
            {
                if (accounts.get(i).getIDNumber() == val)
                {
                    return accounts.get(i);
                }
            }
        }
        else if (type.equals("name"))
        {
            for (int i = 0; i<accounts.size();i++)
            {
                if (accounts.get(i).getOwner().equals(value))
                {
                    
                    return accounts.get(i);
                }
            }
        }
        return null;
    }
}
