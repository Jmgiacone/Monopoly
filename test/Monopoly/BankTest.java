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
public class BankTest {
    
    public BankTest() {
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
     * Test of remove method, of class Bank.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Property p = null;
        Bank.remove(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProperty method, of class Bank.
     */
    @Test
    public void testGetProperty() {
        System.out.println("getProperty");
        String s = "";
        Property expResult = null;
        Property result = Bank.getProperty(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawChance method, of class Bank.
     */
    @Test
    public void testDrawChance() {
        System.out.println("drawChance");
        Card expResult = null;
        Card result = Bank.drawChance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drawCommunityChest method, of class Bank.
     */
    @Test
    public void testDrawCommunityChest() {
        System.out.println("drawCommunityChest");
        Card expResult = null;
        Card result = Bank.drawCommunityChest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
}
