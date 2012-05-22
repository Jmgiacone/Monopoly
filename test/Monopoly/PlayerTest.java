/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of landOn method, of class Player.
     */
    @Test
    public void testLandOn() {
        System.out.println("landOn");
        Space s = null;
        Player instance = new Player(null, null);
        instance.landOn(new Property(
                "Kentucky Avenue", 220, 18, 90, 250, 700, 875, 1050, new Point2D.Double(145,55)));
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiecePosition method, of class Player.
     */
    @Test
    public void testGetPiecePosition() {
        System.out.println("getPiecePosition");
        Player instance = null;
        int expResult = 0;
        int result = instance.getPiecePosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roll method, of class Player.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        Player instance = null;
        instance.roll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoll1 method, of class Player.
     */
    @Test
    public void testGetRoll1() {
        System.out.println("getRoll1");
        Player instance = null;
        int expResult = 0;
        int result = instance.getRoll1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoll2 method, of class Player.
     */
    @Test
    public void testGetRoll2() {
        System.out.println("getRoll2");
        Player instance = null;
        int expResult = 0;
        int result = instance.getRoll2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Player.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Player instance = null;
        int expResult = 0;
        int result = instance.getBalance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buy method, of class Player.
     */
    @Test
    public void testBuy() {
        System.out.println("buy");
        Property p = null;
        Player instance = null;
        instance.buy(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mortgage method, of class Player.
     */
    @Test
    public void testMortgage() {
        System.out.println("mortgage");
        Property p = null;
        Player instance = null;
        String expResult = "";
        String result = instance.mortgage(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tradeWith method, of class Player.
     */
    @Test
    public void testTradeWith() {
        System.out.println("tradeWith");
        Player other = null;
        Player instance = null;
        instance.tradeWith(other);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unMortgage method, of class Player.
     */
    @Test
    public void testUnMortgage() {
        System.out.println("unMortgage");
        Property p = null;
        Player instance = null;
        String expResult = "";
        String result = instance.unMortgage(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBankrupt method, of class Player.
     */
    @Test
    public void testIsBankrupt() {
        System.out.println("isBankrupt");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.isBankrupt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumUtilities method, of class Player.
     */
    @Test
    public void testGetNumUtilities() {
        System.out.println("getNumUtilities");
        Player instance = null;
        int expResult = 0;
        int result = instance.getNumUtilities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumRailRoads method, of class Player.
     */
    @Test
    public void testGetNumRailRoads() {
        System.out.println("getNumRailRoads");
        Player instance = null;
        int expResult = 0;
        int result = instance.getNumRailRoads();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay_Card() {
        System.out.println("pay");
        Card c = null;
        Player instance = null;
        instance.pay(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay_Space() {
        System.out.println("pay");
        Space s = null;
        Player instance = null;
        instance.pay(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay_RailRoad() {
        System.out.println("pay");
        RailRoad r = null;
        Player instance = null;
        instance.pay(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay_Utility() {
        System.out.println("pay");
        Utility u = null;
        Player instance = null;
        instance.pay(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Player.
     */
    @Test
    public void testPay_Property() {
        System.out.println("pay");
        Property p = null;
        Player instance = null;
        instance.pay(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptPayment method, of class Player.
     */
    @Test
    public void testAcceptPayment() {
        System.out.println("acceptPayment");
        int payment = 0;
        Player instance = null;
        instance.acceptPayment(payment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bankrupt method, of class Player.
     */
    @Test
    public void testBankrupt() {
        System.out.println("bankrupt");
        Player instance = null;
        instance.bankrupt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Player.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Player p = null;
        Player instance = null;
        int expResult = 0;
        int result = instance.compareTo(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
