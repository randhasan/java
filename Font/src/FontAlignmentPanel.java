import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class FontAlignmentPanel extends JPanel
{
    private JRadioButton center, left, right;
    private ButtonGroup bg;
    
    public FontAlignmentPanel() {
        setLayout(new GridLayout(3,1));
        setSize(50, 100);
        
        center = new JRadioButton("Center");
        left = new JRadioButton("Left");
        right = new JRadioButton("Right");
        
        left.setSelected(true);
        
        bg = new ButtonGroup();
        bg.add(center);
        bg.add(left);
        bg.add(right);
        
        setBorder(BorderFactory.createTitledBorder("Alignment"));
        
        add(center);
        add(left);
        add(right);
                
    }
    
    public int getAlignment()
    {
        if (center.isSelected())
            return SwingConstants.CENTER;
        else if (right.isSelected())
            return SwingConstants.RIGHT;
        else
            return SwingConstants.LEFT;
    }
}
