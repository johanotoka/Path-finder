/**
 *@author Steeve Johan Otoka Eyota
 *@version 1.0
 *@since 2020-12-01
 */
import java.util.*;

/**
 *@author Steeve Johan Otoka Eyota
 *@version 1.0
 *@since 2020-12-01
 */

public class Map {
	boolean[][] map;
	private int row;
	private int column;

	/**
	 * This is the constructor that constructs the city map, which is a grid of row
	 * by column.
	 * 
	 * @param row    is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int row, int column) {
		// Please implement the constructor

		this.row = row;
		this.column = column;
		this.map = new boolean[row][column];

	}

	/**
	 * This method checks the correctness of the input parameters. If the
	 * preconditions are not met an exception is thrown, otherwise depending to the
	 * direction, it calls one of the four recursive functions of goSouthWest,
	 * goSouthEast, goNorthWest and goNorthEast.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0,
	 *      N) if N is the number of east-west streets and [0, M) if M is the number
	 *      of north-south streets.)
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// Check if the parameters are in the range of the city grid
		if ((startRow >= 0) && (startRow < this.row) && (startCol >= 0) && (startCol < this.column) && (destRow >= 0)
				&& (destRow < this.row) && (destCol >= 0) && (destCol < this.column)) {

			// Check condition for the car to go South West
			if ((startRow >= destRow) && (startCol >= destCol)) {
				return goSouthWest(startRow, startCol, destRow, destCol, path);
				// Check condition for the car to go South East
			} else if ((startRow >= destRow) && (startCol <= destCol)) {
				return goSouthEast(startRow, startCol, destRow, destCol, path);
				// Check condition for the car to go North West
			} else if ((startRow <= destRow) && (startCol >= destCol)) {
				return goNorthWest(startRow, startCol, destRow, destCol, path);
				// Else the car goes North East
			} else {
				return goNorthEast(startRow, startCol, destRow, destCol, path);
			}
		}
		// Throw an exception if the parameters are not on the range of the city grid
		else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */

	private String goSouthWest(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// base case: the starting position is equal to the final position
		if ((startRow == destRow) && (startCol == destCol)) {
			return "";
		}
		// recursive step
		// decrement startCol if it is greater than destCol
		else if ((startRow == destRow) && (startCol > destCol)) {
			startCol--;
			return "(" + startRow + "," + startCol + ") " + goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		// decrement startRow if it is greater than destRow
		else if ((startRow > destRow) && (startCol == destCol)) {
			startRow--;
			return "(" + startRow + "," + startCol + ") " + goSouthWest(startRow, startCol, destRow, destCol, path);
		}
		// decrement startRow if it is greater than destRow and startCol is greater than
		// destCol
		else {
			startRow--;
			return "(" + startRow + "," + startCol + ") " + goSouthWest(startRow, startCol, destRow, destCol, path);
		}

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goSouthEast(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// base case: the starting position is equal to the final position
		if ((startRow == destRow) && (startCol == destCol)) {
			return "";
		}
		// recursive step
		// increment startCol if it is less than destCol
		else if ((startRow == destRow) && (startCol < destCol)) {
			startCol++;
			return "(" + startRow + "," + startCol + ") " + goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		// decrement startRow if it is greater than destRow
		else if ((startRow > destRow) && (startCol == destCol)) {
			startRow--;
			return "(" + startRow + "," + startCol + ") " + goSouthEast(startRow, startCol, destRow, destCol, path);
		}
		// decrement startRow if it is greater than destRow and startCol is less than
		// destCol
		else {
			startRow--;
			return "(" + startRow + "," + startCol + ") " + goSouthEast(startRow, startCol, destRow, destCol, path);
		}

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */
	private String goNorthEast(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// base case: the starting position is equal to the final position
		if ((startRow == destRow) && (startCol == destCol)) {
			return "";
		}
		// recursive step
		// increment startCol if it is less than destCol
		else if ((startRow == destRow) && (startCol < destCol)) {
			startCol++;
			return "(" + startRow + "," + startCol + ") " + goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		// increment startRow if it is less than destRow
		else if ((startRow < destRow) && (startCol == destCol)) {
			startRow++;
			return "(" + startRow + "," + startCol + ") " + goNorthEast(startRow, startCol, destRow, destCol, path);
		}
		// decrement startRow if it is less than destRow and startCol is less than
		// destCol
		else {
			startRow++;
			return "(" + startRow + "," + startCol + ") " + goNorthEast(startRow, startCol, destRow, destCol, path);
		}

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */
	private String goNorthWest(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// base case: the starting position is equal to the final position
		if ((startRow == destRow) && (startCol == destCol)) {
			return "";
		}
		// recursive step
		// decrement startCol if it is greater than destCol
		else if ((startRow == destRow) && (startCol > destCol)) {
			startCol--;
			return "(" + startRow + "," + startCol + ") " + goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		// increment startRow if it is less than destRow
		else if ((startRow < destRow) && (startCol == destCol)) {
			startRow++;
			return "(" + startRow + "," + startCol + ") " + goNorthWest(startRow, startCol, destRow, destCol, path);
		}
		// increment startRow if it is less than destRow and startCol is greater than
		// destCol
		else {
			startRow++;
			return "(" + startRow + "," + startCol + ") " + goNorthWest(startRow, startCol, destRow, destCol, path);
		}

	}

	/**
	 * This method find a path from (startRow, startCol) to a border point of the
	 * city. Please note that the starting point should be included in the path.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, starting col) to a border point of the
	 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	public String findPath(int startRow, int startCol) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.

		// the idea is to solve the problem using indirect recursion
		// so we will need a helper method

		// we may forget our starting position
		// let's keep it in variables as a respawn position
		int respawnRow = startRow;
		int respawnCol = startCol;

		// using the map provided
		// we set all the elements to true
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				map[r][c] = true;
			}
		}

		// we set the starting position to false, since it is considered already visited
		map[startRow][startCol] = false;

		// pahtHistory is the returning String of the path taken by the car
		String pathHistory = "(" + startRow + "," + startCol + ") ";

		pathHistory = pathHistory + findPathHelper(startRow, startCol, pathHistory);

		if (pathHistory.contains("POLICE")) {
			return findPath(respawnRow, respawnCol);
		} else {
			return pathHistory;
		}
	}

	// Helper method
	/**
	 * This method is the helper method for findPath(). It returns an empty String
	 * if the car has reached the border of the city, otherwise it return the path
	 * taken by the car and also indicates if it came across a police car
	 * 
	 * @param startRow    is the starting row of the path
	 * @param startCol    is the starting column of the path
	 * @param pathHistory is the path taken by the car
	 * 
	 * @return is a path from (starting row, starting col) to a border point of the
	 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 */

	private String findPathHelper(int startRow, int startCol, String pathHistory) {

		if ((startRow == 0) || (startRow == row - 1) || (startCol == 0) || (startCol == column - 1)) {
			return "";
		} else {
			// destRow is the destination row
			// destCol is the destination column
			int destRow = 0;
			int destCol = 0;

			// Generating a random number between 1 to 4
			Random rand = new Random();
			int direction = rand.nextInt(4) + 1;

			// the car randomly choose any of these directions
			switch (direction) {
			case 1:
				destRow = startRow + 1;
				destCol = startCol;
				break;
			case 2:
				destRow = startRow - 1;
				destCol = startCol;
				break;
			case 3:
				destRow = startRow;
				destCol = startCol + 1;
				break;
			case 4:
				destRow = startRow;
				destCol = startCol - 1;
				break;
			}

			if (map[destRow][destCol] == false) {
				return pathHistory + "POLICE";
			} else {
				pathHistory = getPath(startRow, startCol, destRow, destCol, "");

				map[destRow][destCol] = false;

				return pathHistory + findPathHelper(destRow, destCol, pathHistory);
			}
		}
	}

} // end of class