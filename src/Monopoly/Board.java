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
public class Board 
{
    private Bank b;
    public static ArrayList<Player> players; 
    private ArrayList<Player >bankrupt;
    private ArrayList <Piece> pieces;
    private Space[] board;
    
    public Board()
    {
        bankrupt = new ArrayList<Player>();
        players = new ArrayList<Player>();
        pieces = new ArrayList<Piece>();
        board = new Space[40];
        initSpaces();
        initPieces();
    }
    
    public boolean isWinner()
    {
        if(players.size() != 1)
        {
            return false;
        }
        return true;
    }
    
    public int chooseFirst()
    {
        Random r = new Random();
        return r.nextInt(players.size()) + 1;
    }
    public void start()
    {
        try
        {
            b = new Bank(
                    Integer.parseInt(
                    JOptionPane.showInputDialog(
                    "How much money to recieve when you pass go?")));
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showInputDialog("That's not a number, try again");
            start();
        }
    }
    private void move(Player p)
    {
        p.roll();
        
        p.landOn(board[p.getPiecePosition()]);
        
        if(p.getBalance() < 0)
        {
            p.bankrupt();
            
            players.remove(p);
            bankrupt.add(p);
        }
    }
    
    private void initPieces()
    {
        pieces.add(new Piece("Cannon"));
        pieces.add(new Piece("Dog"));
        pieces.add(new Piece("BattleShip"));
        pieces.add(new Piece("Car"));
        pieces.add(new Piece("Iron"));
        pieces.add(new Piece("Top Hat"));
        pieces.add(new Piece("Thimble"));
        pieces.add(new Piece("Wheelbarrow"));
        pieces.add(new Piece("Shoe"));
        pieces.add(new Piece("Money Bag"));
        
    }
    
    public static int findPlayerIndex(String n)
    {
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getName().equalsIgnoreCase(n))
            {
                return i;
            }
        }
        return -1;
    }
    
    private void initSpaces()
    {
        board[0] = new Space("Go");
        board[1] = new Property(
                "Mediterranean Avenue", 60, 2, 10, 30, 90, 160, 250);
        board[2] = new Space("Community Chest");
        board[3] = new Property(
                "Baltic Avenue", 60, 4, 20, 60, 180, 320, 450);
        board[4] = new Space("Income Tax");
        board[5] = new RailRoad(
                "Reading Railroad", 200);
        board[6] = new Property(
                "Oriental Avenue", 100, 6, 30, 90, 270, 400, 550);
        board[7] = new RailRoad("Reading Railroad", 200);
        board[8] = new Property(
                "Vermont Avenue", 100, 6, 30, 90, 270, 400, 550);
        board[9] = new Property(
                "Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600);
        board[10] = new Space("Jail");
        board[11] = new Property(
                "St. Charles Place", 140, 10, 50, 150, 450, 635, 750);
        board[12] =  new Utility(
                "Electric Company", 150);
        board[13] = new Property(
                "States Avenue", 140, 10, 50, 150, 450, 635, 750);
        board[14] = new Property(
                "Virginia Avenue", 160, 12, 60, 180, 500, 700, 900);
        board[15] = new RailRoad(
                "Pennyslyvania Railroad", 200);
        board[16] = new Property(
                "St. James Place", 180, 14, 70, 200, 550, 750, 950);
        board[17] = new Space("Community Chest");
        board[18] = new Property(
                "Tennessee Avenue", 180, 14, 70, 200, 550, 750, 950);
        board[19] = new Property(
                "New York Avenue", 200, 16, 80, 220, 600, 800, 1000);
        board[20] = new Space("Free Parking");
        board[21] = new Property(
                "Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050);
        board[22] = new Space("Chance");
        board[23] = new Property(
                "Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050);
        board[24] = new Property(
                "Illinois Avenue", 240, 20, 100, 300, 750, 925, 1100);
        board[25] = new RailRoad(
                "B & O Railroad", 200);
        board[26] = new Property(
                "Atlantic Avenue", 260, 22, 110, 330, 800, 975, 1150);
        board[27] = new Property(
                "Ventnor Avenue", 260, 22, 110, 330, 800, 975, 1150);
        board[28] = new Utility(
                "Water Works", 150);
        board[29] = new Property(
                "Marvin Gardens", 280, 24, 120, 360, 850, 1025, 1200);
        board[30] = new Space("Go to Jail");
        board[31] = new Property(
                "Pacific Avenue", 300, 26, 130, 390, 900, 1100, 1275);
        board[32] = new Property(
                "North Carolina Avenue", 300, 26, 130, 390, 900, 1100, 1275);
        board[33] = new Space("Community Chest");
        board[34] = new Property(
                "Pennyslyvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400);
        board[35] = new RailRoad(
                "Short Line Railroad", 200);
        board[36] = new Space("Chance");
        board[37] = new Property(
                "Park Place", 350, 35, 175, 500, 1100, 1300, 1500);
        board[38] = new Space("Luxury Tax");
        board[39] = new Property(
                "Boardwalk", 400, 50, 200, 600, 1400, 1700, 2000);
        
         
         
         
         
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
