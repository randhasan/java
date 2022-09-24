import java.util.ArrayList;
import javax.swing.JButton;

/**
 * @author Rand Hasan, Period 11
 * 5/24/2020
 * Ballot.java CHS Project 4
 * This program is used to construct and extract data from a Ballot object
*/

public class Ballot
{
    private int id;
    private String office;
    private ArrayList<JButton> cButtons;
    private JButton chosen; //what choice the user has chosen
    
    public Ballot(String line)
    {
        String[] components = line.split(":");
        id = Integer.parseInt(components[0]);
        office = components[1];
        String[] comp3 = components[2].split(",");
        cButtons = new ArrayList<JButton>();
        
        for (int i = 0; i<comp3.length; i++)
        {
            JButton button = new JButton(comp3[i]);
            cButtons.add(button);
        }
        setChosen(null); //the user hasn't initally selected a choice
    }
    
    /**
     * Accessor method for the ArrayList of JButton's for the ballot
     * @return the ArrayList
     */
    public ArrayList<JButton> getcButtons()
    {
        return cButtons;
    }

    /**
     * Modifies the ArrayList of JButton's
     * @param cButtons an ArrayList of JButton's
     */
    public void setcButtons(ArrayList<JButton> cButtons)
    {
        this.cButtons = cButtons;
    }

    /**
     * Accessor method for the id of the ballot
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Modifies the id of the ballot
     * @param id the id of the ballot
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Accessor method of the office of the ballot
     * @return the office of the ballot
     */
    public String getOffice()
    {
        return office;
    }

    /**
     * Modifies the office of the ballot
     * @param office the office of the ballot
     */
    public void setOffice(String office)
    {
        this.office = office;
    }

    /**
     * Accessor method for the button the user has selected
     * @return the button selected
     */
    public JButton getChosen()
    {
        return chosen;
    }

    /**
     * Modifies the button chosen by the user
     * @param chosen the button selected by the user
     */
    public void setChosen(JButton chosen)
    {
        this.chosen = chosen;
    }
}