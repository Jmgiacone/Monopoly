package Monopoly;

import java.awt.geom.Point2D;

/**
 *
 * @author Jordan
 */
public class Property extends Space implements Improvable
{
    protected final int price, mortgagedPrice; 
    private final int BASE, HOUSE1, HOUSE2, HOUSE3, HOUSE4, HOTEL;
    private int rent; 
    private String owner;
    private boolean mortgaged;
    
    public Property(String newName, int newPrice, int newRent, int newH1, 
            int newH2, int newH3, int newH4, int newHotel, Point2D coord)
    {
        super(newName, coord, -999);
        price = newPrice;
        mortgagedPrice = price / 2;
        BASE = newRent;
        rent = BASE;
        HOUSE1 = newH1;
        HOUSE2 = newH2;
        HOUSE3 = newH3;
        HOUSE4 = newH4;
        HOTEL = newHotel;
        owner = "";
        mortgaged = false;
    }
    
    /**
     * An overridden method from interface improvable
     */
    @Override
    public void improve()
    {
        
    }
    
    /**
     * Returns the price of the property
     * @return the price of the property
     */
    public int getPrice()
    {
        if(mortgaged)
        {
            return mortgagedPrice;
        }
        
        return price;
    }
    
    public int getMortgagedPrice()
    {
        return mortgagedPrice;
    }
    /**
     * Returns the owner of the property. If none, returns the bank.
     * @return 
     */
    public String getOwner()
    {
        if(owner.equalsIgnoreCase(""))
        {
            return "The Bank";
        }
        return owner;
    }
    
    /**
     * Returns whether or not the property is owned
     * @return True if it is, false if not;
     */
    public boolean isOwned()
    {
        return !owner.equalsIgnoreCase("");
    }
    @Override
    public String toString()
    {
        return name + ""
                + "\nBuy: "+price+""
                + "\nMortgage: "+price / 2
                + "\nNo Houses: "+BASE
                + "\nAll Owned: "+BASE * 2
                + "\n1 House: " +HOUSE1
                + "\n2 Houses: "+HOUSE2
                + "\n3 Houses: "+HOUSE3
                + "\n4 Houses: "+HOUSE4
                + "\nHotel: "+HOTEL;
                
    }
    
    public boolean isMortgaged()
    {
        return mortgaged;
    }
    
    public void mortgage()
    {
        mortgaged = true;
    }
    
    public void unMortgage()
    {
        mortgaged = false;
    }
    
    public int currentRent()
    {
        return rent;
    }
}
