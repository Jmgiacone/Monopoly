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
public class PieceTest {
    
    public PieceTest() {
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
     * Test of move method, of class Piece.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int spaces = 0;
        Piece instance = null;
        instance.move(spaces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Piece.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Piece instance = null;
        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Piece.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Piece instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
