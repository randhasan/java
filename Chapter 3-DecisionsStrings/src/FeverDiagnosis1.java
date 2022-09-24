import javax.swing.JOptionPane;

public class FeverDiagnosis1
{
    public static void main(String[] args)
    {
        boolean chain1 = false;
        boolean chain2 = false;
        boolean chain3 = false;
        String fever = JOptionPane.showInputDialog(null, "Do you have a fever?");
        if (fever.toUpperCase().equals("NO"))
            JOptionPane.showMessageDialog(null, "Insufficient information to list possibilites.");
        else
        {
            String cough = JOptionPane.showInputDialog(null, "Are you coughing?");
            if (cough.toUpperCase().equals("NO"))
                chain1 = true;
            else if (cough.toUpperCase().equals("YES"))
                chain2 = true;
        }
        
        if (chain1 == true)
        {
            String headache = JOptionPane.showInputDialog(null, "Do you have a headache?");
            if (headache.toUpperCase().equals("YES"))
            {
                String headPain = JOptionPane.showInputDialog(null, "Are you experiencing any of the following pain when bending your head forward, nausea or vomiting, bright light hurting your eyes, drowsiness, or conclusion?");
                if (headPain.toUpperCase().equals("YES"))
                {
                    JOptionPane.showMessageDialog(null, "Possibilities include meningitis.");
                }
                else if (headPain.toUpperCase().equals("NO"))
                {
                    String vomit = JOptionPane.showInputDialog(null, "Are you vomiting or have you had diarrhea?");
                    if (vomit.toUpperCase().equals("YES"))
                        JOptionPane.showMessageDialog(null, "Possibilities include digestive tract infection.");
                    else if (vomit.toUpperCase().equals("NO"))
                    {
                        chain3 = true;
                    }
                }
            }
            else if (headache.toUpperCase().equals("NO"))
            {
                chain3 = true;
            }
        }
            
           
            
        if (chain2 == true || chain3 == true)
        {
            String breathing = JOptionPane.showInputDialog(null, "Are you short of breath or wheezing or coughing up phlegm?");
            if (breathing.toUpperCase().equals("YES")) 
                JOptionPane.showMessageDialog(null, "Possibilities include pneumonia or infection of airways.");
            else if (breathing.toUpperCase().equals("NO"))
            {
                String headache = JOptionPane.showInputDialog(null, "Do you have a headache?");
                if (headache.toUpperCase().equals("YES"))
                    JOptionPane.showMessageDialog(null, "Possibilities include viral infection.");
                else if (headache.toUpperCase().equals("NO") || chain3 == true)
                {
                    String bones = JOptionPane.showInputDialog(null, "Do you have aching bones or aching joints?");
                    if (bones.toUpperCase().equals("YES"))
                        JOptionPane.showMessageDialog(null, "Possibilities include viral infection.");
                    else if (bones.toUpperCase().equals("NO"))
                    {
                        String rash = JOptionPane.showInputDialog(null, "Do you have a rash?");
                        if (rash.toUpperCase().equals("YES"))
                        {
                            JOptionPane.showMessageDialog(null, "Insufficient information to list possibilities.");
                        }
                        else if (rash.toUpperCase().equals("NO"))
                        {
                            String soreThroat = JOptionPane.showInputDialog(null, "Do you have a sore throat?");
                            if (soreThroat.toUpperCase().equals("YES"))
                            {
                                JOptionPane.showMessageDialog(null, "Possibilities include throat infection.");
                            }
                            else if (soreThroat.toUpperCase().equals("NO"))
                            {
                                String backPain = JOptionPane.showInputDialog(null, "Do you have back pain just above the waist with chills and fever?");
                                if (backPain.toUpperCase().equals("YES"))
                                {
                                    JOptionPane.showMessageDialog(null, "Possibilities include kidney infection.");
                                }
                                else if (backPain.toUpperCase().equals("NO"))
                                {
                                    String urine = JOptionPane.showInputDialog(null, "Do you have pain urinating or are you urinating more often?");
                                    if (urine.toUpperCase().equals("YES"))
                                    {
                                        JOptionPane.showMessageDialog(null, "Possibilities include a urinary tract infection.");
                                        
                                    }
                                    else if (urine.toUpperCase().equals("NO"))
                                    {
                                        String hotConditions = JOptionPane.showInputDialog(null, "Have you spent the day in the sun or in hot conditions?");
                                        if (hotConditions.toUpperCase().equals("YES"))
                                        {
                                            JOptionPane.showMessageDialog(null, "Possibilities include sunstroke or heat exhaustion.");
                                            
                                        }
                                        else if (hotConditions.toUpperCase().equals("NO"))
                                        {
                                            JOptionPane.showMessageDialog(null, "Insufficient information");
                                        }
                                    }
                                }
                            }
                            
                        }
                    }           
                }
            }
        }
    }
}
    
        
          