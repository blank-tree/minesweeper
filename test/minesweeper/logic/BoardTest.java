/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernandoobieta
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dig method, of class Board.
     */
    @Test
    public void testDig() {
        System.out.println("dig");
        int x = 0;
        int y = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.dig(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFlag method, of class Board.
     */
    @Test
    public void testToggleFlag() {
        System.out.println("toggleFlag");
        int x = 0;
        int y = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.toggleFlag(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkVictoryCondition method, of class Board.
     */
    @Test
    public void testCheckVictoryCondition() {
        System.out.println("checkVictoryCondition");
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.checkVictoryCondition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
