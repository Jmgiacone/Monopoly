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
public enum Piece 
{
    CANNON,
    DOG,
    BATTLESHIP,
    CAR,
    IRON,
    TOP_HAT,
    THIMBLE,
    WHEELBARROW,
    SHOE,
    MONEY_BAG;

    private String name;
    private BufferedImage image;
    private int position;
    
    /**
     * Constructs a Piece object with Given name
     */
    Piece()
    {
        position = 0;
        name = "";
        String[] words = super.toString().toLowerCase().split("_");
        for(int i = 0; i < words.length; i++)
        {
            name += words[i].substring(0,1).toUpperCase() + words[i].substring(1);

            if(i != words.length - 1)
            {
                name += " ";
            }
        }
        setUpImage("images/pieces/" + name + ".png");
    }
    
    private void setUpImage(String path)
    {
        try
        {
            image =  ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Image couldn't be found at " + path);
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

    @Override
    public String toString()
    {
        return name;
    }
}