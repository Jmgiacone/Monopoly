/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
    boolean isClaimed;
    
    public Piece(String newName)
    {
        owner = "";
        position = 0;
        name = newName;
        //image = newImage;
        isClaimed = false;
    }
    
    public void claim(String newOwner)
    {
        owner = newOwner;
    }
    public void move(int spaces)
    {
        for(int i = 0; i < spaces; i++)
        {
            if(position >= 40)
            {
                position = 0;
            }
            position++;
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
    
    
}
