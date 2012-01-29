/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

/**
 *
 * @author Jordan Giacone
 */
public class Space 
{
    protected String name;
    protected boolean property, utility, railroad,card;
    
    /**
     * Constructs a space with the given name(most likely to be casted
     * otherwise later)
     * @param newName The name to be given
     */
    public Space(String newName)
    {
        name = newName;
        property = false;
        utility = false;
        railroad = false;
        card = false;
        
    }
    
    /**
     * Tells whether or not the selected space is also a property
     * @return True if it is, false if not
     */
    public boolean isProperty()
    {
        return property;
    }
    
    /**
     * Tells whether or not the selected space is also a card
     * @return True if it is, false if not 
     */
    public boolean isCard()
    {
        return card;
    }
    
    /**
     * Returns the name of the space
     * @return The name of the space
     */
    public String getName()
    {
        return name;
    }
}
