package minesweeper.app;
import minesweeper.logic.*;
import minesweeper.gui.*;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 *
 * @author blanktree.ch - fernando obieta
 * @version 0.5 - 09.03.2012
 */
public class main {

    public static void main(String[] args) {
        Rendering.drawLogo();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        Rendering.clearConsole();
        Game game = GameStatus.start(scanner);
        Rendering.clearConsole();
        GameStatus.play(scanner, game);
    }
}