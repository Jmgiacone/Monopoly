package Monopoly;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
    
    public Piece(String newName)
    {
        owner = "";
        position = 0;
        name = newName;
        image = setUpImage();
        claimed = false;
    }
    
    private BufferedImage setUpImage()
    {
        BufferedImage bi = null;
        int w, h, cw, ch; 
        try 
        {             
            bi = ImageIO.read(new File("Thimble.gif"));             
            //w = bi.getWidth(null);             
            //h = bi.getHeight(null);         
        } 
        catch (IOException e) 
        {             
            System.out.println("Image could not be read");            
            System.exit(1); 
        }
        
        return bi;

    }
    
    public Point2D.Double getCoords()
    {
        return Board.board[position].getCoords();
    }
    public boolean isClaimed()
    {
        return claimed;
    }
    
    public void claim(String newOwner)
    {
        owner = newOwner;
        claimed = true;
    }
    public void move(int spaces)
    {
        position += spaces;
        
        if(position >= 40)
        {
            position -= 40;
        }
        
    }
    public int getPosition()
    {
        return position;
    }
    public String getName()
    {
        return name;
    }
    
    public void moveTo(int x)
    {
        position = x;
    }
    
    public String getOwner()
    {
        return owner;
    }
    
}