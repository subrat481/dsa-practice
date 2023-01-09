import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // # items
        
        int[] itemPrices = new int[n]; // prices
        for (int i = 0; i < itemPrices.length; i++) {
            itemPrices[i] = scn.nextInt();
        }
        
        int[] itemWeights = new int[n]; // normal arr
        for (int i = 0; i < itemWeights.length; i++) {
            itemWeights[i] = scn.nextInt();
        }
        
        int capacity = scn.nextInt(); // maximum weights or capacity of the bag.
        
        // System.out.println(knapSack01Tab(itemWeights, itemPrices, capacity));
        // System.out.println(knapSack01(0, itemWeights, itemPrices, capacity));
        System.out.println(knapSack01Mem(0, itemWeights, itemPrices, capacity, new int[n + 1][capacity + 1]));
        
    }
    
    public static int knapSack01(int idx, int[] weights, int[] prices, int capacity) {
        
        if (capacity < 0) {
            return Integer.MIN_VALUE;
        }
        
        if (idx == prices.length) {
            return 0;
        }
        
        int rres1 = 0 + knapSack01(idx + 1, weights, prices, capacity); // current element don't want to come, max profit upto previous elements.
        int rres2 = prices[idx] + knapSack01(idx + 1, weights, prices, capacity - weights[idx]); // element want to come, max profit upto previous elements and price of the current element
        int ans = Math.max(rres1, rres2);
        return ans;
        
    }
    
    public static int knapSack01Mem(int idx, int[] weights, int[] prices, int capacity, int[][] dp) {
        
        if (capacity < 0) {
            return Integer.MIN_VALUE;
        }
        
        if (idx == prices.length) {
            return 0;
        }
        
        if (dp[idx][capacity] != 0) {
            
        }
        
        int rres1 = 0 + knapSack01Mem(idx + 1, weights, prices, capacity, dp); // current element don't want to come, max profit upto previous elements.
        int rres2 = prices[idx] + knapSack01Mem(idx + 1, weights, prices, capacity - weights[idx], dp); // element want to come, max profit upto previous elements and price of the current element
        int ans = Math.max(rres1, rres2);
        
        dp[idx][capacity] = ans; // memoizing
        
        return ans;
        
    }
    
    public static int knapSack01Tab(int[] weights, int[] prices, int capacity) {
        
        int[][] dp = new int[weights.length + 1][capacity + 1]; // items + 1 & cap + 1
        // By Default
        // dp first row ->> no item means 0 capacity -> 0 profit
        // dp first col ->> any items & no capacity means -> 0 profit
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                
                dp[i][j] = dp[i - 1][j]; // element don't want to come & max profit
                if (j - weights[i - 1] >= 0) { // j - weights[i - 1] >= 0 must be in range
                
                    // element want to come & max profit 
                    // prices[i - 1] -> price of the current element
                    // dp[i - 1][j - weights[i - 1]] -> max price using previous elements with updated capacity
                    dp[i][j] = Math.max(dp[i][j], prices[i - 1] + dp[i - 1][j - weights[i - 1]]); // element want to come
                }
                
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
}
