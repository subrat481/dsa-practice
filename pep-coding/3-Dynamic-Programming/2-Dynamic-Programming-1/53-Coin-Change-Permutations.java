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
        
        // System.out.println(coinChangePermutation(dinominations, amount)); // TLE
        // System.out.println(coinChangePermutationMem(dinominations, amount, new int[amount + 1]));
        System.out.println(coinChangePermutationMem2(dinominations, amount, new Integer[amount + 1]));
        // System.out.println(coinChangePermutationTab(dinominations, amount));
        
    }
    
    public static int coinChangePermutation(int[] dinoms, int amount) {
        
        if (amount == 0) {
            return 1;
        }
        
        if (amount < 0) {
            return 0;
        }
        
        // Explore all the choices for permutations instead of element wants to come or not as it denots combinations.
        int ways = 0;
        for (int dinom: dinoms) {
            ways += coinChangePermutation(dinoms, amount - dinom);
        }
        
        return ways;
    }
    
    public static int coinChangePermutationMem(int[] dinoms, int amount, int[] dp) {
        
        if (amount == 0) {
            return 1;
        }
        
        if (amount < 0) {
            return 0;
        }
        
        if (dp[amount] != 0) {
            return dp[amount];
        }
        
        // Explore all the choices for permutations instead of element wants to come or not as it denots combinations.
        int ways = 0;
        for (int dinom: dinoms) {
            ways += coinChangePermutationMem(dinoms, amount - dinom, dp);
        }
        
        dp[amount] = ways;
        
        return ways;
    }
    
    public static int coinChangePermutationMem2(int[] dinoms, int amount, Integer[] dp) {
        
        if (amount == 0) {
            return 1;
        }
        
        if (amount < 0) {
            return 0;
        }
        
        // to avoid extra calls if answer is zero, hence changed to null
        if (dp[amount] != null) {
            return dp[amount];
        }
        
        // Explore all the choices for permutations instead of element wants to come or not as it denots combinations.
        int ways = 0;
        for (int dinom: dinoms) {
            ways += coinChangePermutationMem2(dinoms, amount - dinom, dp);
        }
        
        dp[amount] = ways;
        
        return ways;
    }
    
    public static int coinChangePermutationTab(int[] dinoms, int amount) {
        
        int[] dp = new int[amount + 1];
        dp[0] = 1; // there is one way to pay zero rupees from any coin.
        
        // reversed the loops to get permutation from combinations
        // ensuring permutations
        for (int i = 1; i < dp.length; i++) { // starting from each amount
            for (int coin: dinoms) { // effecting of each coin at a time for getting permutation of each spot
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];    
                }
            }
        }
        
        return dp[amount];
        
    }
    
}
