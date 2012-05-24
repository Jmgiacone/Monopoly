package Monopoly;

import java.awt.BorderLayout;
import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author Jordan
 */
public class MonopolyGUI extends JApplet 
{
    public static Board b;
    private JPanel topButtons, bottomButtons;
    
    public MonopolyGUI()
    {
        b = new Board(200, true);
        initButtons();
        initPanels();
        addElements();
        
    }
    
    private void initButtons()
    {
        
    }
    private void initPanels()
    {
        topButtons = new JPanel();
        bottomButtons = new JPanel();
    }
    private void addElements()
    {
        getContentPane().add(topButtons, BorderLayout.NORTH);
        getContentPane().add(b.getBoard(), BorderLayout.CENTER);
        getContentPane().add(bottomButtons, BorderLayout.SOUTH);
    }
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() 
    {
        setSize(400, 400);
        setVisible(true);
    }
    // TODO overwrite start(), stop() and destroy() methods
}
