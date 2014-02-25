package minesweeper.logic;

/**
 * 
 * @author fernando
 * @version 0.2
 */

public class Field {
	//Data
	private final boolean isBomb;
	private boolean isRevealed;
	private boolean isFlagged;
	private int numberOfNeighboringBombs;
	
	//Constructor
	public Field(boolean isBomb) {
		this.isBomb = isBomb;
		this.isRevealed = false;
		this.isFlagged = false;
	}

	//Methods
	public boolean isBomb() {
		return isBomb;
	}

	public boolean isRevealed() {
		return isRevealed;
	}

	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public boolean setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
		return isFlagged;
	}

	public int getNumberOfNeighboringBombs() {
		return numberOfNeighboringBombs;
	}

	public void setNumberOfNeighboringBombs(int numberOfNeighboringBombs) {
		this.numberOfNeighboringBombs = numberOfNeighboringBombs;
	}
}