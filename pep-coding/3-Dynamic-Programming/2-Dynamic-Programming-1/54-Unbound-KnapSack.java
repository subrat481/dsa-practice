import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }
        
        int[] weights = new int[n];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        System.out.println(unboundKnapsackTab(prices, weights, cap));

    }
    
    public static int unboundKnapsackTab(int[] prices, int[] weights, int cap) {
        
        int[] dp = new int[cap + 1];
        // we know that 0 price, 0 weight -> 0 max profit
        
        // Coin Change Combination logic - you can apply even permutaiton logic also.
        for (int i = 0; i < prices.length; i++) {
            int itemPrice = prices[i];
            int itemWeight = weights[i];
            for (int j = itemWeight; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], itemPrice + dp[j - itemWeight]);
            }
        }
        
        return dp[cap];
        
    }
}
