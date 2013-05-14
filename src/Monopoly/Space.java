package Monopoly;

import java.awt.geom.Point2D;

/**
 *
 * @author Jordan Giacone
 */
public class Space 
{
    protected String name;
    protected final Point2D.Double coords;
    protected final int reward;
    
    /**
     * Constructs a space with the given name(most likely to be casted
     * otherwise later)
     * @param newName The name to be given
     */
    public Space(String newName, Point2D.Double coord, int newReward)
    {
        name = newName;
        coords = coord;
        reward = newReward;
    }
    
    /**
     * Returns the name of the space
     * @return The name of the space
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the coordinates that the Piece lands on
     * @return The coordinates
     */
    public Point2D.Double getCoords()
    {
        return coords;
    }
    
    /**
     * The reward of the Space
     * @return Reward
     */
    public int getReward()
    {
        return reward;
    }
}