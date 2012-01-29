/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jordan
 */
public class Player 
{
    private String name;
    private int balance, roll1, roll2;
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
        properties = new ArrayList<Property>();
        inJail = false;
        doubles = false;
        triples = false;
        bankrupt = false;
    }
    
    public boolean isBankrupt()
    {
        return bankrupt;
    }
    public String getName()
    {
        return name;
    }
    
    public void landOn(Space s)
    {
        //If it's a property
        if(s.isProperty())
        {
            //now castable as a property
            Property p = (Property)s;
            if(((Property)s).isUtility())
            {
                Utility u = (Utility)Bank.getProperty((Property)s);
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
            else if(((Property)s).isRailroad())
            {
                RailRoad r = (RailRoad)Bank.getProperty((Property)s);
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
                //It's just a straight up property
                p = Bank.getProperty((Property)s);

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
        else if(s.isCard())
        {
            Card c = (Card)s;
            JOptionPane.showMessageDialog(null, c);
            balance += c.getReward();
        }
        else 
        {
            
            if(s.getName().equalsIgnoreCase("Go"))
            {
                balance += Bank.LAND_ON_GO_AMOUNT;
            }
            else if(s.getName().equalsIgnoreCase("Luxury Tax"))
            {
                balance -= 75;
            }
            else if(s.getName().equalsIgnoreCase("Income Tax"))
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
            else if(s.getName().equalsIgnoreCase("Free Parking"))
            {
                //Nothing!
            }
            else if(s.getName().equalsIgnoreCase("Go to Jail"))
            {
                inJail = true;
            }
            else if(s.getName().equalsIgnoreCase("Chance"))
            {
                //draw a card and add/subtract reward
            }
            else if(s.getName().equalsIgnoreCase("Community Chest"))
            {
                //same here
            }
            else 
            {
                
            }
        }
    }
    
    public void pay(Property p)
    {
        balance -= p.currentRent();
        Board.players.get(
                Board.findPlayerIndex(
                p.getOwner())).
                acceptPayment(
                p.currentRent());
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
        if(!p.isOwned() && balance - p.getPrice() > 0)
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
                return "This property is already mortgaged";
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
    
    public void tradeWith(Player other)
    {
        
    }
    
    public void bankrupt()
    {
        
    }
    
    public String unMortgage(Property p)
    {
        if(properties.contains(p))
        {
            if(balance - ((p.getPrice() / 2) + ((p.getPrice() / 2) * .1)) <= 0)
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
}
