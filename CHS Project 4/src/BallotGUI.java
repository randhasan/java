import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 * @author Rand Hasan
 * BallotGUI.java
 * This program is a GUI which simulates a ballot for users to make votes
*/

public class BallotGUI extends JFrame implements ActionListener
{
    private ArrayList<Ballot> ballots;
    private JPanel bPanel; //panel with voting options
    private JPanel votingPanel; //panel to cast vote or login
    private JButton login;
    private JButton cast;
    private String id; //id of user voting

    public BallotGUI()
    {
        id = "";
        getBallots();
        // window title
        setTitle("Voting Machine");
        
        // set Layout manager for the JFrame
        setLayout(new BorderLayout(1,3));
        
        // user must click quit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //only close after clicking quit
        
        // creates the panels
        buildPanels();
        
        // add all components to the frame in GridLayout
        add(bPanel,BorderLayout.WEST); //buttons
        add(votingPanel,BorderLayout.EAST); //voting buttons
        
        for (Ballot b:ballots)
        {
            ArrayList<JButton> buttons = b.getcButtons();
            for (JButton button:buttons)
            {
                button.setEnabled(false);
            }
        }
        cast.setEnabled(false);

        pack(); //alternative to setting size
        setVisible(true);
    }

    /**
     * Builds the panels of the BorderLayout
     */
    private void buildPanels()
    {
        bPanel = new JPanel(); //ballots
        bPanel.setLayout(new GridLayout(1,ballots.size()));
        for (int i = 0; i<ballots.size(); i++)
        {
            JPanel candidates = new JPanel();
            candidates.setLayout(new GridLayout(1+ballots.get(i).getcButtons().size(),1));
            JLabel label = new JLabel("");
            label.setOpaque(false);
            JTextField text = new JTextField(ballots.get(i).getOffice());
            label.setText(text.getText());
            label.setHorizontalAlignment(JLabel.CENTER);
            candidates.add(label);
            
            for (int j = 0; j<ballots.get(i).getcButtons().size(); j++)
            {
                JButton button = ballots.get(i).getcButtons().get(j);
                button.addActionListener(this);
                candidates.add(button);
            }
            bPanel.add(candidates);
        }
        
        votingPanel = new JPanel(); //panel to cast vote or login
        votingPanel.setLayout(new GridLayout(1,2));
        login = new JButton("Login to Vote");
        login.addActionListener(this);
        votingPanel.add(login);
        cast = new JButton("Cast your Vote");
        cast.addActionListener(this);
        votingPanel.add(cast);
        
    }
    
    /**
     * Gets ballots for user to vote
     */
    public void getBallots()
    {
        String fileName = "";
        try {
            System.out.print("Please enter the name of the file with the ballots: "); //user enters file name with ballots in command line
            Scanner input = new Scanner(System.in);
            fileName = input.nextLine();
            Scanner inFile = new Scanner(new File(fileName));
            ballots = new ArrayList<Ballot>();
            int numLines = Integer.parseInt(inFile.nextLine());
            for (int i = 0; i<numLines; i++)
            {
                Ballot b = new Ballot(inFile.nextLine());
                ballots.add(b);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error: file was not found, please try again."); //if file doesn't exist, ask for name again
            fileName = "";
            getBallots();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==login) //if user clicks login
        {
            boolean invalidId = true; //id is not in voters.txt file
            boolean hasVoted = false; //if user has voted
            while (id.length()!=4 || invalidId)  //id must be 4 characters long and has to exist in the voters.txt file
            {
                id = JOptionPane.showInputDialog("Please enter your voter ID");
                try
                {
                    Scanner inFile = new Scanner(new File("voters.txt"));
                    while (inFile.hasNextLine())
                    {
                        String[] line = inFile.nextLine().split(":");
                        if (line[0].equals(id)) //if user's id is in a line in the voters.txt file
                        {
                            invalidId = false; //id is in file
                            if (line[2].equals("true")) //user has already voted
                            {
                                JOptionPane.showMessageDialog(null, line[1]+", you have already voted!");
                                hasVoted = true;
                            }
                        }
                    }
                    inFile.close();
                } 
                catch (FileNotFoundException e1)
                {
                    System.out.println("Error: File not found"); //won't reach
                } 
            }
            
            if (hasVoted==false) //user hasn't voted
            {
                login.setEnabled(false); //cannot try to login again
                for (Ballot b:ballots)
                {
                    ArrayList<JButton> buttons = b.getcButtons();
                    for (JButton button:buttons)
                    {
                        button.setEnabled(true); //enables voting buttons
                    }
                }
                cast.setEnabled(true); //enables button to cast vote
            }
        }
        
        for (Ballot b:ballots)
        {
            ArrayList<JButton> buttons = b.getcButtons();
            for (JButton button:buttons)
            {
                if (e.getSource() == button)
                {
                    b.setChosen(button); //user has selected a button if they clicked it
                }
            }
        }
        
        for (Ballot b:ballots)
        {
            ArrayList<JButton> buttons = b.getcButtons();
            for (JButton button:buttons)
            {
                if (button.equals(b.getChosen())) //if a button was selected, turn the text red
                {
                    button.setForeground(Color.RED);
                }
                else //otherwise the text should be black
                {
                    button.setForeground(Color.BLACK);
                }
            }   
            
            if (e.getSource()==cast) //user tries to cast vote
            {
                int reply = JOptionPane.showConfirmDialog(null,"Confirm vote?","Cancel",JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Thank you for your vote!");
                    try
                    {
                        editFiles();
                    } 
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                    System.exit(0); //quits program
                }
            }
        }
        pack(); //auto resize the JFrame
        repaint();
    }
    
    /**
     * This program will edit and update files about ballots and voters.txt in a safe way 
     * @throws IOException
     */
    public void editFiles() throws IOException
    {
        try
        {
            for (Ballot b:ballots)
            {
                File f = new File(Integer.toString(b.getId())+".txt"); //text file for ballot
       
                if (!f.exists()) //if the ballot file doesn't exist
                {
                    FileWriter writer = new FileWriter(f);
                    ArrayList<JButton> buttons = b.getcButtons();
                    for (JButton button:buttons)
                    {
                        if (button == b.getChosen()) //the chosen ballot has one vote
                        {
                            writer.write(button.getText()+":1\n");
                        }
                        else //ballots have zero votes
                        {
                            writer.write(button.getText()+":0\n");
                        }
                    }
                    writer.close();
                }
                else //if the ballot file does exist
                {
                    File newFile = new File("temp.txt");
                    FileWriter writer = new FileWriter(newFile);
                    Scanner readF = new Scanner(f);
                    
                    ArrayList<JButton> buttons = b.getcButtons();
                    for (JButton button:buttons)
                    {
                        if (button == b.getChosen()) //adds vote to however many votes the choice already has
                        {
                            String readLine = readF.nextLine();
                            String[] splitUpLine = readLine.split(":");
                            writer.write(splitUpLine[0]+":"+(Integer.parseInt(splitUpLine[1])+1)+"\n");
                        }
                        else
                        {
                            writer.write(readF.nextLine()+"\n"); //just rewrites the line from the old file
                        }
                    }
                    writer.close();
                    f.delete();
                    newFile.renameTo(new File(Integer.toString(b.getId())+".txt"));
                }
            }
            
            File newF = new File("newVoters.txt");
            FileWriter writeFile = new FileWriter(newF.getAbsoluteFile());
            File file = new File("voters.txt");
            Scanner inFile = new Scanner(file);
            while (inFile.hasNextLine())
            {
                String line = inFile.nextLine();
                String[] lineSplit = line.split(":");
                if (lineSplit[0].equals(id)) //changes voter's status of having voted to true
                {   
                    writeFile.write(lineSplit[0]+":"+lineSplit[1]+":"+"true\n");
                }
                else
                {
                    writeFile.write(line+"\n");
                }
            }
            file.delete();
            inFile.close();
            writeFile.close();
            newF.renameTo(new File("voters.txt"));
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("Error: file was not found");
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        BallotGUI ballots = new BallotGUI();
    }
}
