package minesweeper.logic;

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
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
        
        public boolean dig(int x, int y) {
            boolean exploded = board.dig(x, y);
            if (exploded) {
                lives--;
            }
            return board.checkVictoryCondition();
        }
}