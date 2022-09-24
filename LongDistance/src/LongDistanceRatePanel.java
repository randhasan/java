import javax.swing.*;
import java.awt.*;

/**
 * @author Rand Hasan, Period 11
 * 4/25/2020
 * LongDistanceRatePanel.java Long Distance Calls
 * This program is a class creates a panel with buttons for the user to choose which time they make their call
*/
public class LongDistanceRatePanel extends JPanel
{
    private JRadioButton radDay;
    private JRadioButton radEvening;
    private JRadioButton radOffPeak;
    private ButtonGroup bg;
    
    public LongDistanceRatePanel()
    {
        //create grid layout 3 rows, 1 col
        setLayout(new GridLayout(3,1));
        
        //create Radio buttons
        radDay = new JRadioButton("Daytime (6:00 A.M. through 5:59 P.M.)");
        radEvening = new JRadioButton("Evening (6:00 P.M. through 11:59 P.M.)");
        radOffPeak = new JRadioButton("Off-Peak (12:00 A.M. through 5:59 A.M.)");
        
        //set one radio button to be automatically selected
        radDay.setSelected(true);
        
        //put radio buttons in button group
        bg = new ButtonGroup();
        bg.add(radDay);
        bg.add(radEvening);
        bg.add(radOffPeak);
        
        //put border on panel
        setBorder(BorderFactory.createTitledBorder("Size"));
        
        //add buttons to panel
        add(radDay);
        add(radEvening);
        add(radOffPeak);
    }
    
    /**
     * Gets the rate of from the category the user chooses
     * @return the rate of the category the user chooses
     */
    public double getLongDistanceRate()
    {
        if (radDay.isSelected())
            return .07;
        else if (radEvening.isSelected())
            return .12;
        else
            return .05;
    }
}