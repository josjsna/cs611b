package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int N;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF UFwithoutBackWash;
    private int numberOfOpensites;
    public Percolation(int N){
        if(N<=0)
            throw new IllegalArgumentException("N must > 0");
        this.N=N;
        this.numberOfOpensites=0;
        uf=new WeightedQuickUnionUF(N);
        grid=new boolean[N][N];

    }
    public void open(int row,int col){
        int[][] next=new int[][]{
                {0,1},{1,0},{-1,0},{0,-1}
        };
        if(row<0||row>N||col<0||col>N)
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        if(isOpen(row,col)) return;
        grid[row][col]=true;
        numberOfOpensites++;
        //连接周围
        for (int i = 0; i < 3; i++) {
            int mx=row+next[i][0];
            int my=col+next[i][1];
            if(my<0||my>=N){
                continue;
            }
            if(mx==-1){
                uf.union(xyTo1D(row,col),N*N);
                UFwithoutBackWash.union(xyTo1D(row, col),N*N);
                continue;
            }
            else if(mx==N){
                uf.union(xyTo1D(row, col),N*N+1);
                continue;
            }
            if(isOpen(mx,my)&& uf.connected(xyTo1D(mx,my),xyTo1D(row,col))==false){
                uf.union(xyTo1D(mx,my),xyTo1D(row,col));
                UFwithoutBackWash.union(xyTo1D(row, col),xyTo1D(mx,my));
            }

        }

    }
    private int xyTo1D(int mx,int my){
        return mx*N+my;
    }
    public boolean isOpen(int row,int col){
        if(row<0||row>N||col<0||col>N)
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        return grid[row][col];
    }
    public boolean isFull(int row,int col){
        if(row<0||row>N||col<0||col>N)
            throw new IndexOutOfBoundsException("row and col must between 0 and N-1");
        return UFwithoutBackWash.connected(xyTo1D(row, col), N * N);
    }
    public int numberOfOpenSites(){
        return numberOfOpensites;
    }
    // does the system percolate?
    public boolean percolates(){
        //
        return uf.connected(N*N,N*N+1);
    }
    // use for unit testing (not required)
    public static void main(String[] args){

    }

}
