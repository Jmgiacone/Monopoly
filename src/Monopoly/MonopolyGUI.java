/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import javax.swing.*;

/**
 *
 * @author Jordan
 */
public class MonopolyGUI extends JApplet 
{
    private Board b;
    private JLabel background;
    public MonopolyGUI()
    {
        b = new Board();
        background = new JLabel(new ImageIcon("images/monopoly-board.png"));
        
    }
    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
    @Override
    public void init() 
    {
        //b.start();
        getContentPane().add(background); 
//        while(!b.isWinner())
//        {
//            
//        }
    }
    // TODO overwrite start(), stop() and destroy() methods
}
