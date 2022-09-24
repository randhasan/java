import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FontColorPanel extends JPanel
{
    private JButton btnBackground, btnForeground;
    private JColorChooser colorChooser;
    
    public FontColorPanel()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Color"));
        colorChooser = new JColorChooser();
        btnBackground = new JButton("Set Background Color");
        btnForeground = new JButton("Set Foreground Color");
        add(colorChooser,BorderLayout.NORTH);
        add(btnForeground, BorderLayout.CENTER);
        add(btnBackground, BorderLayout.SOUTH);
        btnForeground.addActionListener(new ColorListener());
        btnBackground.addActionListener(new ColorListener());
    }
    
    public Color[] getFontColors()
    {
        Color[] colorList = {btnForeground.getForeground(),btnBackground.getBackground()};
        return colorList;
    }
    
    private class ColorListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()==btnForeground)
                btnForeground.setForeground(colorChooser.getColor());
            else
                btnBackground.setBackground(colorChooser.getColor());
            
        }
        
    }
}
