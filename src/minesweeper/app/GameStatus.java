/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.app;

import minesweeper.gui.Rendering;
import java.util.Scanner;
import minesweeper.logic.Game;

/**
 *
 * @author blanktree.ch - fernando obieta
 * @version 0.1 - 05.03.2014
 */
public class GameStatus {

    public static int getInt(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
    
    public static double getDouble(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextDouble();
    }
    
    
    public static Game start(Scanner scanner) {
        System.out.println("Please decide the width of your board (5-10): ");
        int width = scanner.nextInt();
        System.out.println("Please decide the height of your board (5-10): ");
        int height = scanner.nextInt();
        System.out.println("Please decide how many percent of your fields are going to be bombs (1-100): ");
        double bombs = scanner.nextDouble() / 10;
        System.out.println("Please decide how many lives you want to have (1+): ");
        int lives = scanner.nextInt();
        return new Game(width, height, bombs, lives);
    }

    public static boolean play(Scanner scanner, Game game) {
        char gameCondition = '0';
        while (gameCondition != 'v' && gameCondition != 'l') {
            System.out.println("To flag a field please type f, for digging please type d: ");
            String command = scanner.nextLine();
            switch (command) {
                case "d": {
                    System.out.println("Where do want to dig? Please type in the x-coordinate");
                    int x = scanner.nextInt();
                    while (x > game.getBoard().getWidth() || x < 0) {
                        System.out.println("Please enter a correct x-coordinate");
                        System.out.println("Where do want to dig? Please type in the x-coordinate");
                        x = scanner.nextInt();
                    }
                    System.out.println("Where do want to dig? Please type in the y-coordinate");
                    int y = scanner.nextInt();
                    while (y > game.getBoard().getHeight() || y < 0) {
                        System.out.println("Please enter a correct y-coordinate");
                        System.out.println("Where do want to dig? Please type in the y-coordinate");
                        y = scanner.nextInt();
                    }
                    if (!(game.dig(x, y))) {
                        gameCondition = 'l'; // 'l' for 'lost'
                    }
                    if (game.getBoard().checkVictoryCondition()) {
                        gameCondition = 'v'; // 'v' for 'victory'
                    }
                    break;
                }
                case "f": {
                    System.out.println("Where do want to flag? Please type in the x-coordinate");
                    int x = scanner.nextInt();
                    while (x > game.getBoard().getWidth() || x < 0) {
                        System.out.println("Please enter a correct x-coordinate");
                        System.out.println("Where do want to flag? Please type in the x-coordinate");
                        x = scanner.nextInt();
                    }
                    System.out.println("Where do want to flag? Please type in the y-coordinate");
                    int y = scanner.nextInt();
                    while (y > game.getBoard().getHeight() || y < 0) {
                        System.out.println("Please enter a correct y-coordinate");
                        System.out.println("Where do want to flag? Please type in the y-coordinate");
                        y = scanner.nextInt();
                    }
                    if (game.flag(x, y)) {
                        System.out.println("The field has been flagged");
                    } else {
                        System.out.println("The flag has been removed from the field");
                    }
                    if (game.getBoard().checkVictoryCondition()) {
                        gameCondition = 'v'; // 'v' for 'victory'
                    }
                    break;
                }
                default:
                    System.out.println("Wrong command!");
                    break;
            }
            Rendering.clearConsole();
            Rendering.drawBoard(game.getBoard());
        }
       // if (gameCondition == 'v') {
//            Rendering.drawVictory();
  //      } else {
    //        Rendering.drawLost();
      //  }
        return gameCondition == 'v';
    }
}
