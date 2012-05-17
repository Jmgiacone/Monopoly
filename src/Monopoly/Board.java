package Monopoly;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jordan
 */
public class Board 
{
    public static ArrayList<Player> players; 
    public static ArrayList<Player> bankrupt;
    private ArrayList <Piece> pieces;
    public static Space[] board;
    private Random r;
    
    public Board()
    {
        r = new Random();
        bankrupt = new ArrayList<>();
        players = new ArrayList<>();
        pieces = new ArrayList<>();
        board = new Space[40];
        initSpaces();
        initPieces();
    }
    
    public JPanel getBoard()
    {
        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c;
        
        //Start w/ bottom right space(Go)
        int x = 10, y = 10;
        for(int i = 39; i >= 0; i--)
        {
            c = new GridBagConstraints();
            //Need to switch x and y to make it work
            c.gridx = x;
            c.gridy = y;
            
            //No padding between spaces
            c.ipadx = 0;
            c.ipady = 0;
        
        
//            if((i + 1) % 10 == 0)
//            {
//                //Is a corner
//                c.gridheight = TALLER_HEIGHT;
//                c.gridwidth = TALLER_WIDTH;
//            }
//            else if((i <= 38 && i >= 30) || (i <= 18 && i >= 10))
//            {
//                //Taller height than width
//                c.gridheight = TALLER_HEIGHT;
//                c.gridwidth = SHORTER_WIDTH;
//            }
//            else if((i <= 28 && i >= 20) || (i <= 8 && i >= 0))
//            {
//                //Longer width than height
//                c.gridheight = SHORTER_HEIGHT; 
//                c.gridwidth = TALLER_WIDTH;
//            }
            
            //board[y][x] = i;
            String s = "";
            if((i + 1) % 10 == 0)
            {
                s = "images/Individual Properties/Free Parking.png";
            }
            else if((i <= 38 && i >= 30) || (i <= 18 && i >= 10))
            {
                s = "images/Individual Properties/Kentucky Avenue.png";
            }
            else if((i <= 28 && i >= 20) || (i <= 8 && i >= 0))
            {
                s = "images/Individual Properties/New York Avenue.png";
            }
            else
            {
                throw new IllegalStateException();
            }
            
            p.add(new JLabel(new ImageIcon(s)), c);
            //p.add(new JLabel(board[i].getImage()), c);
            if(y == 10 && x > 0)
            {
                x--;
            }
            else if(x == 0 && y > 0)
            {
                y--;
            }
            else if(y == 0 && x < 10)
            {
                x++;
            }
            else if(x == 10 && y < 10)
            {
                y++;
            }
            c = null;
        }
        
        c = new GridBagConstraints();
        c.gridx = 1; 
        c.gridy = 1;
        c.gridheight = 9;
        c.gridwidth = 9;
        p.add(new JLabel(
                new ImageIcon("images/Individual Properties/mid65.png")), c);
        return p;
    }
    public boolean isWinner()
    {
        return players.size() != 1 && bankrupt.size() != pieces.size();
    }
    
    public int chooseFirst()
    {
        return r.nextInt(players.size()) + 1;
    }
    public void start()
    {
        while(!isWinner())
        {
            for(Player p : players)
            {
                p.roll();
                p.landOn(board[p.getPiecePosition()]);
                
                if(p.isBankrupt())
                {
                    bankrupt(p);
                }
            }
        }
    }
    
    private void move(Player p)
    {
        p.roll();
        
        p.landOn(board[p.getPiecePosition()]);
        
        if(p.getBalance() < 0)
        {
            bankrupt(p);
        }
    }
    
    private void bankrupt(Player p)
    {
        bankrupt.add(players.remove(players.indexOf(p)));
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
        Player p = new Player(n, null);
        
        for(int i = 0; i < players.size(); i++)
        {
            if(p.compareTo(players.get(i)) == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    private void initSpaces()
    {
        board[39] = new Space("Go", new Point2D.Double(795,795), Bank.PASS_GO_AMOUNT);
        board[38] = new Property(
                "Mediterranean Avenue", 60, 2, 10, 30, 90, 160, 250, new Point2D.Double(705,795));
        board[37] = new Space("Community Chest", new Point2D.Double(635,795), 0);
        board[36] = new Property(
                "Baltic Avenue", 60, 4, 20, 60, 180, 320, 450, new Point2D.Double(565,795));
        board[35] = new Space("Income Tax", new Point2D.Double(495,795), 0);
        board[34] = new RailRoad(
                "Reading Railroad", 200, new Point2D.Double(425,795));
        board[33] = new Property(
                "Oriental Avenue", 100, 6, 30, 90, 270, 400, 550, new Point2D.Double(355,795));
        board[32] = new RailRoad("Reading Railroad", 200, new Point2D.Double(285,795));
        board[31] = new Property(
                "Vermont Avenue", 100, 6, 30, 90, 270, 400, 550, new Point2D.Double(215,795));
        board[30] = new Property(
                "Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600, new Point2D.Double(145,795));
        board[29] = new Space("Jail", new Point2D.Double(55,795), 0);
        board[28] = new Property(
                "St. Charles Place", 140, 10, 50, 150, 450, 635, 750, new Point2D.Double(55,705));
        board[27] =  new Utility(
                "Electric Company", 150, new Point2D.Double(55,635));
        board[26] = new Property(
                "States Avenue", 140, 10, 50, 150, 450, 635, 750, new Point2D.Double(55,565));
        board[25] = new Property(
                "Virginia Avenue", 160, 12, 60, 180, 500, 700, 900, new Point2D.Double(55,495));
        board[24] = new RailRoad(
                "Pennyslyvania Railroad", 200, new Point2D.Double(55,425));
        board[23] = new Property(
                "St. James Place", 180, 14, 70, 200, 550, 750, 950, new Point2D.Double(55,355));
        board[22] = new Space("Community Chest", new Point2D.Double(55,285), 0);
        board[21] = new Property(
                "Tennessee Avenue", 180, 14, 70, 200, 550, 750, 950, new Point2D.Double(55,215));
        board[20] = new Property(
                "New York Avenue", 200, 16, 80, 220, 600, 800, 1000, new Point2D.Double(55,145));
        board[19] = new Space("Free Parking", new Point2D.Double(55,55), 0);
        board[18] = new Property(
                "Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050, new Point2D.Double(145,55));
        board[17] = new Space("Chance", new Point2D.Double(215,55), 0);
        board[16] = new Property(
                "Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050, new Point2D.Double(285,55));
        board[15] = new Property(
                "Illinois Avenue", 240, 20, 100, 300, 750, 925, 1100, new Point2D.Double(355,55));
        board[14] = new RailRoad(
                "B & O Railroad", 200, new Point2D.Double(425,55));
        board[13] = new Property(
                "Atlantic Avenue", 260, 22, 110, 330, 800, 975, 1150, new Point2D.Double(495,55));
        board[12] = new Property(
                "Ventnor Avenue", 260, 22, 110, 330, 800, 975, 1150, new Point2D.Double(565,55));
        board[11] = new Utility(
                "Water Works", 150, new Point2D.Double(635,55));
        board[10] = new Property(
                "Marvin Gardens", 280, 24, 120, 360, 850, 1025, 1200, new Point2D.Double(705,55));
        board[9] = new Space("Go to Jail", new Point2D.Double(795,55), 0);
        board[8] = new Property(
                "Pacific Avenue", 300, 26, 130, 390, 900, 1100, 1275, new Point2D.Double(795,145));
        board[7] = new Property(
                "North Carolina Avenue", 300, 26, 130, 390, 900, 1100, 1275, new Point2D.Double(795, 215));
        board[6] = new Space("Community Chest", new Point2D.Double(795,285), 0);
        board[5] = new Property(
                "Pennyslyvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400, new Point2D.Double(795,355));
        board[4] = new RailRoad(
                "Short Line Railroad", 200, new Point2D.Double(795,425));
        board[3] = new Space("Chance", new Point2D.Double(795,495), 0);
        board[2] = new Property(
                "Park Place", 350, 35, 175, 500, 1100, 1300, 1500, new Point2D.Double(795,565));
        board[1] = new Space("Luxury Tax", new Point2D.Double(795,635), -75);
        board[0] = new Property(
                "Boardwalk", 400, 50, 200, 600, 1400, 1700, 2000, new Point2D.Double(795,705));
        
         
         
         
         
        
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
