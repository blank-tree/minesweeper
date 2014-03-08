/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper.logic;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernando
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
        Board instance = new Board(5, 5, 50) {
            public void setFields(Field[][] fields) {
                this.fields = fields;
            }
            public ArrayList<Field> getNeighborsOf(int x, int y) {
                return super.getNeighborsOf(x, y);
                
            }
        };
        
        Field[][] fields = new Field[3][3];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                fields[i][j] = new Field(false);
            }
    }
        fields[0][0] = new Field(true);
        ArrayList<Field> fooBar = instance.getNeighborsOf(0, 1);
        assertEquals(6 ,fooBar.size());
        
        
        
        
       
       
       
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

    /**
     * Test of getFields method, of class Board.
     */
    @Test
    public void testGetFields() {
        System.out.println("getFields");
        Board instance = null;
        Field[][] expResult = null;
        Field[][] result = instance.getFields();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Board.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Board instance = null;
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Board.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Board instance = null;
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
