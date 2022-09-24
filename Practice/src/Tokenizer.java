import java.util.Stack;
import java.util.StringTokenizer;


public class Tokenizer 
{
    private static Stack<Double> stack;
    
    public static void main(String[] args)
    {
        stack = new Stack<Double>();
        String line = "110. 5.+2.*103./";
        String delims = " .";
        StringTokenizer st = new StringTokenizer(line, delims);
        
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
    }
    
    
}