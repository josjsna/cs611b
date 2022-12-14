package hw2;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    private int T;
    private double[]x;
    public PercolationStats(int N,int T,PercolationFactory pf){
        this.T=T;

        for (int i = 0; i < T; i++) {
            Percolation test=pf.make(N);
            while (!test.percolates()){
                int randomRow=StdRandom.uniform(N);
                int randomCol=StdRandom.uniform(N);
                test.open(randomRow,randomCol);
            }
            x[i]= test.numberOfOpenSites()/(N*N);
        }
    }
    public double mean(){
        return StdStats.mean(x);
    }
    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(x);
    }
    // low endpoint of 95% confidence interval
    public double confidenceLow(){
        return mean()-1.96*stddev()/Math.sqrt(T);
    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh(){
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
