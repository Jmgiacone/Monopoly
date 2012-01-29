/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Monopoly;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jordan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Monopoly.MonopolyGUITest.class, Monopoly.ImprovableTest.class, Monopoly.CardTest.class, Monopoly.PlayerTest.class, Monopoly.BankTest.class, Monopoly.UtilityTest.class, Monopoly.PieceTest.class, Monopoly.PropertyTest.class, Monopoly.RailRoadTest.class, Monopoly.SpaceTest.class, Monopoly.BoardTest.class})
public class MonopolySuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
