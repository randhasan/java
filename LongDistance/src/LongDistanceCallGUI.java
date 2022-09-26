import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Rand Hasan
 * LongDistanceCallGUI.java
 * This program is a GUI in which the user can calculate the price of a phone call
*/
public class LongDistanceCallGUI extends JFrame
{
    private JPanel callLength, calculatePrice;
    private JLabel lblLengthOfCall, lblPhone;
    private JTextField txtLengthOfCall;
    private JButton calcButton;
    private LongDistanceRatePanel callTime;
    private double rate;
    
    public LongDistanceCallGUI()
    {
        // window title
        setTitle("Long Distance Calls");
        
        // set Layout manager for the JFrame
        setLayout(new GridLayout(4,1));
        
        // user must click quit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // creates the panels
        buildPanels();
        
        // add all components to the frame in GridLayout
        add(callLength);
        add(callTime);
        add(lblPhone);
        add(calculatePrice);
        
        pack(); //alternative to setting size
        setVisible(true);
    }
    
    /**
     * Builds the panels that go in the GridLayout
     */
    private void buildPanels()
    {
        // instructions as a label
        lblLengthOfCall = new JLabel("Length of call (in minutes)");
        
        ImageIcon image = new ImageIcon("phone.png");
        lblPhone = new JLabel(image);
        
        // a text field for the user to enter the length of their call
        txtLengthOfCall = new JTextField(10);
        
        // button that allows user to calculate
        calcButton = new JButton("Calculate cost");
        calcButton.addActionListener(new CalculateListener());
        
        // instantiates panels
        callLength = new JPanel();
        callTime = new LongDistanceRatePanel(); //another class will add the buttons
        calculatePrice = new JPanel();
        
        // adds panels
        callLength.add(lblLengthOfCall);
        callLength.add(txtLengthOfCall);
        calculatePrice.add(calcButton);
    }
    
    private class CalculateListener implements ActionListener
    {
        /**
         * Calculates and displays the cost of the call
         */
        @Override
        public void actionPerformed(ActionEvent e)
        {
            rate = callTime.getLongDistanceRate();
            LongDistanceCall longDistanceCall = new LongDistanceCall();
            longDistanceCall.setMinutes(Integer.parseInt(txtLengthOfCall.getText()));
            JOptionPane.showMessageDialog(null, "The cost of the call is " +String.format("$%.2f", longDistanceCall.getCost(rate)));
        }
    }
    
    public static void main(String[] args) 
    {
        LongDistanceCallGUI distance = new LongDistanceCallGUI();
    }

}
