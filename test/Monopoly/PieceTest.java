/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import java.awt.geom.Point2D.Double;
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

    /**
     * Test of getCoords method, of class Piece.
     */
    @Test
    public void testGetCoords() {
        System.out.println("getCoords");
        Piece instance = null;
        Double expResult = null;
        Double result = instance.getCoords();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isClaimed method, of class Piece.
     */
    @Test
    public void testIsClaimed() {
        System.out.println("isClaimed");
        Piece instance = null;
        boolean expResult = false;
        boolean result = instance.isClaimed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of claim method, of class Piece.
     */
    @Test
    public void testClaim() {
        System.out.println("claim");
        String newOwner = "";
        Piece instance = null;
        instance.claim(newOwner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveTo method, of class Piece.
     */
    @Test
    public void testMoveTo() {
        System.out.println("moveTo");
        int x = 0;
        Piece instance = null;
        instance.moveTo(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Piece.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Piece instance = null;
        String expResult = "";
        String result = instance.getOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
