/**
 * @author Rand Hasan, Period 11
 * 4/10/2020
 * HighSchoolStudent.java Student Database Project
 * This program models a high school student with data that defines the student
*/

public class HighSchoolStudent extends Student
{
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String userName;
    
    public HighSchoolStudent(String[] line)
    {
        super(line);
        streetAddress = line[2];
        city = line[3];
        state = line[4];
        zip = line[5];
        setUserName(line[6]);
    }
    
    /**
     * Returns a student's information as a string
     */
    public String toString()
    {
        String str = super.toString();
        str += "Address:\n";
        str += streetAddress + "\n";
        str += city+", "+state+" "+zip+"\n";
        str += "User Name: "+userName;
        return str;
    }
    
    /**
     * Modifies the student's username
     * @param uName the student's new username
     */
    public void setUserName(String uName)
    {
        if (uName.length()==6 && !uName.substring(0,1).equals("0")) //name must be 6 characters and start with a non-zero character
            userName = uName;
        else
            userName = null;
    }
}