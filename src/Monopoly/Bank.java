package Monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jordan
 */
public class Bank 
{
    private InitGameDialog playerFrame;
    private boolean tripDoubleJail;
    public int PASS_GO_AMOUNT, LAND_ON_GO_AMOUNT;
    private Board b;
    private int currentPlayer;
    private ArrayList<Property> properties;
    private ArrayList<Card> chance, communityChest;
    private ArrayList<Player> players, bankrupt;
    private ArrayList <Piece> pieces;
    private Random r;
    
    
    //Bank never runs out of money, no need for a balance variable
    public Bank()
    {
        players = null;
        //Init the players
        playerFrame = new InitGameDialog(null, true);
        
        players = playerFrame.getPlayers();
        bankrupt = new ArrayList<>();
        tripDoubleJail = playerFrame.tripDoubles();
        r = new Random();
        b = new Board();
        pieces = new ArrayList<>();
        initPieces();
        PASS_GO_AMOUNT = playerFrame.getPassGoAmount();
        
        if(playerFrame.landOnGo())
        {
            LAND_ON_GO_AMOUNT = PASS_GO_AMOUNT * 2;
        }
        else
        {
            LAND_ON_GO_AMOUNT = PASS_GO_AMOUNT;
        }
        
        initCards();
        
        for(int i = 0; i < 5; i++)
        {
            shuffleGiftCards();
        }
    }
    
    /**
     * Gets a String[] of every player in the game. Useful when adding them to a JComboBox
     * @return a Stirng[] containing every Players name
     */
    public String[] getPlayerNames()
    {
        String[] names = new String[players.size()];
        
        int i = 0;
        for(Player p : players)
        {
            names[i] = p.getName();
            i++;
        }
        
        return names;
    }
    
    /**
     * Returns if the button for going to jail after 3 doubles was checked
     * @return true or false
     */
    public boolean tripDoubles()
    {
        return tripDoubleJail;
    }
    
    /**
     * Gets the current Player from the Bank and gives it to the GUI
     * @return Current Player
     */
    public Player getCurrentPlayer()
    {
        return players.get(currentPlayer);
    }
    
    /**
     * Chooses the Player that will start off the game
     * @return the Player that will start off the game
     */
    public Player chooseFirst()
    {
        Player p = players.get(new Random().nextInt(players.size()));
        currentPlayer = players.indexOf(p);
        return p;
    }
    
    /**
     * Returns the ArrayList<Player> that holds all of the players
     * @return all the Players in the Bank
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    /**
     * A spinoff of ArrayList.indexOf, this one finds it based on a String
     * @param s The name to be searched for
     * @return The index of the Player with that name
     */
    public int indexOf(String s)
    {
        int i = 0;
        for(Player p : players)
        {
            if(p.getName().equalsIgnoreCase(s))
            {
                return i;
            }
            i++;
        }
        
        return -1;
    }
    
    /**
     * Iterates the Player and gives it to the GUI
     * @return The next Player up
     */
    public Player switchPlayers()
    {
        currentPlayer++;
        if(currentPlayer >= players.size())
        {
            currentPlayer -= players.size();
        }
        
        return players.get(currentPlayer);
    }
    
    /**
     * Makes a Player Bankrupt
     * @param p The Player to be Bankrupt
     * @return A String confirming the bankrupcy
     */
    public String bankrupt(Player p)
    {
        for(Property pr : p.getProperties())
        {
            pr.setOwner("");
        }
        bankrupt.add(players.remove(players.indexOf(p)));
        return p.getName() + " has become bankrupt!";
    }
    private void initPieces()
    {
        pieces = new ArrayList<>();
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
    /**
     * Removes a Property from the Banks List
     * @param p The Property to be removed
     */
    public void remove(Property p)
    {
        properties.remove(p);
    }      
    
    /**
     * Returns the Property with given name
     * @param s Name of the Property to be found
     * @return The found Property
     */
    public Property getProperty(String s)
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
    
    /**
     * Draws a Chance Card
     * @return A Chance Card
     */
    public Card drawChance()
    {
        Card c = chance.get(0);
        chance.add(chance.remove(0));
        return c;
    }
    
    /**
     * Draws a Community Chest Card
     * @return A community Chest Card
     */
    public Card drawCommunityChest()
    {
        Card c = communityChest.get(0);
        communityChest.add(communityChest.remove(0));
        return c;
    }
    private void shuffleGiftCards()
    {
        chance = shuffle(chance);
        communityChest = shuffle(communityChest);
    }
    private ArrayList<Card> shuffle(ArrayList<Card> deck)
    {
        List<Card> h1 = deck.subList(0, deck.size() / 2),
                 //split the deck into 2 halves
                 h2 = deck.subList(deck.size() / 2, 
                 deck.size()), temp = new ArrayList<>();
         
         int num = 0, index = 0;
         
         for(int count = 0; count < h1.size();)
         {
             if(count > h1.size() - 4)
             {
                 num = h1.size() - count;
             }
             else
             {
                 //Generates an arbitrary number of cards to take off
                 //the two halves
                num = r.nextInt(3) + 1;
             }
             
             index += num - 1;
             for(int j = num; j > 0; j--)
             {
                 temp.add(h1.get(index));
                 temp.add(h2.get(index));
                 
                 if(j == 1)
                 {
                     //Do nothing
                 }
                 else
                 {
                    index--;
                 }
                 count++;
             }
             index = count;
         }
         return (ArrayList<Card>)temp;
    }
    private void initGiftCards()
    {
        //Community Chest Cards
        communityChest.add(new Card("Community Chest", "Advance to Go(Collect $200))", 0, 0, false));
        communityChest.add(new Card("Community Chest", "Bank Error in your favor - collect $200", 200, -1, false));
        communityChest.add(new Card("Community Chest", "Doctors's fees - Pay $50", -50, -1, false));
        communityChest.add(new Card("Community Chest", "Get Out of Jail Free", 0, -1, true));
        communityChest.add(new Card("Community Chest", "Go Directly to Jail - Do not Pass Go, do not collect $200", 0, 10, false));
        //communityChest.add(new Card("Community Chest", "Grand opening of the Opera, collect $50 from each player", -50, -1, true));
        communityChest.add(new Card("Community Chest", "Income Tax Refund - Collect $20", 20, -1, false));
        communityChest.add(new Card("Community Chest", "Life Insurance Matures, collect $100", 100, -1, false));
        communityChest.add(new Card("Community Chest", "Pay Hospital Fee of $100", -100, -1, false));
        communityChest.add(new Card("Community Chest", "Pay School Fee of $50", -50, -1, false));
        //communityChest.add(new Card("Community Chest", "You are assessed for Street Repairs - pay $40 per house, $115 per Hotel", -40, -1, true));
        communityChest.add(new Card("Community Chest", "You have won second prize in a Beauty contest, collect $10", 10, -1, false));
        communityChest.add(new Card("Community Chest", "You inherit $100", 100, -1, false));
        communityChest.add(new Card("Community Chest", "From sale of Stock you get $50", 50, -1, false));
        communityChest.add(new Card("Community Chest", "XMAS Fund Matures, collect $100", 100, -1, false));
        
        //Chance cards
        chance.add(new Card("Chance", "Advance to Go(Collect $200)", 0, 0, false));
        chance.add(new Card("Chance", "Advance to Illinois Ave. - if you pass Go, collect $200", 0, 24, false));
//        chance.add(new Card("Chance", "Advance token to the nearest Utility.\nIf unowned, you may buy it from the Bank.\nIf owned, throw dice and pay owner a total of 10 times the amount shown.", 0, -1, true));
//        chance.add(new Card("Chance", "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", 0, -1, true));
//        chance.add(new Card("Chance", "Advance token to the nearest Railroad.\nIf unowned, you may buy it from the Bank.\nIf owned, pay the owner twice the amount that they are entitled", 0, -1, true));
        chance.add(new Card("Chance", "Advance to St. Charles Place - if you pass Go, collect $200", 0, 11, false));
        chance.add(new Card("Chance", "Bank pays you dividend of $50", 50, -1, false));
        chance.add(new Card("Chance", "Get out of Jail free.", 0, -1, true));
        chance.add(new Card("Chance", "Go back 3 spaces", 0, -1, true));
        //chance.add(new Card("Chance", "You are assessed for street repairs, pay $25 for each house and $100 for each hotel", 0, -1, true));
        chance.add(new Card("Chance", "Pay Poor tax of $15", -15, -1, false));
        chance.add(new Card("Chance", "Take a trip on the Reading Railroad - if you pass Go, collect $200", 0, 5, false));
        chance.add(new Card("Chance", "Take a walk on the Boardwalk - advance token to Boardwalk", 0, 39, false));
        //chance.add(new Card("Chance", "You have been elected Chairman of the board, pay each player $50", -50, -1, true));
        chance.add(new Card("Chance", "Building Loan Matures, collect $150", 150, -1, false));
    }
    private void initCards()
    {
        properties = new ArrayList<>();
        chance = new ArrayList<>();
        communityChest = new ArrayList<>();
        
        initProperties();
        initGiftCards();
    }
    private void initProperties()
    {
        for(Space s : b.getBoard())
        {
            if(s instanceof Property)
            {
                properties.add((Property)s);
            }
        }
    }
}