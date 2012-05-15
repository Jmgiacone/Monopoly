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
public class RailRoad extends Property
{
    public RailRoad(String newName, int newPrice, Point2D coord)
    {
       super(newName, newPrice,-1,-1,-1,-1,-1,-1, coord);
    }
    
    @Override
    public String toString()
    {
        return name + "\n"
                + "\nBuy: "+price+""
                + "\nMortgage: "+price / 2
                + "\nOwn 1 Railroad: 25" 
                + "\nOwn 2 Railroads: 50"
                + "\nOwn 3 Railroad: 100" 
                + "\nOwn 4 Railroads: 200";
    }
    
    
}
