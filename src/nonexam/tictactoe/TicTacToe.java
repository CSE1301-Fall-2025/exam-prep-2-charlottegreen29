package nonexam.tictactoe;

/*
 * Instructions for this extension can be found here:
 * 
 * https://131text.com/ns/books/published/csjava/Extensions/5.03.html
 */

public class TicTacToe  {
	
	// avoids Javdoc entry: all methods for this work are static
	private TicTacToe() {
		
	}

	/**
	 * Generate an initial board
	 * @return a 3x3 String[][] array with each element set to a single blank string (" ").
	 */
	public static String[][] genBoard() {
		String[][] board = new String[3][3];
		for (int r=0; r<board.length; r++){
			for (int c=0; c<board[0].length; c++){
				board[r][c]=" ";
			}
		}
		return board;
	}

	/**
	 * Check that the specified player is "x" or "o" and throw an
	 *   IllegalArgumentException if it is not.
	 * @param player should be "x" or "o"
	 */
	public static void verifyValidPlayer(String player) {
		if (player.equals("x") || player.equals("o")) {
			return; // all is well
		}
		else {
			throw new IllegalArgumentException("Player must be a single x or o, but was instead " + player);
		}
	}

	/**
	 * Check that the row is between 0 and 2, inclusively, throwing IllegalArgumentException if not.
	 * @param row should be between 0 and 2, inclusively
	 */
	public static void verifyValidRow(int row) {
		if (row>=0 && row<=2){
			return;
		}
		else{
			throw new IllegalArgumentException("Row must be between 0 and 2 but was instead " + row);
		}
	}

	/**
	 * Check that the col is between 0 and 2, inclusively, throwing IllegalArgumentException if not.
	 * @param col should be between 0 and 2, inclusively
	 */
	public static void verifyValidCol(int col) {
		if (col>=0 && col<=2){
			return;
		}
		else{
			throw new IllegalArgumentException("Column must be between 0 and 2 but was instead " + col);
		}
	}


	/**
	 * Returns a standard view of the current board
	 * @param board the current 3x3 tic tac toe board
	 * @return a String that looks like a tic tac toe board
	 */
	public static String prettyString(String[][] board) {
		String ans = "";
		for (int r=0; r < board.length; ++r) {
			for (int c=0; c < board[r].length; ++c) {
				ans += "| " + board[r][c] + " ";
			}
			ans += "|\n";
		}
		return ans;
	}

	/**
	 * Record a move of the player at the row and column.  You must
	 * <UL>
	 *   <LI> Make sure the player is valid (call {@link #verifyValidPlayer(String)})
	 *   <LI> Make sure the row and column are valid (call {@link #verifyValidRow(int)} and {@link #verifyValidCol(int)})
	 *   <LI> Make sure the board has no move at the row and column.  In other words,
	 *     it should have just a single space there.  If the board already
	 *     has a move there, return false.
	 *   <LI> Record the move at the row and column by storing the player
	 *     String at board[row][col], and return true.
	 * </UL>
	 * 
	 * @param player an "x" or an "o"
	 * @param board a 3x3 String[][] array
	 * @param row an integer between 0 and 2 inclusively
	 * @param col an integer between 0 and 2 inclusively
	 * @return true iff the move was successful
	 */
	public static boolean makeMove(String player, String[][] board, int row, int col) {
		verifyValidPlayer(player);
		verifyValidRow(row);
		verifyValidCol(col);
		if (board[row][col] != " "){
			return false;
		}
		else {
			board[row][col]=player;
			return true;
		}
	}

	/**
	 * Is the board completely full of x and o moves?
	 * @param board a 3x3 String[][] array
	 * @return true iff the board is full
	 */
	public static boolean boardFull(String[][] board) {
		boolean ans = true;
		for (int r=0; r<board.length; r++){
			for (int c=0; c<board[0].length; c++){
				if (board[r][c] == " "){
					ans = false;
				}
			}
		}
		return ans;
	}

	/**
	 * Does the board contain a win for the player?  If it does, this method must return true 
	 *   even if the board also contains a win for the other player.
	 * @param player An "x" or "o". Any other input should throw an IllegalArgumentException
	 * @param board A 3x3 String[][] array
	 * @return true iff the board contains some win for the specified player
	 */
	public static boolean winFor(String player, String[][] board) { // I'm gonna make a maxPathLength recursive method and if the max path length is 3, then it will return true.
		boolean ans = false;
		for (int r = 0; r<board.length; r++){
			for (int c = 0; c<board[0].length; c++){
				if (maxPathLength(player, board, r, c)==3){
					ans = true;
				}
			}
		}
		return ans;
	}

	public static int maxPathLength(String player, String[][] board, int r, int c){
		if (!board[r][c].equals(player)){
			return 0;
		}

		else {
			board[r][c] = "";
			int up = 0;
			if (r>0){
				up = maxPathLength(player,board,r-1,c);
			       
			}

			int down = 0;
			if (r<board.length-1){
				down = maxPathLength(player,board,r+1,c);
			       
			}

			int left = 0;
			if (c>0){
				left = maxPathLength(player,board,r,c-1);
			       
			}

			int right = 0;
			if (c<board[0].length-1){
				right = maxPathLength(player,board,r,c+1);
			       
			}

			board[r][c] = player;

			int upOrDown = Math.max(up, down);
			int rightOrLeft = Math.max (right, left);
			return Math.max (upOrDown, rightOrLeft)+1;
		}
	

	}

}