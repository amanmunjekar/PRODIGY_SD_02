public class SodokuSolver {
    
	
	    public static void main(String[] args) {
	        int[][] sudokuGrid = {
	            {5, 3, 0, 0, 7, 0, 0, 0, 0},
	            {6, 0, 0, 1, 9, 5, 0, 0, 0},
	            {0, 9, 8, 0, 0, 0, 0, 6, 0},
	            {8, 0, 0, 0, 6, 0, 0, 0, 3},
	            {4, 0, 0, 8, 0, 3, 0, 0, 1},
	            {7, 0, 0, 0, 2, 0, 0, 0, 6},
	            {0, 6, 0, 0, 0, 0, 2, 8, 0},
	            {0, 0, 0, 4, 1, 9, 0, 0, 5},
	            {0, 0, 0, 0, 8, 0, 0, 7, 9}
	        };

	        if (solveSudoku(sudokuGrid)) {
	            System.out.println("Sudoku puzzle solved successfully:");
	            printSudoku(sudokuGrid);
	        } else {
	            System.out.println("No solution exists for the given Sudoku puzzle.");
	        }
	    }

	    public static boolean solveSudoku(int[][] grid) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                if (grid[row][col] == 0) {
	                    for (int num = 1; num <= 9; num++) {
	                        if (isValidMove(grid, row, col, num)) {
	                            grid[row][col] = num;
	                            if (solveSudoku(grid)) {
	                                return true;
	                            } else {
	                                grid[row][col] = 0;
	                            }
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    public static boolean isValidMove(int[][] grid, int row, int col, int num) {
	        for (int i = 0; i < 9; i++) {
	            if (grid[row][i] == num || grid[i][col] == num || grid[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void printSudoku(int[][] grid) {
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                System.out.print(grid[row][col] + " ");
	            }
	            System.out.println();
	        }
	    }
	}




    

