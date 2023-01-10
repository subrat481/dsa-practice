import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] dinominations = new int[n];
        for (int i = 0; i < n; i++) {
            dinominations[i] = scn.nextInt();
        }
        
        int amount = scn.nextInt();
        
        // System.out.println(coinChangeCombination(dinominations, 0, amount));
        // System.out.println(coinChangeCombinationTab(dinominations, amount));
        System.out.println(coinChangeCombinationTab2D(dinominations, amount));
        // System.out.println(coinChangeCombinationMem(dinominations, 0, amount, new int[n + 1][amount + 1]));

    }
    
    public static int coinChangeCombination(int[] dinoms, int idx, int amount) {
        
        // valid base case
        if (amount == 0) {
            return 1;
        }
        
        // negative base case
        if (amount < 0 || idx == dinoms.length) {
            return 0; // then there is no way
        }
        
        int rres1 = coinChangeCombination(dinoms, idx + 1, amount); // element don't want to come
        int rres2 = coinChangeCombination(dinoms, idx, amount - dinoms[idx]); // element want to come
        int ans = rres1 + rres2;
        return ans;
        
    }
    
    // there are 2 things varying hence needed 2D array
    // Try to convert it into 1D array by observing answer is dependent on last row.
    public static int coinChangeCombinationMem(int[] dinoms, int idx, int amount, int[][] dp) {
        
        // valid base case
        if (amount == 0) {
            return 1;
        }
        
        // negative base case
        if (amount < 0 || idx == dinoms.length) {
            return 0; // then there is no way
        }
        
        if (dp[idx][amount] != 0) {
            return dp[idx][amount];
        }
        
        int rres1 = coinChangeCombinationMem(dinoms, idx + 1, amount, dp); // element don't want to come
        int rres2 = coinChangeCombinationMem(dinoms, idx, amount - dinoms[idx], dp); // element want to come
        int ans = rres1 + rres2;
        
        dp[idx][amount] = ans;
        
        return ans;
        
    }
    
    public static int coinChangeCombinationTab2D(int[] dinoms, int amount) {
        
        int[][] dp = new int[dinoms.length + 1][amount + 1];
        
        // First column will be always 1
        // there is always one way to pay zero rupees from any coin.
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j]; // element don't want to come & max profit
                if (j - dinoms[i - 1] >= 0) { // j - dinoms[i - 1] >= 0 <- column must be in range
                    // dp[i][j - dinoms[i - 1]] <- same row and dinoms[i - 1] column back
                    dp[i][j] = dp[i - 1][j] + dp[i][j - dinoms[i - 1]]; // element want to come
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
    
    public static int coinChangeCombinationTab(int[] dinoms, int amount) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1; // there is one way to pay zero rupees from any coin.
        
        for (int coin: dinoms) { // effecting of each coin one-by-one for getting combination
            for (int i = coin; i < dp.length; i++) { // starting from coin onwards
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[amount];
        
    }
    
}
