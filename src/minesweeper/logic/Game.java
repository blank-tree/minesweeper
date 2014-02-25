package minesweeper.logic;

/**
 * 
 * @author fernando
 * @version 0.2
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
         * 
         * @param x-Coordinate of the choosen field to dig
         * @param y-Coordinate of the choosen field to dig
         * @return if the player has won the game
         */
        public boolean dig(int x, int y) {
            boolean exploded = board.dig(x, y);
            if (exploded) {
                lives--;
            }
            return board.checkVictoryCondition();
        }
}