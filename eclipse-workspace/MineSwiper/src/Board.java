import javax.swing.*;

public class Board {
	// 2-dimensional array of objects of type "Space"
	// The size of the array is determined by the static variables "Game.Y" and
	// "Game.X
	// holds the current state of the game board, with each element in the 2D array
	// representing a particular space or cell on the board
	private Space[][] board = new Space[Game.Y][Game.X];
	public Board() {
		int remainder = Game.BOMB_COUNT;
	}
}
