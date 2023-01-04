import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mine = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mine[i][j] = scn.nextInt();
            }
        }
        
        // System.out.println(goldMine(mine, 0, 0)); // We can't fix this line as starting call is varying.
        // We need to collect max gold collected by each element in first column
        // And find out which element collected maximum gold and print
        int max = 0;
        for (int row = 0; row < mine.length; row++) {
            // max = Math.max(max, goldMine(mine, row, 0)); // [0,0], [1,0], [2,0], [3,0], [4,0] .. so on
            max = Math.max(max, goldMineMem(mine, row, 0, new int[n][m]));
        }
        System.out.println(max);
        
        // System.out.println(goldMineTab(mine));
        
    }
    
    // Without DP - using Recursion
    // Time Limit Exceed (Exception)
    public static int goldMine(int[][] mine, int sr, int sc) {
        
        // Remember - Please put negative base case first
        // negative base case
        // row
        if (sr < 0 || sr >= mine.length) {
            return Integer.MIN_VALUE;
        }
        
        // base case
        if (sc == mine[0].length - 1) { // reached destination
            return mine[sr][sc];
        }
        
        int gold1 = goldMine(mine, sr - 1, sc + 1); // faith -> up right -> row - 1, col + 1
        int gold2 = goldMine(mine, sr, sc + 1); // faith -> same row, col + 1
        int gold3 = goldMine(mine, sr + 1, sc + 1); // faith -> down right -> row + 1, col + 1
        int maxGold = mine[sr][sc] + Math.max(gold1, Math.max(gold2, gold3)); // expectation
        
        return maxGold;
        
    }
    
    // With DP - Memoization
    public static int goldMineMem(int[][] mine, int sr, int sc, int[][] dp) {
        
        // Remember - Please put negative base case first
        // negative base case
        // row
        if (sr < 0 || sr >= mine.length) {
            return Integer.MIN_VALUE;
        }
        
        // base case
        if (sc == mine[0].length - 1) { // reached destination
            return mine[sr][sc];
        }
        
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        
        int gold1 = goldMineMem(mine, sr - 1, sc + 1, dp); // faith -> up right -> row - 1, col + 1
        int gold2 = goldMineMem(mine, sr, sc + 1, dp); // faith -> same row, col + 1
        int gold3 = goldMineMem(mine, sr + 1, sc + 1, dp); // faith -> down right -> row + 1, col + 1
        int maxGold = mine[sr][sc] + Math.max(gold1, Math.max(gold2, gold3)); // expectation
        
        dp[sr][sc] = maxGold;
        
        return maxGold;
        
    }
    
    // With DP - Tabulation
    // Bottom-Up Approach
    public static int goldMineTab(int[][] mine) {
        
        // 1. Storage & Meaning of each cell in table
        // dp[i][j] -> maximum amount of gold collected if we start digging from [i,j] to last colomn.
        
        int[][] dp = new int[mine.length][mine[0].length];
        
        for (int col = mine[0].length - 1; col >= 0; col--) {
            for (int row = mine.length - 1; row >= 0; row--) { // row down to up or up to down doesn't matter
                // Last column
                if (col == mine[0].length - 1) {
                    dp[row][col] = mine[row][col]; // as it is
                } else if (row == 0) { // first row
                    dp[row][col] = mine[row][col] + Math.max(dp[row][col + 1], dp[row + 1][col + 1]);
                } else if (row == mine.length - 1) { // last row
                    dp[row][col] = mine[row][col] + Math.max(dp[row][col + 1], dp[row - 1][col + 1]);
                } else { // rest of the cells in table
                    dp[row][col] = mine[row][col] + Math.max(dp[row][col + 1], Math.max(dp[row + 1][col + 1], dp[row - 1][col + 1]));
                }
            }
        }
        
        // Return the max in first col or destination col
        int max = dp[0][0];
        for (int row = 1; row < dp.length; row++) {
            if (dp[row][0] > max) {
                max = dp[row][0];
            }
        }
        
        return max;
        
    }

}
