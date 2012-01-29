/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

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
        Player instance = null;
        instance.landOn(s);
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
}
