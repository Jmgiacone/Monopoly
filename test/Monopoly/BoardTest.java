/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import javax.swing.JPanel;
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
public class BoardTest {
    
    public BoardTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoard method, of class Board.
     */
    @Test
    public void testGetBoard() {
        System.out.println("getBoard");
        Board instance = new Board();
        JPanel expResult = null;
        JPanel result = instance.getBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWinner method, of class Board.
     */
    @Test
    public void testIsWinner() {
        System.out.println("isWinner");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseFirst method, of class Board.
     */
    @Test
    public void testChooseFirst() {
        System.out.println("chooseFirst");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.chooseFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Board.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Board instance = new Board();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findPlayerIndex method, of class Board.
     */
    @Test
    public void testFindPlayerIndex() {
        System.out.println("findPlayerIndex");
        String n = "";
        int expResult = 0;
        int result = Board.findPlayerIndex(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
