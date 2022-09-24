import java.util.ArrayList;

public class StudentAnswerSheet
{
    private static ArrayList<String> answers;

    public static void main(String args[])
    {
        answers = new ArrayList<String>();
        String[] a = {"A","B","D","E","A","C","?","B","D","C"};
        for (int i = 0; i<a.length;i++)
        {
            answers.add(a[i]);
        }
        String[] b = {"A","C","D","E","B","C","E","B","B","C"};
        ArrayList<String> key = new ArrayList<String>();
        for (int i = 0; i<b.length;i++)
        {
            key.add(b[i]);
        }
        System.out.println(getScore(key));
    }
    
    public static double getScore(ArrayList<String> key)
    {
        double score = 0.0;
        for (int i = 0; i<key.size(); i++)
        {
            if (key.get(i).equals(answers.get(i)))
                score+=1;
            else if (answers.get(i).equals("?"))
                continue;
            else if (!key.get(i).equals(answers.get(i)))
                score-=.25;  
        }
        return score;
    }
    
    private ArrayList<StudentAnswerSheet> sheets;
    public String highestScoringStudent(ArrayList<String> key)
    {
        double[] scores = new double[key.size()];
        int count = 0;
        for (StudentAnswerSheet sh:sheets)
        {
            scores[count] = sh.getScore(key);
        }
        int maxIndex = 0;
        double max = scores[maxIndex];
        for (int i = 0; i<scores.length; i++)
        {
            if (scores[i]>max)
            {
                max = scores[i];
                maxIndex = i;
            }
        }
        return sheets.get(maxIndex).getName();
    }

}
