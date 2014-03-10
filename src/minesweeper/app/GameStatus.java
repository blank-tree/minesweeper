package minesweeper.app;

import minesweeper.gui.Rendering;
import java.util.Scanner;
import minesweeper.logic.*;

/**
 *
 * @author blanktree.ch - fernando obieta
 * @version 0.2 - 09.03.2012
 */
public class GameStatus {

    /**
     * Benutzereingabe eines int mit Nachricht zuvor. Fehlerkontrolle mit minimum und maximum Werten
     * @param scanner
     * @param message
     * @param min-Wert
     * @param max-Wert
     * @return 
     */
    private static int getInt(Scanner scanner, String message, int min, int max) {
        System.out.println(message);
        int output = scanner.nextInt();
        while (output < min || output > max) {
            System.out.println("Wrong input!");
            System.out.println(message);
            output = scanner.nextInt();
        }
        return output;
    }
    
    /**
     * Benutzereingabe eines int mit Nachricht zuvor. Fehlerkontrolle mit minimum und maximum Werten
     * @param scanner
     * @param message
     * @param min-Wert
     * @param max-Wert
     * @return 
     */
    private static double getDouble(Scanner scanner, String message, int min, int max) {
        System.out.println(message);
        double output = scanner.nextDouble();
        while (output < min || output > max) {
            System.out.println("Wrong input!");
            System.out.println(message);
            output = scanner.nextInt();
        }
        return output;
    }
    
    /**
     * Game-Objekt initialisieren. Eckdaten werden zuvor mit externen Fehlerkontrolle vom Benutzer abgefragt
     * @param scanner
     * @return "Game"-Objekt mit Benutzerangaben
     */
    public static Game start(Scanner scanner) {
        Rendering.drawLogo();
        Rendering.drawHorizontalLine();
        int width = getInt(scanner, "Please decide the width of your board (5-10)", 5, 10);
        int height = getInt(scanner, "Please decide the width of your board (5-10)", 5, 10);
        double bombs = getDouble(scanner, "Please decide how many percent of your fields are going to be bombs (1-100)", 1, 100) / 100;
        int lifes = getInt(scanner, "Please decide how many lifes you want to have (1-20): ", 1, 20);
        return new Game(width, height, bombs, lifes);
    }

    /**
     * Methode welche das komplete Spiel ausfuehrt.
     * Uebergeben werden der Scanner und das "Game"-Objekt. Hoehe und Breite
     * werden -1 herausgezogen und dann bieten sich dem Benutzer die Befehle
     * dig und flag an. Extern werden Fehlerabfragen gemacht, das Spielfeld
     * gezeichnet und die Spielelogik ausgefuehrt. Nach jedem Zug wird
     * ueberprueft, ob das Spiel verloren oder gewonnen ist.
     * @param scanner
     * @param game
     */
    public static void play(Scanner scanner, Game game) {
        Board board = game.getBoard();
        int width = board.getWidth() -1;
        int height = board.getHeight() -1;
        char gameCondition = '0';
        while (gameCondition != 'v' && gameCondition != 'l') {
            System.out.println("To flag a field please type f, for digging please type d");
            String command = scanner.nextLine();
            switch (command) {
                case "d": { //dig
                    int x = getInt(scanner, "Where do you want to dig? Please type in the x-coordinate", 0, width);
                    int y = getInt(scanner, "Where do you want to dig? Please type in the y-coordinate", 0, height);
                    if (!(game.dig(x, y))) {
                        gameCondition = 'l'; // 'l' for 'lost'
                    }
                    if (game.getBoard().checkVictoryCondition()) {
                        gameCondition = 'v'; // 'v' for 'victory'
                    }
                    break;
                }
                case "f": { //flag
                    int x = getInt(scanner, "Where do you want to flag? Please type in the x-coordinate", 0, width);
                    int y = getInt(scanner, "Where do you want to flag? Please type in the y-coordinate", 0, height);
                    if (game.flag(x, y)) {
                        System.out.println("The field has been flagged");
                    } else {
                        System.out.println("The flag has been removed from the field");
                    }
                    if (board.checkVictoryCondition()) {
                        gameCondition = 'v'; // 'v' for 'victory'
                    }
                    break;
                }
                case "c": { //cheat! HAHA!
                    for (Field[] row : game.getBoard().getFields()) {
                        for (Field field : row) {
                            if (field.isBomb() && !field.isFlagged()) {
                                field.setFlagged(true);
                        }
                            if (!field.isBomb() && field.isFlagged()) {
                                field.setFlagged(false);
                        }
                    }
                    break;
                }
                }
                default:
                    System.out.println("Wrong command!");
                    break;
            }
            Rendering.clearConsole();
            Rendering.drawRendering(game);
        }
        if (gameCondition == 'v') {
            Rendering.drawVictory();
        } else {
            Rendering.drawGameOver();
        }
    }
}