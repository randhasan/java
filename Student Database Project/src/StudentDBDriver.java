import java.io.FileNotFoundException;

/**
 * @author Rand Hasan
 * StudentDBDriver.java Student Database Project
 * This program displays the data in the student database
*/

public class StudentDBDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        StudentDataBase s = new StudentDataBase("students.txt","expressions.txt");
        s.display();
    }
}
