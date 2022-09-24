import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Puts everything together, border Layout panels, radio buttons, etc.
 * using aggregate classes
 * @author Valerie Klosky
 */
public class FontGUI extends JFrame implements ActionListener
{
	private JPanel wordsPanel, buttonPanel, middlePanel;
	private JButton btnSetFont, btnExit;
	private JLabel lblWords;
	private JTextField txtWords;
	private FontSizePanel sizePanel;
	private FontStylePanel stylePanel;
	private FontFacePanel fontPanel;
	private FontColorPanel colorPanel;
	private FontAlignmentPanel alignmentPanel;

	/**
	 * constructor
	 */
	public FontGUI()
	{
		setTitle("Font Sampler");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//user must click quit

		//set Layout manager for the JFrame
		setLayout(new BorderLayout());

		

		//create custom panels
		sizePanel = new FontSizePanel();
		stylePanel = new FontStylePanel();
		fontPanel = new FontFacePanel();
		colorPanel = new FontColorPanel();
		alignmentPanel = new FontAlignmentPanel();

		//create words panel
		makeWordsPanel();
		
		//create button panel;
		makeButtonPanel();

		//put style and font in the middle panel
		middlePanel = new JPanel();
		middlePanel.setLayout(new GridLayout(1, 3));
		middlePanel.add(stylePanel);
		middlePanel.add(fontPanel);
		middlePanel.add(alignmentPanel);

		//add all components to the frame in borderLayout
		add(wordsPanel,BorderLayout.NORTH);
		add(buttonPanel,BorderLayout.SOUTH);
		add(sizePanel,BorderLayout.WEST);
		add(middlePanel,BorderLayout.CENTER);
		add(colorPanel,BorderLayout.EAST);
		
		pack(); //alternative to setting size
		setVisible(true);
	}

	private void makeButtonPanel()
	{
		buttonPanel = new JPanel();

		//create buttons
		btnSetFont = new JButton("Set Font");
		btnExit = new JButton("Exit");

		//register action listeners
		btnSetFont.addActionListener(this);
		btnExit.addActionListener(this);

		buttonPanel.add(btnSetFont);
		buttonPanel.add(btnExit);
	}
	
	private void makeWordsPanel()
	{
	    
		wordsPanel =  new JPanel(new GridLayout(2,1));
	
		lblWords = new JLabel("");
		wordsPanel.add(lblWords);

		txtWords = new JTextField("Spring Break was awesome!");
		wordsPanel.add(txtWords);
	}
	
	

	public void actionPerformed(ActionEvent e)
	{
	    if (e.getSource()==btnExit)
	        System.exit(0);
	    int size = sizePanel.getFontSize();
	    int style = stylePanel.getFontStyle();
	    String font = fontPanel.getFontFace();
	    Color[] colorList = colorPanel.getFontColors();
	    lblWords.setForeground(colorList[0]);
	    lblWords.setBackground(colorList[1]);
	    lblWords.setOpaque(true);
	    
	    int align = alignmentPanel.getAlignment();
        txtWords.setHorizontalAlignment(align);
	    lblWords.setText(txtWords.getText());
	    lblWords.setFont(new Font(font,style,size));
	    lblWords.setHorizontalAlignment(align);
	    
	    //pack(); //auto resize the JFrame
	    repaint();
	}
	
	public static void main(String[] args) 
	{
		 FontGUI font = new FontGUI();
	}
}
