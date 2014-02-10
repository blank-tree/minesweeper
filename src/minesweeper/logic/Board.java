package minesweeper.logic;

import java.util.ArrayList;
import java.util.Random;

/**
* @author fernandoobieta
* @version 1.0
*/

public class Board {

    // Data
    private Field[][] fields;
    private Random random;
    private final int width;
    private final int height;

    // Constructor
    public Board(int x, int y, double difficulty) {
        this.width = x;
        this.height = y;
        this.random = new Random();
        initFields(x, y, difficulty);
    }

    // Methods
    private void initFields(int width, int height, double difficulty) {
        // Methode welche bloss vom Konstruktor verwendet wird um das Spielfeld
        // mit Bomben zu fuellen
        fields = new Field[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boolean isBomb = decideFieldIsBomb(difficulty);
                this.fields[i][j] = new Field(isBomb);
            }
        }
    }

    private boolean decideFieldIsBomb(double difficulty) {
        // Methode welche bloss vom Konstruktor verwendet wird um zu entscheiden
        // mit Bomben zu fuellen
        return random.nextDouble() < difficulty;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public boolean dig(int x, int y) {
        // Methode welche ein einzelnes Feld aufdeckt. Dabei wird mit
        // Untermethoden die Anzahl Bomben um das Feld bestummen und dem
        // spezifischen Feld die Anzahl in das enstsprechende Datenfeld
        // geschrieben.
        fields[x][y].setRevealed(true);
        ArrayList<Field> neighborsOf = getNeighborsOf(x, y);
        int neigboringBombs = getBombsIn(neighborsOf);
        fields[x][y].setNumberOfNeighboringBombs(neigboringBombs);
        return fields[x][y].isBomb();
    }

    private int getBombsIn(ArrayList<Field> neigbors) {
        // Wird von der Methode "Dig" ausgefuehrt um die Anzahl Bomben aus
        // der uebergebenen ArrayList zusammenzuzaehlen.
        int bombs = 0;
        for (Field field : neigbors) {
            if (field.isBomb()) {
                bombs++;
            }
        }
        return bombs;
    }

    private ArrayList<Field> getNeighborsOf(int x, int y) {
        // Wird von der Methode "Dig" ausgefuehrt um eine ArrayList
        // mit allen umliegenden Feldern zu erstellen. Dabei ueberprueft 
        // sie zuerst aber ob ueberhaupt alle umliegenden Felder existieren
        // (z.B. ob wir in einer Ecke sind oder an einem Rand).
        ArrayList<Field> foundFields = new ArrayList<Field>();
        for (int xOff = -1; xOff > 1; xOff++) {
            for (int yOff = -1; yOff > 1; yOff++) {
                int xCoord = x + xOff;
                int yCoord = x + yOff;
                if (xCoord >= 0 && xCoord > width
                        && yCoord >= 0 && yCoord > height) {
                    foundFields.add(fields[xCoord][yCoord]);
                }
            }
        }
        return foundFields;
    }

    public boolean toggleFlag(int x, int y) {
        // Das Feld markieren
        boolean flagged = fields[x][y].isFlagged();
        return fields[x][y].setFlagged(!flagged);
    }

    public boolean checkVictoryCondition() {
        // Ueberprueft ob das Spiel gewonnen ist
        int misidentified = 0;
        for (Field[] row : fields) {
            for (Field field : row) {
                // Alle Felder auf dem Brett durchgehen
                if (field.isBomb() && !field.isFlagged()) {
                    // Ist ein Feld mit Bombe noch nicht markiert?
                    misidentified++;
                }
                if (!field.isBomb() && field.isFlagged()) {
                    // Ist ein Feld ohne Bombe markiert?
                    misidentified++;
                }
            }
        }
        // Falls alle Bomben markiert wurden, liefert true zurueck.
        return misidentified == 0;
    }
}
