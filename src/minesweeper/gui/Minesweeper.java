package minesweeper.gui;

import javax.swing.*;
import minesweeper.logic.*;

public class Minesweeper {

    public static void createAndShowGUI() {
        int x = 5;
        int y = 5;
        int frameWidth = 500;
        int frameHeight = 500;
        JButton[][] labels = new JButton[x][y];
        Game game = new Game(x, y, 0.2, 10);
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int xi = 0; xi < x; xi++) {
            for (int yi = 0; yi < y; yi++) {
                labels[xi][yi] = new JButton(xi + "/" + yi);
                frame.getContentPane().add(labels[xi][yi]);
//                System.out.println(xi + "/" + yi);
            }

        }
     
        
        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
