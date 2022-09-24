import java.util.*;
public class Factors
{
    public static void main(String[] args)
    {
        try {
            int num = getNum();
            if (checkPrime(num))
            {
                getFactors(num);
            }
        }
        catch (InputMismatchException ex)
        {
            System.out.print("Please enter a valid number.");
        }
    }
    
    public static int getNum()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int num = input.nextInt();
        return num;
    }
    
    public static boolean checkPrime(int num)
    {
        int factors[] = new int[1];
        for(int i = 1; i<=num; i++)
        {
            if (num%i==0)
            {
                if (i!=1 && i!=num)
                {
                    factors[0] = i;
                }
            } 
        }
        if (factors[0]!=0)
        {
            return true;
        }
        else
        {
            System.out.println(num+" is a prime number");
            return false;
        }
            
    }
    
    public static void getFactors(int num)
    {
        for(int i = 1; i<=num; i++)
        {
            if (num%i==0)
            {
                System.out.println(i+" is a factor of "+num);
            } 
        }
    }
}
