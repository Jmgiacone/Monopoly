/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

/**
 *
 * @author Jordan
 */
public class Card 
{
    private String message, name;
    private int reward;
    
    /**
     * Constructs a card with a name, message, and reward
     * @param newName The name of the card(chance, community chest)
     * @param newMessage The message of the card(go directly to jail, etc...)
     * @param newReward The monetary reward of the card (Collect $200, etc...)
     */
    public Card(String newName, String newMessage, int newReward)
    {
        name = newName;
        message = newMessage;
        reward = newReward;
        
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
    public String toString()
    {
        return name + "\n" + message;
    }
}
