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
        properties = new ArrayList<Property>();
        chance = new ArrayList<Card>();
        communityChest = new ArrayList<Card>();
        
        initCards();
    }
    
    public static void remove(Property p)
    {
        properties.remove(p);
    }        
    public static Property getProperty(Property p)
    {
        return properties.get(properties.indexOf(p));
    }
    private void initCards()
    {
        properties.add(new Property(
                "Mediterranean Avenue", 60, 2, 10, 30, 90, 160, 250));
        properties.add(new Property(
                "Baltic Avenue", 60, 4, 20, 60, 180, 320, 450));
        properties.add(new Property(
                "Oriental Avenue", 100, 6, 30, 90, 270, 400, 550));
        properties.add(new Property(
                "Vermont Avenue", 100, 6, 30, 90, 270, 400, 550));
        properties.add(new Property(
                "Connecticut Avenue", 120, 8, 40, 100, 300, 450, 600));
        properties.add(new Property(
                "St. Charles Place", 140, 10, 50, 150, 450, 635, 750));
        properties.add(new Utility(
                "Electric Company", 150));
        properties.add(new Property(
                "States Avenue", 140, 10, 50, 150, 450, 635, 750));
        properties.add(new Property(
                "Virginia Avenue", 160, 12, 60, 180, 500, 700, 900));
        properties.add(new Property(
                "St. James Place", 180, 14, 70, 200, 550, 750, 950));
        properties.add(new Property(
                "Tennessee Avenue", 180, 14, 70, 200, 550, 750, 950));
        properties.add(new Property(
                "New York Avenue", 200, 16, 80, 220, 600, 800, 1000));
        properties.add(new Property(
                "Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050));
        properties.add(new Property(
                "Indiana Avenue", 220, 18, 90, 250, 700, 875, 1050));
        properties.add(new Property(
                "Illinois Avenue", 240, 20, 100, 300, 750, 925, 1100));
        properties.add(new Property(
                "Atlantic Avenue", 260, 22, 110, 330, 800, 975, 1150));
        properties.add(new Property(
                "Ventnor Avenue", 260, 22, 110, 330, 800, 975, 1150));
        properties.add(new Utility(
                "Water Works", 150));
        properties.add(new Property(
                "Marvin Gardens", 280, 24, 120, 360, 850, 1025, 1200));
        properties.add(new Property(
                "Pacific Avenue", 300, 26, 130, 390, 900, 1100, 1275));
        properties.add(new Property(
                "North Carolina Avenue", 300, 26, 130, 390, 900, 1100, 1275));
        properties.add(new Property(
                "Pennyslyvania Avenue", 320, 28, 150, 450, 1000, 1200, 1400));
        properties.add(new Property(
                "Park Place", 350, 35, 175, 500, 1100, 1300, 1500));
        properties.add(new Property(
                "Boardwalk", 400, 50, 200, 600, 1400, 1700, 2000));
        properties.add(new RailRoad(
                "Reading Railroad", 200));
        properties.add(new RailRoad(
                "B & O Railroad", 200));
        properties.add(new RailRoad(
                "Short Line Railroad", 200));
        properties.add(new RailRoad(
                "Pennyslyvania Railroad", 200));
    }
}
