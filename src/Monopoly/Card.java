package Monopoly;

/**
 *
 * @author Jordan
 */
public class Card 
{
    private String message, name;
    private int reward, moveToIndex;
    private boolean special;
    
    /**
     * Constructs a card with a name, message, and reward
     * @param name The name of the card
     * @param newMessage The message of the card(go directly to jail, etc...)
     * @param newReward The monetary reward of the card (Collect $200, etc...)
     * @param moveTo The space(if any) that the card directs the Player
     * @param s Whether or not it's 'special'
     */
    public Card(String name, String newMessage, int newReward, int moveTo, boolean s)
    {
        this.name = name;
        special = s;
        moveToIndex = moveTo;
        message = newMessage;
        reward = newReward;
        
    }
    
    /**
     * Gets the message on the Card
     * @return The message on the Card
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Returns if the Card send the Player to another spot
     * @return if the Card send the Player to another spot
     */
    public boolean needsToMove()
    {
        return moveToIndex != -1;
    }
    
    /**
     * IS this card special?
     * @return If it is
     */
    public boolean isSpecial()
    {
        return special;
    }
    
    /**
     * The index that the Card directs the Player (-1 if none)
     * @return index
     */
    public int getMoveTo()
    {
        return moveToIndex;
    }
    /**
     * Returns the reward given by the particular card
     * @return The reward
     */
    public int getReward()
    {
        return reward;
    }
    
    /**
     * Displays the name of the card, and then the message
     * @return The name and message of the card
     */
    @Override
    public String toString()
    {
        return name + "\n\n" + message;
    }
}
