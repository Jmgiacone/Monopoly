package Monopoly;

import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordan
 */
public class Property extends Space
{
    protected final int price, mortgagedPrice,BASE, HOUSE1, HOUSE2, HOUSE3, HOUSE4, HOTEL, ONE_HOUSE; 
    protected final ImageIcon propertyCard, houseCard, hotelCard;
    protected int rent, numHouses; 
    protected String owner, group;
    protected boolean mortgaged, vert;
    private Point2D.Double houseCoord;
    
    public Property(String newName, int newPrice, int newRent, int newH1, 
            int newH2, int newH3, int newH4, int newHotel, Point2D.Double coord, int oneHouse, String dir, Point2D.Double hc, String g)
    {
        super(newName, coord, -999);
        vert = dir.equalsIgnoreCase("v");
        houseCoord = hc;
        propertyCard = new ImageIcon("images/properties/" + name +".jpg");
        houseCard = new ImageIcon("images/house.png");
        hotelCard = new ImageIcon("images/hotel_"+ dir +".png");
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
        numHouses = 0;
        ONE_HOUSE = oneHouse;
        group = g;
    }
    /**
     * Does it have a hotel?
     * @return t or f
     */
    public boolean hasHotel()
    {
        return rent  == HOTEL;
    }
    
    /**
     * Adds a hotel
     */
    public void addHotel()
    {
        numHouses = 0;
        rent = HOTEL;
    }
    /**
     * Gets the coordinates
     * @return Coordinates of the House
     */
    public Point2D.Double getHouseCoord()
    {
        return houseCoord;
    }
    
    /**
     * Is this Space facing vertically?
     * @return t or f
     */
    public boolean isVert()
    {
        return vert;
    }
    
    /**
     * How many Houses does it have
     * @return number of Houses
     */
    public int getNumHouses()
    {
        return numHouses;
    }
    
    /**
     * Sets owner to name
     * @param name The new owner
     */
    public void setOwner(String name)
    {
        owner = name;
        
        //Return back to bank
        if(owner.equalsIgnoreCase(""))
        {
            numHouses = 0;
            rent = BASE;
            mortgaged = false;
        }
    }
    
    /**
     * Gets the image of the Property Card
     * @return the image of the Property Card
     */
    public ImageIcon getPropertyImage()
    {
        return propertyCard;
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
    
    /**
     * Adds num houses
     * @param num Number of houses to add
     */
    public void addHouses(int num)
    {
        numHouses += num;
        if(numHouses == 1)
        {
            rent = HOUSE1;
        }
        else if(numHouses == 2)
        {
            rent  = HOUSE2;
        }
        else if(numHouses == 3)
        {
            rent = HOUSE3;
        }
        else if(numHouses == 4)
        {
            rent = HOUSE4;
        }
        else 
        {
            throw new UnknownError(owner + " tried to put " + numHouses + " on " + name);
        }
    }
    
    /**
     * Gets the price of a single house
     * @return One house price
     */
    public int getOneHousePrice()
    {
        return ONE_HOUSE;
    }
    
    /**
     * Gets the price when it's mortgaged
     * @return Mortgaged Price
     */
    public int getMortgagedPrice()
    {
        return mortgagedPrice;
    }
    /**
     * Returns the owner of the property. If none, returns The Bank.
     * @return The name of the owner
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
        return name + "\n"
                + "\nOwner: "+owner
                + "\nColor Group: "+group
                + "\nNumber of houses: " +numHouses
                + "\nBuy: $"+price
                + "\nMortgage: $"+price / 2
                + "\nNo Houses: $"+BASE
                + "\nAll Owned: $"+BASE * 2
                + "\n1 House: $" +HOUSE1
                + "\n2 Houses: $"+HOUSE2
                + "\n3 Houses: $"+HOUSE3
                + "\n4 Houses: $"+HOUSE4
                + "\nHotel: $"+HOTEL
                + "\nMortgaged: "+mortgaged
                + "\nHouses Cost $"+ONE_HOUSE
                + "\nHotels $"+ONE_HOUSE + " plus 4 Houses";
    }
    
    /**
     * What's it's color group?
     * @return Color group
     */
    public String getGroup()
    {
        return group;
    }
    
    /**
     * Is it mortgaged?
     * @return If it's mortgaged
     */
    public boolean isMortgaged()
    {
        return mortgaged;
    }
    
    /**
     * Mortgages it
     */
    public void mortgage()
    {
        mortgaged = true;
    }
    
    /**
     * Unmortgates it
     */
    public void unMortgage()
    {
        mortgaged = false;
    }
    
    /**
     * Gets current rent
     * @return Current Rent
     */
    public int currentRent()
    {
        return rent;
    }
}
