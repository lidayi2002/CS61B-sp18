package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final byte[] status = {0, 1, 2, 3};
    private final boolean[][] open;

    private final byte[] gridStatus;
    private boolean percolation;

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
        open = new boolean[width][width];
        gridStatus = new byte[width * width];
        for (int i = 0; i < width * width; i++) {
            gridStatus[i] = status[0];
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                open[i][j] = false;
            }
        }

        id = new WeightedQuickUnionUF(width * width);

        percolation = false;

    }

    //calculate the site position in the id;
    private int calPosition(int row, int col) {
        return (width * row + col);
    }

    private void openSite(int row, int col) {
        int newRow;
        int newCol;
        for (int i = 0; i < 4; i++) {
            newRow = row + adRow[i];
            newCol = col + adCol[i];
            if (0 <= newRow && newRow < width && 0 <= newCol
                    && newCol < width && isOpen(newRow, newCol)) {

                byte tmp = (byte) (gridStatus[id.find(calPosition(row, col))]
                        | gridStatus[id.find(calPosition(newRow, newCol))]);
                id.union(calPosition(row, col), calPosition(newRow, newCol));
                gridStatus[id.find(calPosition(row, col))] = tmp;

                if (tmp == status[3]) {
                    percolation = true;
                }


            }
        }
    }


    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0 || row >= width || col >= width) {
            throw new IndexOutOfBoundsException("Please enter int between 0 and " + width + ".");

        }
        if (!isOpen(row, col)) {
            open[row][col] = true;
            openSite++;
            if (width == 1) {
                gridStatus[0] = status[3];
                percolation = true;
                return;
            }
            if (row == 0) {
                gridStatus[calPosition(row, col)] = status[2];
            }
            if (row == width - 1) {
                gridStatus[calPosition(row, col)] = status[1];

            }
            openSite(row, col);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row >= width || col >= width) {
            throw new IndexOutOfBoundsException("Please enter int between 0 and " + width + ".");

        }
        return open[row][col];
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return gridStatus[id.find(calPosition(row, col))] == status[2]
                || gridStatus[id.find(calPosition(row, col))] == status[3];
    }
    public int numberOfOpenSites() {
        return openSite;
    }          // number of open sites
    public boolean percolates() {
        return percolation;
    }          // does the system percolate?
    public static void main(String[] args) {



    }   // use for unit testing (not required)
}
