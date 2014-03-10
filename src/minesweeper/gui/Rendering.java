package minesweeper.gui;

import minesweeper.logic.*;

/**
 * 
 * @author blanktree.ch - fernando obieta
 * @version 1.0 - GM - 10.03.2014
 */

public class Rendering {
    
    /**
     * Zeichnet das Minesweeper-Logo
     */
    public static void drawLogo() {
        System.out.println("  __  __ _                                                   ");
        System.out.println(" |  \\/  (_)                                                  ");
        System.out.println(" | \\  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ ");
        System.out.println(" | |\\/| | | '_ \\ / _ \\/ __\\ \\ /\\ / / _ \\/ _ \\ '_ \\ / _ \\ '__|");
        System.out.println(" | |  | | | | | |  __/\\__ \\\\ V  V /  __/  __/ |_) |  __/ |   ");
        System.out.println(" |_|  |_|_|_| |_|\\___||___/ \\_/\\_/ \\___|\\___| .__/ \\___|_|   ");
        System.out.println("                                            | |              ");
        System.out.println("          by blanktree.ch                   |_|");
    }
    
    /**
     * zeichnet eine gerade Linie zur Gliederung
     */
    public static void drawHorizontalLine() {
        System.out.println("______________________________________________________________________");
    }
    
    /**
     * Zeichnet den aktuellen Spielerstatus
     * @param game 
     */
    public static void drawStatus(Game game) {
        drawHorizontalLine();
        System.out.println("Lives left: " + game.getLives());
        drawHorizontalLine();
    }
    
    /**
     * Zeichnet die X-Koordinaten an das obere Ende des Spielfeldes
     * @param board 
     */
    private static void drawXCoordinates(Board board) {
        String xCoordinates = "       ";
        for(int i=1; i <= board.getWidth(); i++) {
            if(i<10) {
                xCoordinates = xCoordinates + " " + i + "  ";
            } else {
                xCoordinates = xCoordinates + " " + i + " ";
            }
            
        }
        xCoordinates = xCoordinates + " x";
        System.out.println(xCoordinates);
    }
    
    /**
     * Zeichnet die horizontale Trennlinie zwischen den Feldern
     * @param board 
     */
    private static void drawBoardLine(Board board) {
        String widthLine = "      -";
        for(int i=0; i < board.getWidth(); i++) {
            widthLine = widthLine + "----";
        }
        System.out.println(widthLine);
    }
    
    /**
     * Zeichnet die Felder mit ihrem Inhalt getrennt durch Trennlinien inkl.
     * Nummern des Koordinatensystems
     * @param board 
     */
    private static void drawFields(Board board) {
        drawXCoordinates(board);
        drawBoardLine(board);
        int rowNumber = 1;
        for (Field[] row : board.getFields()) {
            String rowDraw = "";
            if (rowNumber < 10) {
                rowDraw = "  " + rowNumber + "   |";
            } else {
                rowDraw = " " + rowNumber + "   |";
            }
            rowNumber++;
            for (Field field : row) {
                String fieldDraw = " ";
                if (field.isFlagged()) {
                    fieldDraw = fieldDraw + "P ";
                } else if (field.isRevealed()) {
                    if (field.isBomb()) {
                        fieldDraw = fieldDraw + "X ";
                    } else {
                        fieldDraw = fieldDraw + field.getNumberOfNeighboringBombs() + " ";
                    }
//                For testing purposes     
//                } else if (field.isBomb()){
//                    fieldDraw = fieldDraw + ". ";
                } else {
                    fieldDraw = fieldDraw + "  ";
                }
                fieldDraw = fieldDraw + "|";
                rowDraw = rowDraw + fieldDraw;
            }
            System.out.println(rowDraw);
            drawBoardLine(board);
        }
        System.out.println("  y");
        drawHorizontalLine();
    }
    
    /**
     * Zeichnet das gesamte Spielfeld inkl. Logo
     * @param game 
     */
    public static void drawRendering(Game game) {
        drawLogo();
        drawStatus(game);
        drawFields(game.getBoard());
    }
    
    /**
     * leert die BlueJ Konsole
     */
    public static void clearConsole() {
        System.out.print("\u000C");
    }
    
    public static void drawVictory() {
        System.out.println(" __      _______ _____ _______ ____  _______     __");
        System.out.println(" \\ \\    / /_   _/ ____|__   __/ __ \\|  __ \\ \\   / /");
        System.out.println("  \\ \\  / /  | || |       | | | |  | | |__) \\ \\_/ / ");
        System.out.println("   \\ \\/ /   | || |       | | | |  | |  _  / \\   /  ");
        System.out.println("    \\  /   _| || |____   | | | |__| | | \\ \\  | |   ");
        System.out.println("     \\/   |_____\\_____|  |_|  \\____/|_|  \\_\\ |_|   ");
    }
    
    public static void drawGameOver() {
            System.out.println("   _____          __  __ ______    ______      ________ _____  ");
            System.out.println("  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ ");
            System.out.println(" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |");
            System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / ");
            System.out.println(" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ ");
            System.out.println("  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
    }
    
}