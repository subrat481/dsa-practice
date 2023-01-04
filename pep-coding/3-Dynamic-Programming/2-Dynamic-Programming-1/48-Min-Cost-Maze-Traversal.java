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
        int[][] arr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
        // System.out.println(minCostMaze(arr, 0, 0));
        // System.out.println(minCostMazeMem(arr, 0, 0, new int[n][m]));
        System.out.println(minCostMazeTab(arr, 0, 0));
        
    }
    
    // Without DP - Using Recursion
    // Will give TLE
    public static int minCostMaze(int[][] arr, int sr, int sc) {
        
        // Base case
        if (sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc]; // returning Infinite cost, returning cost from wrong place
        }
        
        // Negative base case
        if (sr >= arr.length || sc >= arr[0].length) {
            return Integer.MAX_VALUE; // returning Infinite cost
        }
        
        int horMinCost = minCostMaze(arr, sr, sc + 1); // faith
        int verMinCost = minCostMaze(arr, sr + 1, sc); // faith
        int totalMinCost = Math.min(horMinCost, verMinCost) + arr[sr][sc]; // expectation
        return totalMinCost;
        
    }
    
    // With DP - using Memoization
    public static int minCostMazeMem(int[][] arr, int sr, int sc, int[][] dp) {
        
        // Base case
        if (sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc]; // returning existing cell cost
        }
        
        // Negative base case
        if (sr >= arr.length || sc >= arr[0].length) {
            return Integer.MAX_VALUE; // returning Infinite cost, returning cost from wrong place
        }
        
        if (dp[sr][sc] != 0) { // questioning
            return dp[sr][sc];
        }
        
        int horMinCost = minCostMazeMem(arr, sr, sc + 1, dp); // faith
        int verMinCost = minCostMazeMem(arr, sr + 1, sc, dp); // faith
        int totalMinCost = Math.min(horMinCost, verMinCost) + arr[sr][sc]; // expectation
        
        dp[sr][sc] = totalMinCost; // Memoizing
        
        return totalMinCost;
        
    }
    
    // With DP - Tabulation
    // Bottom-Up Approach
    public static int minCostMazeTab(int[][] arr, int sr, int sc) {
        
        // 1. Storage & Meaning of each cell in table
        // dp[i][j] -> minimum cost to reach destination starting from [i,j]th cell
        
        int[][] dp = new int[arr.length][arr[0].length];
        
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // Last Row Last Cell
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) { // Last Row
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) { // Last Column
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else { // Rest of the table
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }
        
        return dp[sr][sc];
        
    }

}
