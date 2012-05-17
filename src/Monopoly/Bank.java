package Monopoly;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class Bank 
{
    public static int PASS_GO_AMOUNT, LAND_ON_GO_AMOUNT;
    
    private static ArrayList<Property> properties;
    private static ArrayList<Card> chance, communityChest;
    
    //Bank never runs out of money, no need for a balance variable
    public Bank(int passGo)
    {
        PASS_GO_AMOUNT = passGo;
        LAND_ON_GO_AMOUNT = PASS_GO_AMOUNT * 2;
        properties = new ArrayList<>();
        chance = new ArrayList<>();
        communityChest = new ArrayList<>();
        
        initCards();
    }
    
    public static void remove(Property p)
    {
        properties.remove(p);
    }        
    public static Property getProperty(String s)
    {
        for(Property p : properties)
        {
            if(p.getName().equalsIgnoreCase(s))
            {
                return p;
            }
        }
        
        return null;
    }
    
    public static Card drawChance()
    {
        Card c = chance.get(0);
        chance.add(chance.remove(0));
        return c;
    }
    public static Card drawCommunityChest()
    {
        Card c = communityChest.get(0);
        communityChest.add(communityChest.remove(0));
        return c;
    }
    private void initCards()
    {
        for(Space s : Board.board)
        {
            if(s instanceof Property)
            {
                properties.add((Property)s);
            }
        }
    }
}