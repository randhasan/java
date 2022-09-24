import java.util.Scanner;

public class CMU
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstLine = input.nextLine();
        int numLines = Integer.parseInt(firstLine.substring(firstLine.indexOf(' ')+1));
        String letters = input.nextLine();
        String[] arr = new String[numLines];
        for (int i = 0; i<numLines; i++)
        {
            String test = input.nextLine();
            int start = Integer.parseInt(test.substring(0,test.indexOf(' ')));
            int stop = Integer.parseInt(test.substring(test.indexOf(' ')+1));
            String newSub = letters.substring(start, stop+1);
            int numA = 0;
            int numB = 0;
            for (int j = 0; j<newSub.length(); j++)
            {
                if (newSub.substring(j,j+1).equals("A"))
                    numA += 1;
                else if(newSub.substring(j,j+1).equals("B"))
                    numB+=1;
            }
            if (numA>numB)
                arr[i] = "A Wins";
            else if (numA<numB)
                arr[i] = "B Wins";
            else
                arr[i] = "Tie";
        }
        for (int a = 0; a<numLines; a++)
        {
            System.out.println(arr[a]);
        }
    }
}
