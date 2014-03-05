package minesweeper.logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author blanktree.ch - fernando obieta
 * @version 0.6 - 03.03.2014
 */
public class Board {

    // Data
    private Field[][] fields;

    private Random random;
    public final int width;
    public final int height;

    // Constructor
    public Board(int x, int y, double difficulty) {
        this.width = x;
        this.height = y;
        this.random = new Random();
        initFields(x, y, difficulty);
    }

    // Methods
    /**
     * Methode welche bloss vom Konstruktor verwendet wird um das Spielfeld
     * mit Bomben zu fuellen
     * @param width - Breite des Spielfeldes
     * @param height - Hoehe des Spielfeldes
     * @param difficulty - Schwierigkeitsstufe zwischen 0 und 1
     * z. B. 0.4 = 40% Bomben, 0.345 = 34.5% Bomben
     */
    private void initFields(int width, int height, double difficulty) {
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
     * @return Anzahl Bomben in der uebergebenen ArrayList
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
     * @return ArrayList mit allen umliegenden Felder der Koordinate des
     * Feldes
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
     * Aendert den Markiert-Status des als Koordinate angegebenen Feldes
     * @param x-Koordinate
     * @param y-Koordinate
     * @return Neuer Status des geaenderten Feldes
     */
    public boolean toggleFlag(int x, int y) {
        boolean flagged = fields[x][y].isFlagged();
        return fields[x][y].setFlagged(!flagged);
    }

    /**
     * Ueberprueft ob das Spiel gewonnen ist
     * @return Boolean ob das Spiel gewonnen ist
     */
    public boolean checkVictoryCondition() {
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
    
    /**
     * Gibt alle Felder des Spielbretts zurueck
     * @return Field[][]
     */
    public Field[][] getFields() {
        return fields;
    }
    
    /**
     * Gibt die Breite des Spielfeldes zurueck.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gibt die Hoehe des Spielfeldes zurueck
     * @return height
     */
    public int getHeight() {
        return height;
    }
}
