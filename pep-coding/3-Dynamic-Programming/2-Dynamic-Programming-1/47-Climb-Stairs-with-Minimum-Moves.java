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
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        
        // int countMin = countMinMovesTab(arr);
        // int countMin = countMinMoves(arr, 0);
        // int countMin = countMinMovesTab2(arr);
        int countMin = countMinMovesTab3(arr);
        System.out.println(countMin);
        
    }
    
    // Recursion Approach
    public static Integer countMinMoves(int[] arr, int idx) {
        
        if (idx == arr.length) {
            return 0;
        }
        
        if (idx > arr.length) {
            return null;
        }
        
        if (arr[idx] > 0) {
            Integer minMoves = Integer.MAX_VALUE;
            for (int jump = 1; jump <= arr[idx]; jump++) {
                Integer moves = countMinMoves(arr, idx + jump);
                if (moves != null) {
                    minMoves = Math.min(minMoves, moves);    
                }
            }
            
            if (minMoves != Integer.MAX_VALUE) {
                minMoves = minMoves + 1;
            } else {
                minMoves = null;
            }
            return minMoves;
        } else {
            return null;
        }
        
    }
    
    // Video Approach
    // Tabulation - O(n^2) time complexity
    public static Integer countMinMovesTab(int[] arr) {
        
        // Creating table with null as default value
        Integer[] dp = new Integer[arr.length + 1]; // n + 1
        
        // solve smaller problem of recursion
        // filling last index of table
        dp[arr.length] = 0; // there is only 1 path from destination to reach destination & minimum moves = 0
        
        // Filling table from back except last index
        for (int i = dp.length - 2; i >= 0; i--) {
            if (arr[i] > 0) { // arr[i] element must be more than 0
                int min = Integer.MAX_VALUE;
                for (int jump = 1; jump <= arr[i] && i + jump < dp.length; jump++) {
                    if (dp[i + jump] != null) { // dp[i + jump] must be not null so that JVM can compare btw min & dp[i + jump] element
                        min = Math.min(min, dp[i + jump]); // declare min for each next jump   
                    }
                }
                
                // If all the next jump's elements are null only, it means min is still equals to Integer.MAX_VALUE
                // Hence need to update table only if min != Integer.MAX_VALUE otherwise no need to update the table as by default null values are stored already.
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1; // minimum step + 1
                }    
            }
        }
        
        return dp[0]; // if dp[0] is also null - then also we need to return null.
        
    }
    
    // Classroom Approach
    // Tabulation  - O(n^2) time complexity
    public static Integer countMinMovesTab2(int[] arr) {
        
        // Creating table
        // destination is n-1 and it should be printed in question
        int[] dp = new int[arr.length];
        
        // solve smaller problem of recursion
        // filling last index of table
        // there is only 1 path from destination to reach destination & minimum moves = 0
        // dp[arr.length] = 0; // by default 0 only
        
        // Filling table from back except last index
        for (int i = dp.length - 2; i >= 0; i--) {
            
            // Treat it as Infinite value
            // Infinity + 1 = -Infinity
            // Hence Infinity - 1 + 1 = Infinity
            int min = Integer.MAX_VALUE - 1;
            
            for (int jump = 1; jump <= arr[i] && i + jump < dp.length; jump++) {
                min = Math.min(min, dp[i + jump]); // declare min for each next jump 
            }
            
            // if above loop didn't run so adding 1 also will make Infinity only
            dp[i] = min + 1; // minimum step + 1   
        }
        
        return dp[0]; // if dp[0] is also null - then also we need to return null.
        
    }
    
    // Classroom Approach
    // Optimized Approach
    // Tabulation - O(n) time complexity
    public static Integer countMinMovesTab3(int[] arr) {
        
        //  Initializing steps
        int steps = 0;
        
        // Iterating over given array
        for (int i = 0; i < arr.length;) { // don't increase i with i++
            
            if (arr[i] == 0) { // If 1st index element is 0 means there is no way exist
                break;
            }
            
            // Finding out max possible jump
            int max = 0;
            int maxIndex = 0;
            for (int jump = 1; jump <= arr[i]; jump++) {
                int j = i + jump;
                
                // if reached at destination
                if (j == arr.length - 1) {
                    steps++;
                    return steps;
                }
                
                // Updating the max
                if (j + arr[j] >= max) {
                    max = j + arr[j];
                    maxIndex = j;
                }
            }
            
            i = maxIndex; // updating i
            steps++;
            
        }
        
        return Integer.MAX_VALUE; // Infinite steps
        
    }

}
