package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final boolean[][] grid;

    private final int[] adRow = {-1, 0, 0, 1};

    private final int[] adCol = {0, -1, 1, 0};


    private final WeightedQuickUnionUF id;
    private final int width;
    private int openSite = 0;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N should be positive.");
        }
        width = N;
        grid = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = false;
            }
        }

        id = new WeightedQuickUnionUF(N * N + 2);

    }

    //calculate the site position in the id;
    private int calPosition(int row, int col) {
        return (width * row + col + 2);
    }

    private void openSite(int row, int col) {
        int newRow;
        int newCol;
        for (int i = 0; i < 4; i++) {
            newRow = row + adRow[i];
            newCol = col + adCol[i];
            if (0 <= newRow && newRow < width && 0 <= newCol
                    && newCol < width && isOpen(newRow, newCol)) {
                id.union(calPosition(row, col), calPosition(newRow, newCol));
            }
        }
    }


    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0 || row >= width || col >= width) {
            throw new IndexOutOfBoundsException("Please enter int between 0 and " + width + ".");

        }
        if (!isOpen(row, col)) {
            grid[row][col] = true;
            openSite++;
            openSite(row, col);
            if (row == 0) {
                id.union(0, calPosition(row, col));
            }
            if (row == width - 1  && isFull(row, col)) {
                id.union(1, calPosition(row, col));
            }

        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row >= width || col >= width) {
            throw new IndexOutOfBoundsException("Please enter int between 0 and " + width + ".");

        }
        return grid[row][col];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return id.connected(0, calPosition(row, col));
    }
    public int numberOfOpenSites() {
        return openSite;
    }          // number of open sites
    public boolean percolates() {
        return id.connected(0, 1);
    }          // does the system percolate?
    public static void main(String[] args) {
        Percolation trial = new Percolation(3);

    }   // use for unit testing (not required)
}
