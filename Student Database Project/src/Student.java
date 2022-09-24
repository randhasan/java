/**
 * @author Rand Hasan, Period 11
 * 4/10/2020
 * Student.java Student Database Project
 * This program models a student with data that defines the student
*/

public abstract class Student implements Comparable<Student>
{
    private String firstName;
    private String lastName;
    private String ssn;
    private double gpa;
    private int creditsEarned;

    public Student(String[] str)
    {
        firstName = str[0].substring(0,str[0].indexOf(' '));
        lastName = str[0].substring(str[0].indexOf(' ')+1);
        ssn = str[1];
    }
    
    /**
     * Accesses the student's social security number
     * @return the hyphenated SSN to the caller.
     */
    public String getSSN()
    {
        return ssn;
    }
    
    /**
     * Sets the total credits earned by a student.
     * @param credits the total credits earned by a student
     */
    public void setCreditsEarned(int credits)
    {
        creditsEarned = credits;
    }
    
    /**
     * Sets the grade point average of a student.
     * @param g a student's GPA
     */
    public void setGPA(double g)
    {
        gpa = g;
    }
    
    /**
     * Accesses the student's first name
     * @return the student's first name
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Accesses the student's last name
     * @return the student's last name
     */
    public String getLastName()
    {
        return lastName;
    }
    
    /**
     * Compares two students by their names
     */
    public int compareTo(Student other)
    {
        if (lastName.compareTo(other.getLastName()) > 0 || (lastName.equals(other.getLastName()) && firstName.compareTo(other.getFirstName()) > 0))
            return 1; //last name of student is lexicographically greater than the last name of the other student, or the two last names are equal and the first name of student is lexicographically greater than the the first name of the other student
        else if (lastName.compareTo(other.getLastName()) < 0 || (lastName.equals(other.getLastName()) && firstName.compareTo(other.getFirstName()) < 0))
            return -1; //last name of student is lexicographically less than the last name of the other student, or the two last names are equal and the first name of student is lexicographically less than the the first name of the other student
        return 0; //both first and last names are lexicographically equal
    }
    
    /**
     * Returns a student's information as a string
     */
    public String toString()
    {
       String str = "";
       str += "Name: "+lastName+", "+firstName+"\n";
       str += "SSN: "+ssn.substring(0,3)+"-"+ssn.substring(3,5)+"-"+ssn.substring(5)+"\n";
       str += "Credits Earned: "+creditsEarned+"\n";
       str += "GPA: "+gpa+"\n";
       return str;
    } 
   
    public abstract void setUserName(String s); //sets student's username
}
