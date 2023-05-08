package turing;

public class Tape {
	private Cell currentCell; // the pointer that points to the current cell

	/**
	 * Constructs a new Tape object that initially consists of a single cell
	 * containing a blank space. Sets the current cell pointer to the new cell.
	 */
	Tape() {
		Cell cell = new Cell(); // create a new cell with a blank space
		currentCell = cell; // set the current cell pointer to the new cell
		currentCell.content = ' '; // Initialize the tape with a blank character.
		 
	}

	/**
	 * Returns the pointer that points to the current cell.
	 *
	 * @return The pointer that points to the current cell.
	 */
	public Cell getCurrentCell() {
		return currentCell;
	} // returns the pointer that points to the current cell.

	/**
	 * Returns the character in the current cell.
	 *
	 * @return The character in the current cell.
	 */
	public char getContent() {
		return currentCell.content; // return the character from the current cell
	}

	/**
	 * Changes the character in the current cell to the specified value.
	 *
	 * @param ch The new character to be set in the current cell.
	 */
	public void setContent(char cha) {
		currentCell.content = cha;
	} // changes the char in the current cell to the specified value.

	/**
	 * Moves the current cell one position to the left along the tape. If the
	 * current cell is the leftmost cell that exists, a new cell is created and
	 * added to the tape at the left of the current cell, and then the current cell
	 * pointer is moved to point to the new cell. The content of the new cell is a
	 * blank space.
	 */
	public void moveLeft() {
		if (currentCell.prev == null) { // if the current cell is the leftmost cell that exists
			Cell newCell = new Cell(); // create a new cell with a blank space
			newCell.next = currentCell; // set the next pointer of the new cell to the current cell
			currentCell.prev = newCell; // set the previous pointer of the current cell to the new cell
			currentCell = newCell; // set the current cell pointer to the new cell
		} else { // if the current cell is not the most left cell
			currentCell = currentCell.prev; // move the current cell pointer one position to the left
		}
	} // moves the current cell one position to the left along the tape. Note that if
		// the current cell is the leftmost cell that exists, then a new cell must be
		// created and added to the tape at the left of the current cell, and then the
		// current cell pointer can be moved to point to the new cell. The content of
		// the new cell should be a blank space. (Remember that the Turing machine's
		// tape is conceptually infinite, so your linked list must be prepared to expand
		// on-demand when the machine wants to move past the current end of the list.)

	/**
	 * 
	 * Moves the current cell one position to the right along the tape. If the
	 * current cell is the rightmost cell that exists, a new cell is created and
	 * added to the tape at the right of the current cell, and then the current cell
	 * pointer is moved to point to the new cell. The content of the new cell should
	 * be a blank space.
	 * 
	 * @return void
	 */
	public void moveRight() {
		if (currentCell.next == null) { // if the current cell is the rightmost cell that exists
			Cell newCell = new Cell(); // create a new cell with a blank space
			newCell.prev = currentCell; // set the previous pointer of the new cell to the current cell
			currentCell.next = newCell; // set the next pointer of the current cell to the new cell
			currentCell = newCell; // set the current cell pointer to the new cell
		} else { // if the current cell is not the rightmost cell
			currentCell = currentCell.next; // move the current cell pointer one position to the right
		}
	}// moves the current cell one position to the right along the tape. Note that if
		// the current cell is the rightmost cell that exists, then a new cell must be
		// created and added to the tape at the right of the current cell, and then the
		// current cell pointer can be moved to point to the new cell. The content of
		// the new cell should be a blank space.

	/**
	 * 
	 * Returns a String consisting of the characters from all the cells on the tape,
	 * read from left to right, except that leading or trailing blank characters
	 * should be discarded. The current cell pointer should not be moved by this
	 * method; it should point to the same cell after the method is called as it did
	 * before. A different pointer is used to move along the tape and get the full
	 * contents.
	 * 
	 * @return a String representing the tape contents
	 */
	public String getTapeContents() {
		// create a new pointer that starts from the leftmost cell on the tape
		Cell pointer = currentCell;
		while (pointer.prev != null) {
			pointer = pointer.prev;
		}

		// iterate through all the cells on the tape and build a string of non-blank
		// characters
		// Create a StringBuilder object to construct the string representation of the
		// tape

		StringBuilder tapeBuilder = new StringBuilder();
		while (pointer != null) {
			if (pointer.content != ' ') {
				// discard leading/trailing blank characters
				tapeBuilder.append(pointer.content);
			}
			pointer = pointer.next;
		}
			 
		return tapeBuilder.toString().trim();
	}// returns a String consisting of the chars from all the cells on the tape, read
		// from left to right, except that leading or trailing blank characters should
		// be discarded. The current cell pointer should not be moved by this method; it
		// should point to the same cell after the method is called as it did before.
		// You can create a different pointer to move along the tape and get the full
		// contents. (This method is the hardest one to implement.)
	
	public static void main(String[] args) {
		
	}
	
}
