import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        
        // System.out.println(countPathsWIthVarJump(arr, 0));
        // System.out.println(countPathsWIthVarJumpMem(arr, 0, new int[n + 1]));
        System.out.println(countPathsWIthVarJumpTab(arr));
        
    }
    
    // Only recursion- no DP
    public static int countPathsWIthVarJump(int[] arr, int idx) {
        
        // base case
        if (idx == arr.length) { // if reached the destination
            return 1; // then there is only 1 path, just stay there
        }
        
        if (idx > arr.length) { // if you reach outside the board
            return 0; // there won't be any path
        }
        
        // Left to Right (destination = arr.length)
        // Total paths
        int paths = 0;
        for (int jump = 1; jump <= arr[idx]; jump++) { // jump upto arr[idx]
            int jumpPaths = countPathsWIthVarJump(arr, idx + jump);
            paths += jumpPaths;
        }
        
        return paths;
        
    }
    
    // DP -> with Memoization
    // Top-Down Approach
    public static int countPathsWIthVarJumpMem(int[] arr, int idx, int[] qb) {
        
        // base case
        if (idx == arr.length) { // if reached the destination
            return 1; // then there is only 1 path, just stay there
        }
        
        if (idx > arr.length) { // if you reach outside the board
            return 0; // there won't be any path
        }
        
        // another base case to check in question bank
        if (qb[idx] != 0) {
            return qb[idx]; // return the answer
        }
        
        // Left to Right (destination = arr.length)
        // Total paths
        int paths = 0;
        for (int jump = 1; jump <= arr[idx]; jump++) { // jump upto arr[idx]
            int jumpPaths = countPathsWIthVarJumpMem(arr, idx + jump, qb);
            paths += jumpPaths;
        }
        
        // before returning
        qb[idx] = paths; // storing or memoizing the recently calculated answer
        
        return paths;
        
    }
    
    // DP -> with Tabulation
    // Tabulation approach - ultimately we are filling only question bank table
    // Hence we try to fill question bank only and avoid recursive call
    // 1. Storage & Meaning of each cell in table
    // 2. Direction of Problem (small to large or large to small <- check the base case of recursion)
    // 3. Traverse and solve the problem in the identified direction.
    // Only Iteration needed
    // Recursion base case always be the smallest problem hence fill it first in table.
    public static int countPathsWIthVarJumpTab(int[] arr) {
        
        // Creating table
        int[] dp = new int[arr.length + 1];
        
        // solve smaller problem of recursion
        // filling last index of table
        dp[arr.length] = 1; // there is only 1 path from destination to reach destination
        
        // Filling table from back except last index
        for (int i = dp.length - 2; i >= 0; i--) { 
            for (int jump = 1; jump <= arr[i]; jump++) { // try this-> (jump <= arr[i] && i + jump < dp.length)
                if (i + jump < dp.length) { // so that jump must be in the range of dp
                    dp[i] += dp[i + jump];
                }
            }
        }
        
        return dp[0]; // since we return paths from 0'th index
        
    }

}
