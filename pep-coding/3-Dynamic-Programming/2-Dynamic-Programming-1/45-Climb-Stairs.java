import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        // int cp = countPaths(n); // using normal recursion without dp
        // int cp = countPathsMem(n, new int[n + 1]); // using dp with memoization
        int cp = countPathsTab(n); // using dp with tabulation
        System.out.println(cp);
        
    }
    
    // Without DP
    public static int countPaths(int n) {
        
        // base case
        if (n == 0) { // if n = 0 then you're at ground hence don't move, stand there
            return 1;
        } else if (n < 0) { // if you're at basement then there is no path exist
            return 0;
        }
        
        // System.out.println("Hello " + n); // <--try this
        int nm1_paths = countPaths(n - 1);
        int nm2_paths = countPaths(n - 2);
        int nm3_paths = countPaths(n - 3);
        
        int total_paths = nm1_paths + nm2_paths + nm3_paths;
        
        return total_paths;
        
    }
    
    // With DP -> Memoization Approach
    // qb - question bank
    public static int countPathsMem(int n, int[] qb) {
        
        // base case
        if (n == 0) { // if n = 0 then you're at ground hence don't move, stand there
            return 1;
        } else if (n < 0) { // if you're at basement then there is no path exist
            return 0;
        }
        
        // another base case
        if (qb[n] > 0) { // (qb[n] != 0) <- we can use this condition also
            return qb[n];
        }
        
        // System.out.println("Hello " + n); // <--try this
        int nm1_paths = countPathsMem(n - 1, qb);
        int nm2_paths = countPathsMem(n - 2, qb);
        int nm3_paths = countPathsMem(n - 3, qb);
        
        int total_paths = nm1_paths + nm2_paths + nm3_paths;
        qb[n] = total_paths; // storing total paths in qb or memoizing
        
        return total_paths;
        
    }
    
    // With DP -> Tabulation Approach
    // Tabulation approach - ultimately we are filling only question bank table
    // Hence we try to fill question bank only and avoid recursive call
    // 1. Storage & Meaning of each cell in table
    // 2. Direction of Problem (small to large or large to small)
    // 3. Traverse and solve the problem in the identified direction.
    // Only Iteration needed
    public static int countPathsTab(int n) {
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        
        return dp[n];
        
    }

}
