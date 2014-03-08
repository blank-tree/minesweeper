/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minesweeper.app;
import minesweeper.logic.*;
import minesweeper.gui.*;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 *
 * @author blanktree.ch - fernando obieta
 * @version 0.4 - 03.03.2014
 */
public class main {

    public static void main(String[] args) {
        Rendering.drawLogo();
        GameStatus gameStatus = new GameStatus();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Game game = gameStatus.start(scanner);
        Rendering.clearConsole();
        Rendering.drawBoard(game.getBoard());
        gameStatus.play(scanner, game);
    }
    
    
    
}