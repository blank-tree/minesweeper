package minesweeper.logic;

/**
 * 
 * @author blanktree.ch - fernando obieta
 * @version 0.5 - 10.03.2014
 */

public class Game {
	
	//Data
	private Board board;
	private int lives;
	
	//Constructor
	public Game(int x, int y, double bombs, int lives) {
		this.setBoard(new Board(x,y,bombs));
		this.lives = lives;
	}

	//Methods
        
        /**
         * Gibt die Anzahl uebriger Leben zurueck
         * @return lives
         */
	public int getLives() {
		return lives;
	}
        
        /**
         * Bestimmt die Anzahl an Leben des Spielers
         * @param lives 
         */
	public void setLives(int lives) {
		this.lives = lives;
	}

        /**
         * Returns the object Board
         * @return 
         */
	public Board getBoard() {
		return board;
	}

        /**
         * Sets board
         * @param board 
         */
	public void setBoard(Board board) {
		this.board = board;
	}
        
        /**
         * Das gewaehlte Feld wird mit einer Flagge markiert, oder wenn es
         * bereits markiert ist, wird die Flagge entfernt.
         * @param x-Coordinate
         * @param y-Coordinate
         * @return new flagged status
         */
        public boolean flag(int x, int y) {
            return board.toggleFlag(x, y);
        }
        
        /**
         * 
         * @param x-Coordinate of the choosen field to dig
         * @param y-Coordinate of the choosen field to dig
         * @return ist der Spieler noch am Leben?
         */
        public boolean dig(int x, int y) {
            boolean exploded = board.dig(x, y);
            if (exploded) {
                lives--;
            }
            return checkLives();
        }
        
        private boolean checkLives() {
            return !(lives <= 0);
        }
}