/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper.app;
import minesweeper.logic.*;
import minesweeper.gui.*;

/**
 *
 * @author fernandoobieta
 * @version 0.1
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        double bombs = 0.3;
        int lives = 5;
        Game game = new Game(x, y, bombs, lives);
        Minesweeper.drawBoard(game.getBoard());
    }
    
    
    
}
