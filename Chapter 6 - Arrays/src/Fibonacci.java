import java.text.DecimalFormat;

public class Fibonacci
{
    public static void main(String[] args) 
    {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Please choose a number in the fibonacci sequence between 1 and 100");
        int size = InputMethods.getIntBetween(1,100);
        int fiboList[] = new int[size];
        
        setUpFibo(fiboList);
        System.out.println(outputFiboList(fiboList));
        
        System.out.println("Fibonacci value #"+size+" is "+df.format(getFiboList(fiboList,size)));
    }
    
    private static void setUpFibo(int vals[])
    {
        if (vals.length == 1)
        {
            vals[0] = 1;
        }
        else if(vals.length == 2)
        {
            vals[0] = 1;
            vals[1] = 1;
        }
        else
        {
            vals[0] = 1;
            vals[1] = 1;
            for (int i = 2; i < vals.length; i++)
            {
                vals[i] = vals[i-1]+vals[i-2];
            }
        }
    }
    
    private static String outputFiboList(int vals[])
    {
        DecimalFormat df = new DecimalFormat("#,###");
        String output = "";
        int count = 1;
        //demo for enhanced for loop
        for (int value:vals)
        {
            output += count + "--> "+df.format(value)+"\n";
            count ++;
        }
        return output;
    }
    
    /**
     * @param vals an array of fibonacci numbers
     * @param n the nth fibo number
     * @return the nth fibo number
     */
    private static int getFiboList(int vals[], int n)
    {
        //the nth fibo number is in the n-1 position
        if (n-1<vals.length)
        {
            return vals[n-1];
        }
        return -1;
    }
}
