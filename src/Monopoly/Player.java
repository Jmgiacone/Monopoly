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
    private int balance, roll1, roll2;
    private Random random;
    private Piece piece;
    private boolean inJail, doubles, triples, bankrupt;
    private int numRailroadsOwned;
    
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
    }
    
    public boolean isBankrupt()
    {
        return bankrupt;
    }
    public String getName()
    {
        return name;
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
            if(s instanceof Utility)
            {
                Utility u = (Utility)s;
                if(!u.isOwned())
                {
                    //Ask if they want to buy
                    buy(u);
                }
                else
                {
                   pay(u);
                }
            }
            else if(s instanceof RailRoad)
            {
                RailRoad r = (RailRoad)s;
                if(!r.isOwned())
                {
                    //Ask if they want to buy
                    buy(r);
                }
                else
                {
                    pay(r);
                }
            }
            else
            {
                Property p;
                //It's just a straight up property
                p = (Property)s;

                if(!p.isOwned())
                {
                    //Ask if they want to buy
                    buy(p);
                }
                else
                {
                    pay(p);
                }
            }
        }
        else 
        {
            if(s.getName().equalsIgnoreCase("Income Tax"))
            {
                int total = balance;
                for(int i = 0; i < properties.size(); i++)
                {
                    total += properties.get(i).getPrice();
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
            }
            else if(s.getName().equalsIgnoreCase("Chance"))
            {
                pay(Bank.drawnChance());
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
    public void pay(RailRoad r)
    {
        if(r.getOwner().equalsIgnoreCase(name))
        {
            //Your property, no rent paid
        }
        else if(!r.isMortgaged())
        {
            
        }
        //Mortgaged, no Payment. GG
        numRailroadsOwned++;
    }
    public void pay(Utility u)
    {
        
    }
    public void pay(Property p)
    {
//        if(p.getOwner().equalsIgnoreCase(name))
//        {
//            //Your property, no rent paid
//        }
//        else if(!p.isMortgaged())
//        {
//            balance -= p.currentRent();
//            Board.players.get(
//                    Board.findPlayerIndex(
//                    p.getOwner())).
//                    acceptPayment(
//                    p.currentRent());
//        }
//        //Mortgaged, no Payment. GG
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
        
//        if(roll1 == roll2 && !doubles)
//        {
//            doubles = true;
//        }
//        if (roll1 == roll2 && doubles)
//        {
//            triples = true;
//        }
        
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
            return "You successfully bought "+p.getName();
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
                balance += p.getPrice() / 2;
                
                return "You successfully mortgaged "+ p.getName() +" for  "
                        + p.getPrice() / 2;
            }
        }
        
        return "You don't own "+ p.getName() + ", therefore you can't "
                + "mortgage it";
        
    }
    
    /**
     * jordan
     * @param other 
     */
    public void tradeWith(Player other)
    {
        
    }
    
    public void bankrupt()
    {
        Board.bankrupt(this);
    }
    
    public String unMortgage(Property p)
    {
        if(properties.contains(p))
        {
            if(balance - ((p.getPrice() / 2) + ((p.getPrice() / 2) /** .1*/)) <= 0)
            {
                return "You don't have enough money to do this";
            }
            
            properties.get(properties.indexOf(p)).unMortgage();
            balance -= ((p.getPrice() / 2) + ((p.getPrice() / 2) * .1));
            
            return "You successfully unmortgaged "+p.getName()+ " for "+
                    ((p.getPrice() / 2) + ((p.getPrice() / 2) * .1));
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
