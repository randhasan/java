/**
 * @author Rand Hasan
 * CollegeStudent.java Student Database Project
 * This program models a college student with data that defines the student
*/

public class CollegeStudent extends Student
{
   private String dormitory;
   private String college;
   private String roomNumber;
   private String status;
   private String userName;
   
   public CollegeStudent(String[] line)
   {
       super(line);
       roomNumber = line[2];
       dormitory = line[3];
       college = line[4];
       setUserName(line[5]);
   }
    
   /**
    * Returns a student's information as a string
    */
   public String toString()
   {
       String str = super.toString();
       str += "Address:\n";
       str += roomNumber + " "+dormitory + "\n";
       str += college + "\n";
       str += "Status: "+status+ "\n";
       str += "User Name: "+userName;
       return str;
   }
   
   /**
    * Sets the student's username
    * @param uName a possible new username for the student
    */
   @Override
   public void setUserName(String uName)
   {
       if ((uName.substring(0,2).equals("FR") || uName.substring(0,2).equals("SO") || uName.substring(0,2).equals("JU") || uName.substring(0,2).equals("SE")) && uName.length()==6)
       {
           setStatus(uName.substring(0,2)); //updates status
           userName = uName;
       }
       else
       {
           userName = null;
       }
   }
   
   /**
    * Modifies the student's status
    * @param str two characters that define the status of the student
    */
   private void setStatus(String str)
   {
       if (str.equals("FR"))
           status = "Freshman";
       else if (str.equals("SO"))
           status = "Sophomore";
       else if (str.equals("JU"))
           status = "Junior";
       else if (str.equals("SE"))
           status = "Senior";
   }
}
