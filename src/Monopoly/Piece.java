package Monopoly;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Jordan
 */
public class Piece 
{
    private String name, owner;
    private BufferedImage image;
    private int position;
    boolean claimed;
    
    /**
     * Constructs a Piece object with Given name
     * @param newName The name of the Piece
     */
    public Piece(String newName)
    {
        owner = "";
        position = 0;
        name = newName;
        setUpImage("images/pieces/"+name+".png");
        claimed = false;
    }
    
    private void setUpImage(String path)
    {
        try
        {
            image =  ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Image couldn't be found at " 
                    + path);
            System.exit(0);
        }
    }
    
    /**
     * Gets the image of the Piece
     * @return The image
     */
    public BufferedImage getImage()
    {
        return image;
    }
    
    /**
     * Moves the Piece spaces spaces
     * @param spaces The number of Spaces to move
     */
    public void move(int spaces)
    {
        position += spaces;
        
        if(position >= 40)
        {
            position -= 40;
        }
        
    }
    
    /**
     * Gets the current position of the Piece
     * @return Current position
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Gets the name of the Piece
     * @return The name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Moves the Piece to the specified positon
     * @param x the Positon to move to 
     */
    public void moveTo(int x)
    {
        position = x;
    }
    
    /**
     * Gets the owner of the Piece
     * @return The owner of the piece
     */
    public String getOwner()
    {
        return owner;
    }
    
}