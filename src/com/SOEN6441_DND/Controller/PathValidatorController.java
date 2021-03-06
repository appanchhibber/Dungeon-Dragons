package com.SOEN6441_DND.Controller;

/**
 * This Class is Map Validation
 * 1.) Map Path Validation
 * @author Punit Trivedi
 * @author Appan Chhibber.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.PriorityQueue;

import javax.swing.JButton;

/**
 * This class is responsible for validating the path for the map
 * 
 * @author Appan Chhibber
 * @author Punit Trivedi
 *
 */
public class PathValidatorController {
	public static final int DIAGONAL_COST = 14;
	public static final int V_H_COST = 10;
	public static JButton[][] mapCell;

	static class Cell {
		int heuristicCost = 0; // Heuristic cost
		int finalCost = 0; // G+H
		int i, j;
		Cell parent;

		Cell(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "[" + this.i + ", " + this.j + "]";
		}
	}

	// Blocked cells are just null Cell values in grid
	static Cell[][] grid = new Cell[5][5];

	static PriorityQueue<Cell> open;

	static boolean closed[][];
	static int startI, startJ;
	static int endI, endJ;

	/**
	 * sets the blocked element list
	 * 
	 * @param i
	 * @param j
	 */
	public static void setBlocked(int i, int j) {
		grid[i][j] = null;
	}

	/**
	 * sets the start point for the path
	 * 
	 * @param i
	 * @param j
	 */
	public static void setStartCell(int i, int j) {
		startI = i;
		startJ = j;
	}

	/**
	 * Sets the end point for the path
	 * 
	 * @param i
	 * @param j
	 */
	public static void setEndCell(int i, int j) {
		endI = i;
		endJ = j;
	}

	/**
	 * CHecks the cost of moving the element to the path ie wether a move is
	 * possible
	 * 
	 * @param current
	 * @param t
	 * @param cost
	 */
	static void checkAndUpdateCost(Cell current, Cell t, int cost) {
		if (t == null || closed[t.i][t.j])
			return;
		int t_final_cost = t.heuristicCost + cost;

		boolean inOpen = open.contains(t);
		if (!inOpen || t_final_cost < t.finalCost) {
			t.finalCost = t_final_cost;
			t.parent = current;
			if (!inOpen)
				open.add(t);
		}
	}

	/**
	 * implementation of the a* algorithm
	 */
	public static void AStar() {
		// add the start location to open list.
		open.add(grid[startI][startJ]);
		Cell current;

		while (true) {
			current = open.poll();
			if (current == null)
				break;
			closed[current.i][current.j] = true;

			if (current.equals(grid[endI][endJ])) {
				return;
			}

			Cell t;
			if (current.i - 1 >= 0) {
				t = grid[current.i - 1][current.j];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

			}

			if (current.j - 1 >= 0) {
				t = grid[current.i][current.j - 1];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
			}

			if (current.j + 1 < grid[0].length) {
				t = grid[current.i][current.j + 1];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);
			}

			if (current.i + 1 < grid.length) {
				t = grid[current.i + 1][current.j];
				checkAndUpdateCost(current, t, current.finalCost + V_H_COST);

			}
		}
	}

	/**
	 * This method test the valid path for the map
	 * 
	 * @param tCase
	 * @param x
	 * @param y
	 * @param si
	 * @param sj
	 * @param ei
	 * @param ej
	 * @param blocked
	 * @return
	 */
	public static String test(int tCase, int x, int y, int si, int sj, int ei,
			int ej, ArrayList<Dimension> blocked) {
		// Reset
		grid = new Cell[x][y];
		closed = new boolean[x][y];
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Cell c1 = (Cell) o1;
			Cell c2 = (Cell) o2;

			return c1.finalCost < c2.finalCost ? -1
					: c1.finalCost > c2.finalCost ? 1 : 0;
		});
		// Set start position
		setStartCell(si, sj); // Setting to 0,0 by default. Will be useful for
								// the UI part

		// Set End Location
		setEndCell(ei, ej);

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].heuristicCost = Math.abs(i - endI)
						+ Math.abs(j - endJ);
			}
		}
		grid[si][sj].finalCost = 0;

		/*
		 * Set blocked cells. Simply set the cell values to null for blocked
		 * cells.
		 */
		for (Dimension dimension : blocked) {
			setBlocked((int) dimension.getWidth(), (int) dimension.getHeight());
		}

		AStar();

		if (closed[endI][endJ]) {
			// Trace back the path
			System.out.println("inside closed part after astar");
			Cell current = grid[endI][endJ];
			// System.out.print(current);
			while (current.parent != null) {
				mapCell[current.parent.i][current.parent.j]
						.setBackground(Color.BLUE);
				current = current.parent;

			}

			return "";
		} else
			return "NoPath";
	}

	/**
	 * This mehtod is responsible for finding the path for the hostile character
	 * 
	 * @param tCase
	 * @param x
	 * @param y
	 * @param si
	 * @param sj
	 * @param ei
	 * @param ej
	 * @param blocked
	 * @return
	 */
	public static ArrayList<Dimension> hostilePath(int tCase, int x, int y,
			int si, int sj, int ei, int ej, ArrayList<Dimension> blocked) {
		// Reset
		grid = new Cell[x][y];
		closed = new boolean[x][y];
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Cell c1 = (Cell) o1;
			Cell c2 = (Cell) o2;

			return c1.finalCost < c2.finalCost ? -1
					: c1.finalCost > c2.finalCost ? 1 : 0;
		});
		// Set start position
		setStartCell(si, sj); // Setting to 0,0 by default. Will be useful for
								// the UI part

		// Set End Location
		setEndCell(ei, ej);

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].heuristicCost = Math.abs(i - endI)
						+ Math.abs(j - endJ);
			}
		}
		grid[si][sj].finalCost = 0;

		/*
		 * Set blocked cells. Simply set the cell values to null for blocked
		 * cells.
		 */
		for (Dimension dimension : blocked) {
			setBlocked((int) dimension.getWidth(), (int) dimension.getHeight());
		}

		AStar();
		ArrayList<Dimension> path = new ArrayList<Dimension>();
		if (closed[endI][endJ]) {
			// Trace back the path
			Cell current = grid[endI][endJ];
			// System.out.print(current);
			while (current.parent != null) {
				// mapCell[current.parent.i][current.parent.j].setBackground(Color.BLUE);
				current = current.parent;

				path.add(new Dimension(current.i, current.j));

			}
			return path;
		} else
			return path;
	}

	/**
	 * This Method is responsible for finding the path for the computer
	 * 
	 * @param tCase
	 * @param x
	 * @param y
	 * @param si
	 * @param sj
	 * @param ei
	 * @param ej
	 * @param blocked
	 * @return
	 */
	public static ArrayList<Dimension> computerPath(int tCase, int x, int y,
			int si, int sj, int ei, int ej, ArrayList<Dimension> blocked) {
		// Reset
		grid = new Cell[x][y];
		closed = new boolean[x][y];
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Cell c1 = (Cell) o1;
			Cell c2 = (Cell) o2;

			return c1.finalCost < c2.finalCost ? -1
					: c1.finalCost > c2.finalCost ? 1 : 0;
		});
		// Set start position
		setStartCell(si, sj); // Setting to 0,0 by default. Will be useful for
								// the UI part

		// Set End Location
		setEndCell(ei, ej);

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].heuristicCost = Math.abs(i - endI)
						+ Math.abs(j - endJ);
			}
		}
		grid[si][sj].finalCost = 0;

		/*
		 * Set blocked cells. Simply set the cell values to null for blocked
		 * cells.
		 */
		for (Dimension dimension : blocked) {
			setBlocked((int) dimension.getWidth(), (int) dimension.getHeight());
		}

		AStar();
		ArrayList<Dimension> path = new ArrayList<Dimension>();
		if (closed[endI][endJ]) {
			// Trace back the path
			Cell current = grid[endI][endJ];
			// System.out.print(current);
			while (current.parent != null) {
				// mapCell[current.parent.i][current.parent.j].setBackground(Color.BLUE);
				current = current.parent;
				path.add(new Dimension(current.i, current.j));

			}
			return path;
		} else
			return path;
	}

	/**
	 * This method is responsible for finding the path of friendly
	 * 
	 * @param tCase
	 * @param x
	 * @param y
	 * @param si
	 * @param sj
	 * @param ei
	 * @param ej
	 * @param blocked
	 * @return
	 */
	public static ArrayList<Dimension> friendlyPath(int tCase, int x, int y,
			int si, int sj, int ei, int ej, ArrayList<Dimension> blocked) {
		// Reset
		grid = new Cell[x][y];
		closed = new boolean[x][y];
		open = new PriorityQueue<>((Object o1, Object o2) -> {
			Cell c1 = (Cell) o1;
			Cell c2 = (Cell) o2;

			return c1.finalCost < c2.finalCost ? -1
					: c1.finalCost > c2.finalCost ? 1 : 0;
		});
		// Set start position
		setStartCell(si, sj); // Setting to 0,0 by default. Will be useful for
								// the UI part

		// Set End Location
		setEndCell(ei, ej);

		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				grid[i][j] = new Cell(i, j);
				grid[i][j].heuristicCost = Math.abs(i - endI)
						+ Math.abs(j - endJ);
			}
		}
		grid[si][sj].finalCost = 0;

		/*
		 * Set blocked cells. Simply set the cell values to null for blocked
		 * cells.
		 */
		for (Dimension dimension : blocked) {
			setBlocked((int) dimension.getWidth(), (int) dimension.getHeight());
		}

		AStar();
		ArrayList<Dimension> path = new ArrayList<Dimension>();
		if (closed[endI][endJ]) {
			// Trace back the path
			Cell current = grid[endI][endJ];
			// System.out.print(current);
			while (current.parent != null) {
				// mapCell[current.parent.i][current.parent.j].setBackground(Color.BLUE);
				current = current.parent;
				path.add(new Dimension(current.i, current.j));

			}
			return path;
		} else
			return path;
	}
}
