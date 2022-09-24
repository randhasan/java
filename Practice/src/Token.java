import java.util.Stack;
import java.util.StringTokenizer;

public class Token
{

    private static Stack<Double> stack;
    
    public static void main(String[] args)
    {
        stack = new Stack<Double>();
        String line = "1 1 1++";
        String token;
        StringTokenizer st = new StringTokenizer(line,"*+-/^ ",true);
        double num1, num2, result = 0;
        
        while(st.hasMoreTokens())
        {
            token = st.nextToken();
            
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            {
                num1 = stack.pop();
                num2 = stack.pop();
                result = evalSingleOp (token, num2, num1);
                stack.push(result);
            }
            else if (!token.equals(" "))
            {
                stack.push(Double.parseDouble(token));
            }
        }
        result = stack.pop();
        result*=100;
        result = Math.round(result);
        result/=100;
        System.out.println(result);
    }
    
    private static double evalSingleOp (String operation, double op1, double op2)
    {
       double result = 0;

       switch (operation)
       {
          case "+":
             result = op1 + op2;
             break;
          case "-":
             result = op1 - op2;
             break;
          case "*":
             result = op1 * op2;
             break;
          case "/":
             result = op1 / op2;
       }
       return result;
    }
}