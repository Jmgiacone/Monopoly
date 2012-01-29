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
public class SpaceTest {
    
    public SpaceTest() {
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
     * Test of isProperty method, of class Space.
     */
    @Test
    public void testIsProperty() {
        System.out.println("isProperty");
        Space instance = null;
        boolean expResult = false;
        boolean result = instance.isProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Space.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Space instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
