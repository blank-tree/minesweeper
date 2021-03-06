package minesweeper.logic;

/**
 * 
 * @author blanktree.ch - fernando obieta
 * @version 1.0 - GM - 10.03.2014
 */

public class Field {
	//Data
	private final boolean isBomb;
	private boolean isRevealed;
	private boolean isFlagged;
	private int numberOfNeighboringBombs;
        private boolean explosive;

   
	//Constructor
	public Field(boolean isBomb) {
		this.isBomb = isBomb;
		this.isRevealed = false;
		this.isFlagged = false;
                explosive = isBomb;
                numberOfNeighboringBombs = 0;
	}

	//Methods
        /**
         * Gibt einen boolean zurueck, ob das Feld eine Bombe ist.
         * @return if it is a bomb
         */
	public boolean isBomb() {
		return isBomb;
	}

        /**
         * Gibt einen Boolean zurueck, ob das Feld aufgedeckt ist.
         * @return 
         */
	public boolean isRevealed() {
		return isRevealed;
	}

        /**
         * Aendert ob das Feld verdeckt ist
         * @param isRevealed 
         */
	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

        /**
         * Gibt einen Boolean zurueck, ob das Feld markiert ist
         * @return if it is flagged
         */
	public boolean isFlagged() {
		return isFlagged;
	}

        /**
         * Aendert ob das Feld markiert ist oder nicht in das Gegenteil.
         * @param isFlagged
         * @return neuer Zustand
         */
	public boolean setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
		return isFlagged;
	}

        /**
         * Gibt eine Ganzzahl zurueck, wie viele Bomben um das Feld sind
         * @return Anzahl umliegende Bomben
         */
	public int getNumberOfNeighboringBombs() {
		return numberOfNeighboringBombs;
	}

        /**
         * Aendert die Anzahl an umliegenden Bomben um das Feld.
         * @param numberOfNeighboringBombs 
         */
	public void setNumberOfNeighboringBombs(int numberOfNeighboringBombs) {
		this.numberOfNeighboringBombs = numberOfNeighboringBombs;
	} 
        
        /**
         * Gibt true zurueck, wenn die Bombe bereits explodiert ist.
         * @return 
         */
        public boolean isExplosive() {
        return explosive;
        }

        /**
         * Aendert ob die Bombe bereits explodiert ist.
         * @param isExploded 
         */
        public void setExplosive(boolean isExploded) {
            this.explosive = isExploded;
        }
	
}