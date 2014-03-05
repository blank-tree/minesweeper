package minesweeper.gui;

import minesweeper.logic.*;

/**
 * 
 * @author blanktree.ch - fernando obieta
 * @version 0.3 - 03.03.2014
 */

public class Rendering {
    //Data
    
    //Contructor
    
    //Methods
    
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
     * Zeichnet die horizontale Trennlinie
     * @param board 
     */
    private static void drawLine(Board board) {
        String widthLine = "   _";
        for(int i=0; i < board.width; i++) {
            widthLine = widthLine + "____";
        }
        System.out.println(widthLine);
    }
    
    /**
     * Zeichnet die Felder mit ihrem Inhalt getrennt durch Trennlinien
     * @param board 
     */
    private static void drawFields(Board board) {
        drawLine(board);
        for (Field[] row : board.getFields()) {
            String rowDraw = "   |";
            for (Field field : row) {
                String fieldDraw = " ";
                if (field.isFlagged()) {
                    fieldDraw = fieldDraw + " P ";
                } else if (field.isRevealed()) {
                    if (field.isBomb()) {
                        fieldDraw = fieldDraw + " X ";
                    } else {
                        fieldDraw = fieldDraw + " " + field.getNumberOfNeighboringBombs() + " ";
                    }
                } else {
                    fieldDraw = fieldDraw + " ";
                }
                fieldDraw = fieldDraw + " |";
                rowDraw = rowDraw + fieldDraw;
            }
            System.out.println(rowDraw);
            drawLine(board);
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
    /**
     * Zeichnet das gesamte Spielfeld inkl. Logo
     * @param board 
     */
    public static void drawBoard(Board board) {
        drawLogo();
        drawFields(board);
    }
    
    /**
     * leert die BlueJ Konsole
     */
    public static void clearConsole() {
        System.out.print("\u000C");
    }
    
}