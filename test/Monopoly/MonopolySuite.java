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
@Suite.SuiteClasses({MonopolyGUITest.class, ImprovableTest.class, CardTest.class, PlayerTest.class, BankTest.class, UtilityTest.class, PieceTest.class, PropertyTest.class, MonopTesterTest.class, RailRoadTest.class, SpaceTest.class, BoardTest.class})
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
