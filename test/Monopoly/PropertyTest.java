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
public class PropertyTest {
    
    public PropertyTest() {
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
     * Test of improve method, of class Property.
     */
    @Test
    public void testImprove() {
        System.out.println("improve");
        Property instance = null;
        instance.improve();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Property.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Property instance = null;
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Property.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Property instance = null;
        String expResult = "";
        String result = instance.getOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOwned method, of class Property.
     */
    @Test
    public void testIsOwned() {
        System.out.println("isOwned");
        Property instance = null;
        boolean expResult = false;
        boolean result = instance.isOwned();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Property.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Property instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMortgaged method, of class Property.
     */
    @Test
    public void testIsMortgaged() {
        System.out.println("isMortgaged");
        Property instance = null;
        boolean expResult = false;
        boolean result = instance.isMortgaged();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mortgage method, of class Property.
     */
    @Test
    public void testMortgage() {
        System.out.println("mortgage");
        Property instance = null;
        instance.mortgage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unMortgage method, of class Property.
     */
    @Test
    public void testUnMortgage() {
        System.out.println("unMortgage");
        Property instance = null;
        instance.unMortgage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMortgagedPrice method, of class Property.
     */
    @Test
    public void testGetMortgagedPrice() {
        System.out.println("getMortgagedPrice");
        Property instance = null;
        int expResult = 0;
        int result = instance.getMortgagedPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentRent method, of class Property.
     */
    @Test
    public void testCurrentRent() {
        System.out.println("currentRent");
        Property instance = null;
        int expResult = 0;
        int result = instance.currentRent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
