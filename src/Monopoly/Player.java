package Monopoly;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jordan
 */
public class Player implements Comparable<Player>
{
    private String name;
    private int balance, roll1, roll2, numRailroadsOwned, numUtilitiesOwned;;
    private Random random;
    private Piece piece;
    private boolean inJail, doubles, triples, bankrupt; 
    
    private ArrayList<Property> properties;
    
    public Player(String newName, Piece newPiece)
    {
        piece = newPiece;
        name = newName;
        roll1 = -1;
        roll2 = -1;
        balance = 1500;
        properties = new ArrayList<>();
        inJail = false;
        doubles = false;
        triples = false;
        bankrupt = false;
        numRailroadsOwned = 0;
        numUtilitiesOwned = 0;
    }
    
    public boolean isBankrupt()
    {
        return balance < 0;
    }
    public String getName()
    {
        return name;
    }
    
    public int getNumUtilities()
    {
        return numUtilitiesOwned;
    }
    public int getNumRailRoads()
    {
        return numRailroadsOwned;
    }
    public void landOn(Space s)
    {
        //If it's a property
        if(s instanceof Property)
        {
            //If you own it, nothing happens
            if(properties.contains((Property)s))
            {
                
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
                        //TODO: Ask if they want to buy
                        buy(u);
                    }
                    else
                    {
                        pay(u);
                    }
                }
                //RailRoads are special
                else if(s instanceof RailRoad)
                {
                    RailRoad r = (RailRoad)s;
                    if(!r.isOwned())
                    {
                        //TODO: Ask if they want to buy
                        buy(r);
                    }
                    else
                    {
                        pay(r);
                    }
                }
                else
                {
                    Property p = (Property)s;
                    //It's just a straight up property
                    
                    if(!p.isOwned())
                    {
                        //TODO: Ask if they want to buy
                        buy(p);
                    }
                    else
                    {
                        pay(p);
                    }
                }
            }
        }
        else 
        {
            if(s.getName().equalsIgnoreCase("Income Tax"))
            {
                int total = balance;
                for(Property p : properties)
                {
                    total += p.getPrice();
                }
                
                if(total > 2000)
                {
                    balance -= 200;
                }
                else
                {
                    //Integer division on purpose
                    balance -= total / 10;
                }
            }
            else if(s.getName().equalsIgnoreCase("Go to Jail"))
            {
                inJail = true;
                //The board index for jail
                piece.moveTo(9);
            }
            else if(s.getName().equalsIgnoreCase("Chance"))
            {
                pay(Bank.drawChance());
            }
            else if(s.getName().equalsIgnoreCase("Community Chest"))
            {
                pay(Bank.drawCommunityChest());
            }
            else if(s.getName().equalsIgnoreCase("Free Parking"))
            {
                //Do Nothing
            }
            else
            {
                throw new UnknownError("This should never have been called");
            }
        }
    }
    
    public void pay(Card c)
    {
        balance += c.getReward();
    }
    public void pay(Space s)
    {
        balance += s.getReward();
    }
    private int RRPayout(int numRR)
    {
        return (int)(25 * Math.pow(2, numRR - 1));
    }
    public void pay(RailRoad r)
    {
        if(r.getOwner().equalsIgnoreCase(name))
        {
            //Your property, no rent paid
        }
        else if(!r.isMortgaged())
        {
            Player p = Board.players.get(
                Board.findPlayerIndex(
                r.getOwner()));
            
            if(p.numRailroadsOwned == 0)
            {
                throw new IllegalStateException(p.getName() + " does not own " + r.getName());
            }
            
            int x = RRPayout(p.numRailroadsOwned);
            balance -= x;
            p.acceptPayment(x);
        }
        //Mortgaged, no Payment. GG
    }
    public void pay(Utility u)
    {
        Player p = Board.players.get(
                Board.findPlayerIndex(
                u.getOwner()));
        
        if(p.getNumUtilities() == 1)
        {
            int x = 4 * (roll1 + roll2);
            p.acceptPayment(x);
            balance -= x;
        }
        else if(p.getNumUtilities() == 2)
        {
            int x = 12 * (roll1 + roll2);
            p.acceptPayment(x);
            balance -= x;
        }
        else
        {
            throw new IllegalStateException(p.getName() + " does not own " + u.getName());
        }
    }
    public void pay(Property p)
    {
        if(p.getOwner().equalsIgnoreCase(name))
        {
            //Your property, no rent paid
        }
        else if(!p.isMortgaged())
        {
            balance -= p.currentRent();
            Board.players.get(
                    Board.findPlayerIndex(
                    p.getOwner())).
                    acceptPayment(
                    p.currentRent());
        }
        //Mortgaged, no Payment. GG
    }
    
    public void acceptPayment(int payment)
    {
        balance += payment;
    }
    public int getPiecePosition()
    {
        return piece.getPosition();
    }
    public void roll()
    {
        roll1 =  random.nextInt(6) + 1;
        roll2 = random.nextInt(6) + 1;
        
        if(roll1 == roll2 && !doubles && !triples)
        {
            doubles = true;
        }
        if (roll1 == roll2 && doubles && !triples)
        {
            triples = true;
        }
        
        piece.move(roll1 + roll2);
        
    }
    
    public int getRoll1()
    {
        return roll1;
    }
    
    public int getRoll2()
    {
        return roll2;
    }
    public int getBalance()
    {
        return balance;
    }
    
    public String buy(Property p)
    {
        if(!p.isOwned() && balance - p.getPrice() >= 0)
        {
            balance -= p.getPrice();
            properties.add(p);
            Bank.remove(p);
            
            if(p instanceof RailRoad)
            {
                numRailroadsOwned++;
            }
            else if(p instanceof Utility)
            {
                numUtilitiesOwned++;
            }
            return name + " successfully bought "+p.getName();
            
            
            //Have bank remove the property
        }
        
        return p.getName() + " is either owned, "
                + "or you have insufficient funds";
    }
    
    public String mortgage(Property p)
    {
        //Does this player own it?
        if(properties.contains(p))
        {
            if(properties.get(properties.indexOf(p)).isMortgaged())
            {
                return "This property is already mortgaged."
                        + "\nYou can't mortgage a Property twice.";
            }
            else
            {
                properties.get(properties.indexOf(p)).mortgage();
                balance += p.getMortgagedPrice();
                
                return "You successfully mortgaged "+ p.getName() +" for  "
                        + p.getMortgagedPrice();
            }
        }
        
        return "You don't own "+ p.getName() + ", therefore you can't "
                + "mortgage it";
        
    }
    
    /**
     * Jordan Giacone 
     * @param other 
     */
    public void tradeWith(Player other)
    {
        
    }
    
    public void bankrupt()
    {
        bankrupt = true;
    }
    
    public String unMortgage(Property p)
    {
        if(properties.contains(p))
        {
            if(balance - p.getMortgagedPrice() <= 0)
            {
                return "You don't have enough money to do this";
            }
            
            properties.get(properties.indexOf(p)).unMortgage();
            balance -= p.getMortgagedPrice() /* * 1.1 10 percent interest*/;
            
            return "You successfully unmortgaged "+p.getName()+ " for "+
                    p.getMortgagedPrice() /* * 1.1 10 percent interest*/;
        }
        
        return "You don't own "+ p.getName() + ", therefore you can't "
                + "mortgage it";
    }

    @Override
    public int compareTo(Player p) 
    {
        return name.compareTo(p.name);
    }
}
