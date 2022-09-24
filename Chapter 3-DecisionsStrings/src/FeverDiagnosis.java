import javax.swing.JOptionPane;

/**
 * @author Rand Hasan, Period 11
 * 9/14/2019
 * FeverDiagnosis.java Ch3 Decisions and Strings, Problem: Extra Credit Fever Diagnosis
 * Program takes input from the user asking questions about any symptoms
 * they have been having in order to return output of a diagnosis. 
 */

public class FeverDiagnosis
{
    public static void main(String[] args)
    {
        String fever = JOptionPane.showInputDialog(null, "Do you have a fever?");
        if (fever.toUpperCase().equals("NO"))
            JOptionPane.showMessageDialog(null, "Insufficient information to list possibilites.");
        else
        {
            String cough = null;
            String breathing = null;
            String headache = null;
            String bones = null;
            String rash = null;
            String soreThroat = null;
            String backPain = null;
            String urine = null;
            String hotConditions = null;
            String headPain = null;
            String vomit = null;
            boolean moveOn = false;
            boolean moveOn2 = false;
            
            cough = JOptionPane.showInputDialog(null, "Are you coughing?");
            if (cough.toUpperCase().equals("YES"))
                breathing = JOptionPane.showInputDialog(null, "Are you short of breath or wheezing or coughing up phlegm?");
                if (breathing.toUpperCase().equals("YES")) 
                    JOptionPane.showMessageDialog(null, "Possibilities include pneumonia or infection of airways.");
                else
                    moveOn = true;
                
            if (cough.toUpperCase().equals("NO") || moveOn == true)
                headache = JOptionPane.showInputDialog(null, "Do you have a headache?");
                if (headache.toUpperCase().equals("YES") && moveOn == false)
                    headPain = JOptionPane.showInputDialog(null, "Are you experiencing any of the following pain when bending your head forward, nausea or vomiting, bright light hurting your eyes, drowsiness, or conclusion?");
                    if (headPain.toUpperCase().equals("YES")) 
                        JOptionPane.showMessageDialog(null, "Possibilities include meningitis.");
                    else
                        vomit = JOptionPane.showInputDialog(null, "Are you vomiting or have you had diarrhea?");
                        if (vomit.toUpperCase().equals("YES"))
                            JOptionPane.showMessageDialog(null, "Possibilities include digestive tract infection.");
                        else
                            moveOn2 = true;
                if (headache.toUpperCase().equals("YES") && moveOn == true)
                    JOptionPane.showMessageDialog(null, "Possibilities include viral infection.");
                        
            if (headache.toUpperCase().equals("NO") || moveOn2 == true)
                bones = JOptionPane.showInputDialog(null, "Do you have aching bones or aching joints?");
                if (bones.toUpperCase().equals("YES"))
                    JOptionPane.showMessageDialog(null, "Possibilities include viral infection.");
                else if (bones.toUpperCase().equals("NO"))
                    rash = JOptionPane.showInputDialog(null, "Do you have a rash?");
                    if (rash.toUpperCase().equals("YES"))
                        JOptionPane.showMessageDialog(null, "Insufficient information to list possibilities.");
                    else if (rash.toUpperCase().equals("NO"))
                        soreThroat = JOptionPane.showInputDialog(null, "Do you have a sore throat?");
                        if (soreThroat.toUpperCase().equals("YES"))
                            JOptionPane.showMessageDialog(null, "Possibilities include throat infection.");
                        else if (soreThroat.toUpperCase().equals("NO"))
                            backPain = JOptionPane.showInputDialog(null, "Do you have back pain just above the waist with chills and fever?");
                            if (backPain.toUpperCase().equals("YES"))
                                JOptionPane.showMessageDialog(null, "Possibilities include kidney infection.");
                            else if (backPain.toUpperCase().equals("NO"))
                                urine = JOptionPane.showInputDialog(null, "Do you have pain urinating or are you urinating more often?");
                                if (urine.toUpperCase().equals("YES"))
                                    JOptionPane.showMessageDialog(null, "Possibilities include a urinary tract infection.");
                                else if (urine.toUpperCase().equals("NO"))
                                    hotConditions = JOptionPane.showInputDialog(null, "Have you spent the day in the sun or in hot conditions?");
                                    if (hotConditions.toUpperCase().equals("YES"))
                                        JOptionPane.showMessageDialog(null, "Possibilities include sunstroke or heat exhaustion.");
                                    if (hotConditions.toUpperCase().equals("NO"))
                                        JOptionPane.showMessageDialog(null, "Insufficient information to list possibilites.");
        }
            
    }

}
