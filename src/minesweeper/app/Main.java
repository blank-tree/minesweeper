package minesweeper.app;

import minesweeper.logic.*;
import minesweeper.gui.*;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 *
 * @author blanktree.ch - fernando obieta
 * @version 1.0 - GM - 10.03.2014
 */
public class Main {

    public static void main(String[] args) {
        Rendering.clearConsole();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Game game = GameProgress.start(scanner);
        Rendering.clearConsole();
        GameProgress.play(scanner, game);
    }
}