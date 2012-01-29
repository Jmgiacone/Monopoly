/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

/**
 *
 * @author Jordan
 */
public class Utility extends Property 
{
    public Utility(String newName, int newPrice)
    {
        //Rent is 4x roll if 1 is owned, 10x if both.
        super(newName, newPrice,-1,-1,-1,-1,-1,-1);
        utility = true;
    }
    
    
}
