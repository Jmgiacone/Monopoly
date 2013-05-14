package Monopoly;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author Jordan
 */
public class Player implements Comparable<Player>
{
    private String name;
    private int balance, roll1, roll2, numRailroadsOwned, numUtilitiesOwned, doubleCount;
    private Random random;
    private Piece piece;
    private boolean inJail, doubles, bankrupt, hasGetOutOfJail; 
    
    private ArrayList<Property> properties;
    
    public Player(String newName, Piece newPiece)
    {
        hasGetOutOfJail = false;
        random = new Random();
        doubleCount = 0;
        piece = newPiece;
        name = newName;
        roll1 = 0;
        roll2 = 0;
        balance = 1500;
        properties = new ArrayList<>();
        inJail = false;
        doubles = false;
        bankrupt = false;
        numRailroadsOwned = 0;
        numUtilitiesOwned = 0;
    }
    
    /**
     * Returns if the Player has all the properties of a specific Color group
     * @param group Color group to be searched for
     * @return True or false
     */
    public boolean hasAllPropertiesInGroup(String group)
    {
        int needNum, have  = 0;
        if(group.equalsIgnoreCase("Dark Blue") || group.equalsIgnoreCase("Purple"))
        {
            needNum = 2;
        }
        else
        {
            needNum = 3;
        }
        
        for(Property p : properties)
        {
            if(p.getGroup().equalsIgnoreCase(group))
            {
                have++;
            }
            if(have == needNum)
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Tallies up the number of Properties in specified group
     * @param group Group to be tallied
     * @return True or false
     */
    public int getNumPropertiesInGroup(String group)
    {
        int have  = 0;
        
        for(Property p : properties)
        {
            if(p.getGroup().equalsIgnoreCase(group))
            {
                have++;
            }
            
        }
        
        return have;
    }
    
    /**
     * Buys a hotel for the Property
     * @param p The property to get a Hotel
     * @return A string saying that it worked
     */
    public String buyHotel(Property p)
    {
        if(properties.contains(p))
        {
            int x = p.getOneHousePrice();
            
            if(balance - x >= 0)
            {
                balance -= x;
                p.addHotel();
                return "\n"+name+" successfully bought a hotel for "+p.getName();
            }
            else
            {
                return "\n"+name+" can't afford a Hotel on " + p.getName();
            }
        }
        throw new UnknownError(name+" doesn't own "+p.getName());
    }
    
    /**
     * Buys houses for the Property
     * @param p The Property to receive houses
     * @param num The number of houses
     * @return A message
     */
    public String buyHouses(Property p, int num)
    {
        if(properties.contains(p))
        {
            int x = (p.getOneHousePrice() * num);
            
            if(balance  - x >= 0)
            {
                balance -= x;
                p.addHouses(num);
                return "\n"+name+" successfully bought " + num + " houses!";
            }
            else
            {
                return "\n"+name+" can't afford " + num + " houses!";
            }
        }
        throw new UnknownError(name+" doesn't own "+p.getName());
    }
    
    /**
     * Does the player have doubles?
     * @return true or false
     */
    public boolean hasDoubles()
    {
        boolean temp = doubles;
        doubles = false;
        return temp;
    }
    
    /**
     * Is the Player bankrut?
     * @return t or f
     */
    public boolean isBankrupt()
    {
        return balance < 0;
    }
    
    /**
     * Gets their name
     * @return The name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets their Piece
     * @return Their Piece
     */
    public Piece getPiece()
    {
        return piece;
    }
    
    /**
     * Gets the number of Utilities that they own
     * @return Number of Utilities
     */
    public int getNumUtilities()
    {
        return numUtilitiesOwned;
    }
    
    /**
     * Gets the number of Railroads that they own
     * @return the number of Railroads that they own
     */
    public int getNumRailRoads()
    {
        return numRailroadsOwned;
    }
    
    /**
     * Another indexOf
     * @param n name to be found
     * @return index
     */
    public int indexOf(String n)
    {
        int i = 0;
        for(Property p: properties)
        {
            if(p.getName().equalsIgnoreCase(n))
            {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    /**
     * Goes through all the simulated if statements for the Player landing on a specific spot
     * @param board The board(to get spaces, duh!)
     * @param b The bank to do things with
     * @return A happy message
     */
    public String landOn(Board board, Bank b)
    {
        Space s = board.getBoard()[getPiecePosition()];
        BuyPropertyDialog buy;
        //If it's a property
        if(s instanceof Property)
        {
            //If you own it, nothing happens
            if(properties.contains((Property)s))
            {
                return s.getName() + " belongs to you, no money is due\n";
            }
            //Not yours, you have to pay
            else
            {
                //Utilities pay differently
                if(s instanceof Utility)
                {
                    Utility u = (Utility)s;
                    if(!u.isOwned())
                    {
                        buy = new BuyPropertyDialog(null, u);
                        
                        if(buy.didBuy())
                        {
                            return buy(u, b);
                        }
                        return name + " chose not to buy " + u.getName()+"\n";
                    }
                    else
                    {
                        return pay(u, b);
                    }
                }
                //RailRoads are special
                else if(s instanceof RailRoad)
                {
                    RailRoad r = (RailRoad)s;
                    if(!r.isOwned())
                    {
                        //TODO: Ask if they want to buy
                        buy = new BuyPropertyDialog(null, r);
                        
                        if(buy.didBuy())
                        {
                            return buy(r, b);
                        }
                        return name + " chose not to buy " + r.getName()+"\n";
                    }
                    else
                    {
                        return pay(r, b);
                    }
                }
                else
                {
                    Property p = (Property)s;
                    //It's just a straight up property
                    
                    if(!p.isOwned())
                    {
                        //TODO: Ask if they want to buy
                        buy = new BuyPropertyDialog(null, p);
                        
                        if(buy.didBuy())
                        {
                            return buy(p, b);
                        }
                        return name + " chose not to buy " + p.getName()+"\n";
                    }
                    else
                    {
                        return pay(p, b);
                    }
                }
            }
        }
        else 
        {
            if(s.getName().equalsIgnoreCase("Income Tax"))
            {
                int total = balance, x;
                for(Property p : properties)
                {
                    total += p.getPrice();
                }
                
                if(total > 2000)
                {
                    balance -= 200;
                    x = 200;
                }
                else
                {
                    //Integer division on purpose
                    balance -= (total / 10);
                    x = (total / 10);
                }
                return name + " paid $"+ x +" in Income Tax\n";
                
            }
            else if(s.getName().equalsIgnoreCase("Go to Jail"))
            {
                inJail = true;
                //The MonopolyGUI.b index for jail
                piece.moveTo(10);
                return landOn(board, b);
            }
            else if(s.getName().equalsIgnoreCase("Luxury Tax"))
            {
                balance -= 75;
                
                return name + " paid $75 in Luxury Tax\n";
            }
            else if(s.getName().equalsIgnoreCase("Chance"))
            {
                return pay(b.drawChance(), b, board);
            }
            else if(s.getName().equalsIgnoreCase("Community Chest"))
            {
                return pay(b.drawCommunityChest(), b, board);
            }
            else if(s.getName().equalsIgnoreCase("Free Parking"))
            {
                //Do Nothing
                return name + " has received Free Parking. Yay!\n";
            }
            else if(s.getName().equalsIgnoreCase("Go"))
            {
                balance += b.LAND_ON_GO_AMOUNT;
                
                return name + " landed on Go. "+name+" received $"+ b.LAND_ON_GO_AMOUNT + "\n";
            }
            else if(s.getName().equalsIgnoreCase("Jail"))
            {
                if(inJail)
                {
                    return name + " has been sent to Jail for being dumb. Feel free to judge them\n";
                }
                return name + " is JUST VISITNG Jail. Please don't judge them in any way\n";
            }
            else
            {
                throw new UnknownError("This should never have been called");
            }
            
        }
    }
    
    /**
     * Are they in jail?
     * @return t or f
     */
    public boolean isInJail()
    {
        return inJail;
    }
    
    /**
     * Pays the dues on a specific card
     * @param c The Card
     * @param b The Bank
     * @param board the Board
     * @return a message
     */
    public String pay(Card c, Bank b, Board board)
    {
        JOptionPane.showMessageDialog(null, c);
        if(c.needsToMove())
        {
            if(c.isSpecial())
            {
                //Eh, dont wanna deal w/ specials now
            }
            
            if(c.getMessage().equalsIgnoreCase("Go Directly to Jail - Do not Pass Go, do not collect $200"))
            {
                inJail = true;
            }
            piece.moveTo(c.getMoveTo());
            return landOn(board, b);
        }
        else if(c.isSpecial())
        {
            if(c.getMessage().equalsIgnoreCase("Go back 3 spaces"))
            {
                piece.moveTo(piece.getPosition() - 3);
                
                return name + " moved back 3 spaces\n" + landOn(board, b);
            }
            else if(c.getMessage().equalsIgnoreCase("Get out of Jail Free\n"))
            {
                hasGetOutOfJail = true;
                return name + " has recieved a Get Out of Jail Free Card!\n";
            }
            //Eh, dont wanna deal w/ specials now
        }
        
        int x = c.getReward();
        if(x == 0)
        {
            //Do nothing, but to appease the all mighty compiler...
            return "";
        }
        else
        {
            balance += x;
            
            if(x < 0)
            {
                return name + " paid $" + (-1 * x) + "\n";
            }
            return name + " received $" + x +"\n";
        }
        
    }
    
    private int RRPayout(int numRR)
    {
        //LOLOL Geometric Sequence OP
        return (int)(25 * Math.pow(2, numRR - 1));
    }
    
    /**
     * Pays dues on a Railroad
     * @param r Railroad
     * @param b Bank
     * @return A message
     */
    public String pay(RailRoad r, Bank b)
    {
        if(r.getOwner().equalsIgnoreCase(name))
        {
            //Your property, no rent paid
            return r.getName() + " belongs to "+ r.getOwner() +", therefore no rent is due\n";
        }
        else if(!r.isMortgaged())
        {
            Player p = b.getPlayers().get(
                b.indexOf(
                r.getOwner()));
            
            if(p.numRailroadsOwned == 0)
            {
                throw new IllegalStateException(p.getName() + " does not own " + r.getName());
            }
            
            int x = RRPayout(p.numRailroadsOwned);
            balance -= x;
            p.acceptPayment(x);
            
            return name + " paid $" +x+ " to " + r.getOwner() + " for landing on " +r.getName()+ "\n";
        }
        //Mortgaged, no Payment. GG
        return r.getName() + " is mortgaged, therefore no rent is due\n";
    }
    
    /**
     * Pays the landing on a Utility
     * @param u The Utility
     * @param b The Bank
     * @return A message
     */
    public String pay(Utility u, Bank b)
    {
        Player p = b.getPlayers().get(
                b.indexOf(
                u.getOwner()));
        int x;
        if(p.getNumUtilities() == 1)
        {
            x = 4 * (roll1 + roll2);
            p.acceptPayment(x);
            balance -= x;
        }
        else if(p.getNumUtilities() == 2)
        {
            x = 12 * (roll1 + roll2);
            p.acceptPayment(x);
            balance -= x;
            
            return name+" paid $" +u.currentRent()+ " to " + u.getOwner() +" for landing on " +u.getName()+ "\n";
        }
        else
        {
            throw new IllegalStateException(p.getName() + " does not own " + u.getName());
        }
        
        return name + "paid $" + x + " to " + u.getOwner()+"\n";
    }
    
    /**
     * Pays dues on a Property
     * @param p The Property
     * @param b The Bank
     * @return A message
     */
    public String pay(Property p, Bank b)
    {
        if(p.getOwner().equalsIgnoreCase(name))
        {
            //Your property, no rent paid
            return p.getName() + " belongs to " + p.getOwner() + ", therefore no rent is due\n";
        }
        else if(!p.isMortgaged())
        {
            balance -= p.currentRent();
            b.getPlayers().get(
                    b.indexOf(
                    p.getOwner())).
                    acceptPayment(
                    p.currentRent());
            
            return name +" paid $" +p.currentRent()+ " to " + p.getOwner()+" for landing on " +p.getName()+"\n";
        }
        //Mortgaged, no Payment. GG
        return p.getName() + " is mortgaged, therefore no rent is due\n";
    }
    
    /**
     * Gets their current roll on Doubles
     * @return 
     */
    public int getNumDoubles()
    {
        return doubleCount;
    }
    
    /**
     * Takes in a payment
     * @param payment the payment to be taken
     */
    public void acceptPayment(int payment)
    {
        balance += payment;
    }
    
    /**
     * Gets the positoin of the Piece
     * @return Their position
     */
    public int getPiecePosition()
    {
        return piece.getPosition();
    }
    
    /**
     * Simulates the rolling dice
     */
    public void roll()
    {
        roll1 =  random.nextInt(6) + 1;
        roll2 = random.nextInt(6) + 1;
        
        if(roll1 == roll2)
        {
            doubles = true;
            doubleCount++;
        }
        else
        {
            doubleCount = 0;
        }
        
        piece.move(roll1 + roll2);
        
    }
    
    /**
     * Gets the list of Properties owned by the Player
     * @return the list
     */
    public ArrayList<Property> getProperties()
    {
        return properties;
    }
    
    /**
     * Gets the names of the Properties in a String[], useful for JComboBoxes
     * @return A String[]
     */
    public String[] getPropertyNames()
    {
        String[] p = new String[properties.size()];
        
        int i = 0;
        for(Property pr : properties)
        {
            p[i] = pr.getName();
            i++;
        }
        
        if(p.length == 0)
        {
            return new String[]{""};
        }

        return p;
    }
    
    /**
     * Gets the first roll
     * @return Roll 1
     */
    public int getRoll1()
    {
        return roll1;
    }
    
    /**
     * Gets roll 2
     * @return Roll 2
     */
    public int getRoll2()
    {
        return roll2;
    }
    
    /**
     * Gets their balance
     * @return Balance
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * Buys a Property
     * @param p The Property
     * @param b The Bank
     * @return A message
     */
    public String buy(Property p, Bank b)
    {
        if(!p.isOwned() && balance - p.getPrice() >= 0)
        {
            balance -= p.getPrice();
            properties.add(p);
            b.remove(p);
            
            if(p instanceof RailRoad)
            {
                numRailroadsOwned++;
            }
            else if(p instanceof Utility)
            {
                numUtilitiesOwned++;
            }
            p.setOwner(name);
            return name + " successfully bought "+p.getName()+"\n";
            
            
            
        }
        
        return p.getName() + " is either owned, "
                + "or you have insufficient funds\n";
    }
    
    /**
     * Mortgages a Property
     * @param p The Property
     * @return A message
     */
    public String mortgage(Property p)
    {
        //Does this player own it?
        if(properties.contains(p))
        {
            if(properties.get(properties.indexOf(p)).isMortgaged())
            {
                return "This property is already mortgaged."
                        + "You can't mortgage a Property twice.\n";
            }
            else
            {
                properties.get(properties.indexOf(p)).mortgage();
                balance += p.getMortgagedPrice();
                
                return "You successfully mortgaged "+ p.getName() +" for  "
                        + p.getMortgagedPrice()+"\n";
            }
        }
        
        return "You don't own "+ p.getName() + ", therefore you can't "
                + "mortgage it\n";
        
    }
    
    /**
     * Sets bankrupt to true
     */
    public void bankrupt()
    {
        bankrupt = true;
    }
    
    /**
     * Unmortgtges a Property
     * @param p The Property
     * @return A messge
     */
    public String unMortgage(Property p)
    {
        if(properties.contains(p))
        {
            if(balance - p.getMortgagedPrice() <= 0)
            {
                return "You don't have enough money to do this\n";
            }
            
            properties.get(properties.indexOf(p)).unMortgage();
            balance -= p.getMortgagedPrice() /* * 1.1 10 percent interest*/;
            
            return "You successfully unmortgaged "+p.getName()+ " for "+
                    p.getMortgagedPrice() + "\n" /* * 1.1 10 percent interest*/;
        }
        
        return "You don't own "+ p.getName() + ", therefore you can't "
                + "mortgage it\n";
    }

    @Override
    /**
     * Yay compareTo()!
     */
    public int compareTo(Player p) 
    {
        return name.compareTo(p.name);
    }
}
