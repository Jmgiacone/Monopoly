package Monopoly;

import java.io.File;

/**
 *
 * @author Jordan
 */
public class Piece 
{
    private String name, owner;
    private File image;
    private int position;
    boolean claimed;
    
    public Piece(String newName)
    {
        owner = "";
        position = 0;
        name = newName;
        //image = newImage;
        claimed = false;
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
    
    public String getOwner()
    {
        return owner;
    }
    
}