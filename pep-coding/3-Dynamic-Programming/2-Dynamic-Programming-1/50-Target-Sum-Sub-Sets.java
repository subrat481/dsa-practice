import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();
        
        // System.out.println(tss(arr, 0, target));
        
        // Decide dp size based on how many arguments are varying in recursive calls
        // Boolean[][] dp = new Boolean[n][target + 1]; // 0 to n-1 & 0 to target we're storing
        // System.out.println(tssMem(arr, 0, target, dp));
        
        System.out.println(tssTab(arr, 0, target));

    }
    
    // Without DP - using Recursion
    // Target Sum Sub Sequence
    public static boolean tss(int[] arr, int idx, int target) {
        
        // negative base case
        if (target == 0) {
            return true;
        }
        
        if (target < 0) { // this condition is not required if array elements have some negative
            return false;
        }
        
        // base case
        if (idx == arr.length) {
            return false;
        }
        
        boolean rres1 = tss(arr, idx + 1, target); // Faith - arr[idx] element don't want to come and idx + 1 onwards elements achieve target.
        boolean rres2 = tss(arr, idx + 1, target - arr[idx]); // Faith - arr[idx] element want to come and idx + 1 onwards elements achieve target - arr[idx], as target will be reduced by arr[idx].
        
        boolean ans = rres1 || rres2; // expectation
        return ans;
        
    }
    
    // With DP - Memoization
    // Target Sum Sub Sequence
    public static boolean tssMem(int[] arr, int idx, int target, Boolean[][] dp) {
        
        // negative base case
        if (target == 0) {
            return true;
        }
        
        if (target < 0) { // this condition is not required if array elements have some negative
            return false;
        }
        
        // base case
        if (idx == arr.length) {
            return false;
        }
        
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        
        boolean rres1 = tssMem(arr, idx + 1, target, dp); // Faith - arr[idx] element don't want to come and idx + 1 onwards elements achieve target.
        boolean rres2 = tssMem(arr, idx + 1, target - arr[idx], dp); // Faith - arr[idx] element want to come and idx + 1 onwards elements achieve target - arr[idx], as target will be reduced by arr[idx].
        
        boolean ans = rres1 || rres2; // expectation
        dp[idx][target] = ans; // memoizing
        
        return ans;
        
    }
    
    // With DP - Tabulation
    // Target Sum Sub Sequence
    public static boolean tssTab(int[] arr, int idx, int target) {
        
        Boolean[][] dp = new Boolean[arr.length + 1][target + 1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) { // first row & first column
                    dp[i][j] = true;
                } else if (i == 0) { // first row & rest of the columns
                    dp[i][j] = false;
                } else if (j == 0) { // first column & rest of the rows
                    dp[i][j] = true;
                } else { // rest of the cells in the table
                    if (dp[i - 1][j] == true) { // if arr[i] element don't want to come then all elements upto arr[i - 1] in previous row can make target of j or not
                        dp[i][j] = true;
                    } else if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]] == true) { // if arr[i] element want to come then all elements upto arr[i - 1] in previous row can make target of j - arr[i - 1] or not. And also please ensure j - arr[i - 1] index must be in range.
                        dp[i][j] = true;
                    } else { // else store false
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[arr.length][target]; // return ans from last row last column
        
    }
    
}
