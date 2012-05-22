/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import java.awt.geom.Point2D;

/**
 *
 * @author Jordan
 */
public class Utility extends Property 
{
    public Utility(String newName, int newPrice, Point2D.Double coord)
    {
        //Rent is 4x roll if 1 is owned, 10x if both.
        super(newName, newPrice,-1,-1,-1,-1,-1,-1, coord);
    }
    
    
}
