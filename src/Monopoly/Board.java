package Monopoly;

import java.awt.geom.Point2D;

/**
 *
 * @author Jordan
 */
public class Board 
{
    public Space[] board;
    
    public Board()
    {
        board = new Space[40];
        initSpaces();
    }
    
    /**
     * Gets the board
     * @return The Board
     */
    public Space[] getBoard()
    {
        return board;
    }
    
    /**
     * Another indexOf knockoff
     * @param s The Space to be found
     * @return Index at which it resides
     */
    public int indexOf(Space s)
    {
        for(int i = 0; i < board.length; i++)
        {
            if(board[i].getName().equals(s.getName()))
            {
                return i;
            }
        }
        
        return -1;
    }
    private void initSpaces()
    {
        int i = 50, x = 483, y = 494;
        String s = "h", group = "Purple";
        board[0] = new Space("Go", new Point2D.Double(526,520), 0);
        board[1] = new Property(
                "Mediterranean Avenue", 60, 2, 10, 30, 90, 160, 250, new Point2D.Double(458,520), i, s, new Point2D.Double(x, y), group);
        board[2] = new Space("Community Chest", new Point2D.Double(412,520), 0);
        x -= 94;
        board[3] = new Property(
                "Baltic Avenue", 60, 4, 20, 60, 180, 320, 450, new Point2D.Double(366,520), i, s, new Point2D.Double(x, y), group);
        board[4] = new Space("Income Tax", new Point2D.Double(320,520), 0);
        board[5] = new RailRoad(
                "Reading Railroad", 200, new Point2D.Double(274,520), "Railroad");
        x -= (94 + 46);
        group = "Light Blue";
        board[6] = new Property(
                "Oriental Avenue", 100, 6, 30, 90, 270, 400, 550, new Point2D.Double(226,520), i, s, new Point2D.Double(x, y), group);
        board[7] = new Space("Chance", new Point2D.Double(179,520), 0);
        x -= 94;
        board[8] = new Property(
                "Vermont Avenue", 100, 6, 30, 90, 270, 400, 550, new Point2D.Double(133,520), i, s, new Point2D.Double(x, y), group);
        x -= 47;
        board[9] = new Property(
                "Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600, new Point2D.Double(87,520), i, s, new Point2D.Double(x, y), group);
        board[10] = new Space("Jail", new Point2D.Double(25,520), 0);
        i += 50;
        s = "v";
        x = 62;
        y -= 12;//Get the corner back on the space
        group = "Pink";
        board[11] = new Property(
                "St. Charles Place", 140, 10, 50, 150, 450, 635, 750, new Point2D.Double(25,455), i, s, new Point2D.Double(x, y), group);
        board[12] =  new Utility(
                "Electric Company", 150, new Point2D.Double(25,410), "Utility");
        y -= 94;
        board[13] = new Property(
                "States Avenue", 140, 10, 50, 150, 450, 635, 750, new Point2D.Double(25,365), i, s, new Point2D.Double(x, y), group);
        y -= 47;
        board[14] = new Property(
                "Virginia Avenue", 160, 12, 60, 180, 500, 700, 900, new Point2D.Double(25,317), i, s, new Point2D.Double(x, y), group);
        board[15] = new RailRoad(
                "Pennsylvania Railroad", 200, new Point2D.Double(25,270), "Railroad");
        y -= 94;
        group = "Orange";
        board[16] = new Property(
                "St. James Place", 180, 14, 70, 200, 250, 750, 950, new Point2D.Double(25,220), i, s, new Point2D.Double(x, y), group);
        board[17] = new Space("Community Chest", new Point2D.Double(25,172), 0);
        y -= 93;
        board[18] = new Property(
                "Tennessee Avenue", 180, 14, 70, 200, 250, 750, 950, new Point2D.Double(25,127), i, s, new Point2D.Double(x, y), group);
        y -= 47;
        board[19] = new Property(
                "New York Avenue", 200, 16, 80, 220, 600, 800, 1000, new Point2D.Double(25,82), i, s, new Point2D.Double(x, y), group);
        board[20] = new Space("Free Parking", new Point2D.Double(25,20), 0);
        i += 50;
        s = "h";
        x = 73;
        y = 62;
        group = "Red";
        board[21] = new Property(
                "Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050, new Point2D.Double(87,20), i, s, new Point2D.Double(x, y), group);
        board[22] = new Space("Chance", new Point2D.Double(133,20), 0);
        x += 94;
        board[23] = new Property(
                "Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050, new Point2D.Double(179,20), i, s, new Point2D.Double(x, y), group);
        x += 47;
        board[24] = new Property(
                "Illinois Avenue", 240, 20, 100, 300, 750, 925, 1100, new Point2D.Double(225,20), i, s, new Point2D.Double(x, y), group);
        board[25] = new RailRoad(
                "B & O Railroad", 200, new Point2D.Double(271,20), "Railroad");
        x += 94;
        group = "Yellow";
        board[26] = new Property(
                "Atlantic Avenue", 260, 22, 110, 330, 800, 975, 1150, new Point2D.Double(317,20), i, s, new Point2D.Double(x, y), group);
        x += 47;
        board[27] = new Property(
                "Ventnor Avenue", 260, 22, 110, 330, 800, 975, 1150, new Point2D.Double(363,20), i, s, new Point2D.Double(x, y), group);
        board[28] = new Utility(
                "Water Works", 150, new Point2D.Double(409,20), "Utility");
        x += 94;
        board[29] = new Property(
                "Marvin Gardens", 280, 24, 120, 360, 850, 1025, 1200, new Point2D.Double(455,20), i, s, new Point2D.Double(x, y), group);
        x += 45;
        y = 73;
        board[30] = new Space("Go to Jail", new Point2D.Double(526,20), 0);
        i += 50;
        s = "v";
        group = "Green";
        board[31] = new Property(
                "Pacific Avenue", 300, 26, 130, 390, 900, 1100, 1275, new Point2D.Double(526,80), i, s, new Point2D.Double(x, y), group);
        y += 47;
        board[32] = new Property(
                "North Carolina Avenue", 300, 26, 130, 390, 900, 1100, 1275, new Point2D.Double(526, 130), i, s, new Point2D.Double(x, y), group);
        board[33] = new Space("Community Chest", new Point2D.Double(526,175), 0);
        y += 94;
        board[34] = new Property(
                "Pennsylvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400, new Point2D.Double(526,220), i, s, new Point2D.Double(x, y), group);
        board[35] = new RailRoad(
                "Short Line Railroad", 200, new Point2D.Double(526,265), "Railroad");
        board[36] = new Space("Chance", new Point2D.Double(526,315), 0);
        y += 47 + 93;
        group = "Dark Blue";
        board[37] = new Property(
                "Park Place", 350, 35, 175, 500, 1100, 1300, 1500, new Point2D.Double(526,360), i, s, new Point2D.Double(x, y), group);
        board[38] = new Space("Luxury Tax", new Point2D.Double(526,408), -75);
        y += 94;
        board[39] = new Property(
                "Boardwalk", 400, 50, 200, 600, 1400, 1700, 2000, new Point2D.Double(526,455), i, s, new Point2D.Double(x, y), group);
        
    }
}
