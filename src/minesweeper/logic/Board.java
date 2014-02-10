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

    /**
     * Methode welche bloss vom Konstruktor verwendet wird um zu entscheiden mit
     * Bomben zu fuellen
     *
     * @param difficulty
     * @return Entscheidung ob es sich um eine Bombe handelt oder nicht
     */
    private boolean decideFieldIsBomb(double difficulty) {
        return random.nextDouble() < difficulty;
    }

    /**
     * Methode welche ein einzelnes Feld aufdeckt. Dabei wird mit Untermethoden
     * die Anzahl Bomben um das Feld bestummen und dem spezifischen Feld die
     * Anzahl in das enstsprechende Datenfeld geschrieben.
     *
     * @param x-Koordinate des angewaehlten Feldes
     * @param y-Koordinate des angewaehlten Feldes
     * @return Falls eine Bombe getroffen wurde, liefert die Methode true.
     */
    public boolean dig(int x, int y) {
        fields[x][y].setRevealed(true);
        ArrayList<Field> neighborsOf = getNeighborsOf(x, y);
        int neigboringBombs = getBombsIn(neighborsOf);
        fields[x][y].setNumberOfNeighboringBombs(neigboringBombs);
        return fields[x][y].isBomb();
    }

    /**
     * Wird von der Methode "Dig" ausgefuehrt um die Anzahl Bomben aus
     * der uebergebenen ArrayList zusammenzuzaehlen.
     * @param neigbors
     * @return
     */
    private int getBombsIn(ArrayList<Field> neigbors) {
        int bombs = 0;
        for (Field field : neigbors) {
            if (field.isBomb()) {
                bombs++;
            }
        }
        return bombs;
    }

    /**
     * Wird von der Methode "Dig" ausgefuehrt um eine ArrayList
     * mit allen umliegenden Feldern zu erstellen. Dabei ueberprueft 
     * sie zuerst aber ob ueberhaupt alle umliegenden Felder existieren
     * (z.B. ob wir in einer Ecke sind oder an einem Rand).
     * @param x
     * @param y
     * @return 
     */
    private ArrayList<Field> getNeighborsOf(int x, int y) {
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

    /**
     * 
     * @param x
     * @param y
     * @return 
     */
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
