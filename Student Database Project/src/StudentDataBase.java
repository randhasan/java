import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Rand Hasan, Period 11
 * 4/10/2020
 * StudentDataBase.java Student Database Project
 * This program models a database that holds information about different students
*/

public class StudentDataBase
{
     private ArrayList<Student> StudentRecords;
     private Stack<Double> stack;
     
     public StudentDataBase(String sf, String ef) throws FileNotFoundException
     {
         StudentRecords = new ArrayList<Student>();
         File file = new File(sf);
         File exp = new File(ef);
         Scanner chopper = new Scanner(file);
         while (chopper.hasNextLine()) //adds students to the database
         {
             String person = chopper.nextLine();
             
             String[] s = person.split(",");
             if (s.length == 6)
             {
                 Student student = new CollegeStudent(s);
                 StudentRecords.add(student);
             }
             else if (s.length == 7)
             {
                 Student student = new HighSchoolStudent(s);
                 StudentRecords.add(student);
             }
         }
         chopper.close();
         chopper = new Scanner(exp);
         while (chopper.hasNextLine()) //updates student's information
         {
             evaluate(chopper.nextLine());
         }
         chopper.close();
     }
     
     /**
      * Locates the student in the database with the ssn given
     * @param ssn the ssn given
     * @return the index of the student in the database
     */
    public int find(String ssn){
         int count = 0;
         for (Student s:StudentRecords)
         {
             if (s.getSSN().equals(ssn))
                 return count; //index of the student in database
             count ++;         
         }
         return -1; //student not in database
     }
     
    /**
     * Updates a user's GPA and the number of credit's earned
     * @param exp a line from the expressions document
     */
    public void evaluate(String exp){
         String[] ex = exp.split(","); //splits expression
         String ssn = ex[0]; //ssn is in the first index
         String[] ssnList = ssn.split("-"); //removes hyphens in ssn by splitting it into a array
         String ssn1 = "";
         for (int i = 0; i<ssnList.length; i++) //combines ssn without hyphens
         {
             ssn1 += ssnList[i];
         }
         Student s = StudentRecords.get(find(ssn1)); //finds student with the ssn in the expression
         s.setCreditsEarned(Integer.parseInt(ex[2])); //credits earned is in the last index of the array
         
         stack = new Stack<Double>();
         String line = ex[1]; //expression in post-fix notation in second index
         String token;
         StringTokenizer st = new StringTokenizer(line,"*+-/^ ",true);
         double num1, num2, result = 0;
         
         while(st.hasMoreTokens())
         {
             token = st.nextToken();
             if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^"))
             {
                 num1 = stack.pop(); //pops numbers in the stack
                 num2 = stack.pop();
                 result = evalOp(token, num2, num1); //performs the operation
                 stack.push(result); //pushes the result back into the stack
             }
             else if (!token.equals(" "))
             {
                 stack.push(Double.parseDouble(token)); //pushes number into the stack
             }
         }
         result = stack.pop(); //the final number in the stack
         result*=100; //rounds the result to two decimal places
         result = Math.round(result);
         result/=100;
         s.setGPA(result); //sets student's GPA
    }
    
    /**
     * Performs the operation given on the two numbers in the stack
     * @param operation the character of the operation
     * @param op1 first number
     * @param op2 second number
     * @return the result
     */
    private static double evalOp(String operation, double op1, double op2)
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
             break;
          case "^":
              result = Math.pow(op1, op2);
       }
       return result;
    }
     
     /**
     * Sort the students, display them one at a time at the console.
     */
    public void display(){
        StudentRecords.sort(null); //alphabetically sorts database
        for (Student s:StudentRecords)
        {
            System.out.println(s.toString());
            System.out.println("\n||||||||||||||||||||||||||||||||||||||\n");
        }
    }
}
