package hw2;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.introcs.StdRandom;



public class PercolationStats {
    private double[] threshold;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N or T must > 0. ");
        }

        threshold = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation trial = pf.make(N);
            while (!trial.percolates()) {
                int row = StdRandom.uniform(0, N);
                int col = StdRandom.uniform(0, N);
                trial.open(row, col);

            }
            threshold[i] = trial.numberOfOpenSites() / (double) (N * N);



        }

    }

    public double mean() {
        return StdStats.mean(threshold);
    }

    public double stddev() {
        return StdStats.stddev(threshold);
    }

    public double confidenceLow() {
        return (mean() - 1.96 * stddev() / Math.sqrt(threshold.length));
    }

    public double confidenceHigh() {
        return (mean() + 1.96 * stddev() / Math.sqrt(threshold.length));
    }


}

