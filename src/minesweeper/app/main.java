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
 * @author fernandoobieta
 * @version 0.4 - 03.03.2014
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Please decide the width of your board: ");
        int width = scanner.nextInt();
        System.out.println("Please decide the height of your board: ");
        int height = scanner.nextInt();
        System.out.println("Please decide how many percent of your fields are"
                + "going to be bombs: ");
        double bombs = scanner.nextDouble() /10;
        System.out.println("Please decide how many lvies you want to have: ");
        int lives = scanner.nextInt();
        Game game = new Game(width, height, bombs, lives);
        Rendering.clearConsole();
        Rendering.drawBoard(game.getBoard());
        char gameStatus = '0';
        while (gameStatus != 'v' && gameStatus != 'l') {
            System.out.println("To flag a field please type f, for digging"
                    + "please type d: ");
            String command = scanner.nextLine();
            if (command == "d") {
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
                    gameStatus = 'l';
                }
                if (game.getBoard().checkVictoryCondition()) {
                    gameStatus = 'v';
                }
            } else if (command == "f"){
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
                    gameStatus = 'v';
                }
            } else {
                System.out.println("Wrong command!");
            }
            Rendering.clearConsole();
            Rendering.drawBoard(game.getBoard());
        }
    }
    
    
    
}
