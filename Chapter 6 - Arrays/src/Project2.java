import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Rand Hasan, Period 11
 * 10/25/2019
 * Project2.java Ch6 Arrays, CHS Project 2 - Tumor Classification
 * This program reads data from a file in order to determine if a tumor is malignant or benign 
 * base its attributes. It also determines how accurately it can predict whether a tumor is 
 * malignant or benign based on what it learns from the training data.
 */

public class Project2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter the name of the file that holds the training data: ");
            String filename1 = input.nextLine();
            double[] avgB = compute_avgs(filename1,'B'); // array with average values of attributes for a benign tumor
            double[] avgM = compute_avgs(filename1,'M'); // array with average values of attributes for a malignant tumor
            System.out.print("Please enter the name of the file that holds the testing data: ");
            String filename2 = input.next();
            classify(filename2, avgM, avgB); // prints out percent accuracy, number of correct guesses, and number of total guesses
         
        }
        catch (FileNotFoundException ex)
        {
            System.out.print("Please enter a valid file name.");
        }
     }
    
    /**
     * @param filename name of file that will be opened for reading and extracting data from to calculate the avg. values of each of the attributes for the called for type of tumor
     * @param type an array with the average values of the attributes of that type of tumor is returned
     * @return an array with the average values of the attributes of the type of tumor that was called for
     * @throws FileNotFoundException if the file that is called for is not found
     */
    public static double[] compute_avgs(String filename, char type) throws FileNotFoundException
    {
        String attributes[] = {"Avg. Radius: ", "Avg. Texture: ","Avg. Perimeter: ", "Avg. Area: ", "Avg. Smoothness: ", "Avg. Compactness: ", "Avg. Concavity: ", "Avg. Concave: ","Avg. Symmetry: ","Avg. Fractal: "}; // the types of attributes
        File file = new File(filename);
        String tumorType = "";
        Scanner inputFile = new Scanner(file);
        double count = 0.0;
        double totalAttribs[] = new double[10]; // initialize arrays with average values of attributes for a the called-for tumor
        while (inputFile.hasNext()) // reads file from data until end of file is reaches
        {
            String[] nextArray = inputFile.nextLine().split(","); // data from line from file is stored in an array
            if (nextArray[nextArray.length-1].equals(Character.toString(type))) // if last element in nextArray is the type of 
            {
                count++; // number of tumors of called-for type increases
                for (int j = 0; j<nextArray.length-2; j++) // loops through elements 0-9 of nextArray which are each of the attributes of the called-for tumor
                {
                    totalAttribs[j] += Double.parseDouble(nextArray[j]); // each attribute in nextArray is added to corresponding attribute in the array with avg. attributes for the called-for tumor
                }
            }
        }    
        inputFile.close(); // close file
        for (int i = 0; i<totalAttribs.length; i++) // loops through array that will store the average attributes of the called-for tumor
        {
            totalAttribs[i]/=count; // divide each attribute by the number of the called-for type of tumors to calculate average value for each attribute
        }
        if (type=='B')
        {
            tumorType = "Benign";
        }
        else if (type == 'M')
        {
            tumorType = "Malignant";
        }
        System.out.println();
        System.out.println("Averages of Attributes in a "+tumorType+" Tumor Calculated from Training Data: ");
        for (int i = 0; i<totalAttribs.length; i++)
        {
            System.out.format(attributes[i]+"%.2f\n",totalAttribs[i]); // prints average value of each attribute
        }
        System.out.println("");
        return totalAttribs; // return array with avg. attributes for the called-for tumor 
    }
    
    /**
     * @param filename the name of the file that will be opened for reading and extracting data to compare to the values of attributes from each line in the file to the average values of the attributes of the different types of tumors
     * @param MAvgs the array with the average values of each of the attributes of a malignant tumor
     * @param BAvgs the array with the average values of each of the attributes of a benign tumor
     * @throws FileNotFoundException if the file that is called for is not found
     */
    public static void classify(String filename, double[] MAvgs, double[] BAvgs) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        double numCorrect = 0.0;
        double numGuesses = 0.0;
        while (inputFile.hasNext()) // reads file from data until end of file is reaches
        {
            String guess = "";
            double countM = 0.0;
            double countB = 0.0;
            String[] nextArray = inputFile.nextLine().split(","); // data from line from file is stored in an array
            for (int j = 0; j<nextArray.length-2; j++) // loops through elements 0-9 which are attributes of the tumor represented by nextArray
            {
                if (Math.abs(MAvgs[j]-Double.parseDouble(nextArray[j])) >  Math.abs(BAvgs[j]-Double.parseDouble(nextArray[j]))) // if attribute is closer to the corresponding avg. benign attribute than the corresponding avg. malignant attribute
                {
                    countB++; // the attribute with index j is closer to the corresponding avg. benign attribute
                }
                else if (Math.abs(MAvgs[j]-Double.parseDouble(nextArray[j])) <  Math.abs(BAvgs[j]-Double.parseDouble(nextArray[j]))) // if attribute is closer to the corresponding avg. malignant attribute than the corresponding avg. benign attribute
                {
                    countM++; // the attribute with index j is closer to the corresponding avg. malignant attribute
                }
            }
            if (countM>countB) // if there are more attributes in nextArray that are closer to the corresponding avg. malignant attributes than the corresponding avg. benign attributes
            {
                guess = "M"; // the tumor is most likely malignant
            }
            else if (countM<countB) // if there are more attributes in nextArray that are closer to the corresponding avg. benign attributes than the corresponding avg. malignant attributes
            {
                guess = "B"; // the tumor is most likely benign
            }
            else // if there are an equal number of attributes that are close to the corresponding avg. benign attributes as the orresponding avg. malignant attributes
            {
                guess = "M"; // assume the tumor is malignant
            }
            if (nextArray[nextArray.length-1].equals(guess)) // if the type of tumor represented by nextArray is the same as the type of tumor guessed
            {
                numCorrect++; // number of types of tumors guessed correctly increases
                numGuesses++; // number of types of tumors guessed increases
            }
            else
            {
                numGuesses++; // number of types of tumors guessed increases
            }
        }
        inputFile.close(); // close file
        double percentAcc = (numCorrect/numGuesses)*100; // find accuracy percentage by dividing number of correct guesses by total number of guesses
        System.out.format("Percent Accuracy: %2.2f",percentAcc); // print out percent accuracy, number of correct guesses, and number of total guesses
        System.out.println("%\nNumber of correct guesses; "+(int)numCorrect);
        System.out.print("Total number of guesses: "+(int)numGuesses);
    }
}