import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main{

public static void main(String[] args) throws Exception {
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // int dp[] = new int[n + 1]; // last index of array is n hence length would be n + 1
    // System.out.println(fibMemoization(n, dp));
    
    System.out.println(fibTabulation(n));
 }
 
 // DP -> Optimization over Recursion
 // DP -> Recursion + Repeated calls (Overlapping sub-problems)
 // Memoization approach
 public static int fibMemoization(int n, int[] ques) {
     
     // base case
     if (n == 0 || n == 1) {
         return n;
     }
     
     // another base case to check in question bank
     if (ques[n] != 0) {
         return ques[n];
     }
     
     int nm1 = fibMemoization(n - 1, ques); // faith
     int nm2 = fibMemoization(n - 2, ques); // faith
     int fn = nm1 + nm2; // expectation
     ques[n] = fn; // storing the result in question bank before returning or memoizing
     
     return fn;
     
 }
 
 // Tabulation approach - ultimately we are filling only question bank table
 // Tabulation approach - ultimately we are filling only question bank table
 // Hence we try to fill question bank only and avoid recursive call
 // 1. Storage & Meaning of each cell in table
 // 2. Direction of Problem (small to large or large to small <- check the base case of recursion)
 // 3. Traverse and solve the problem in the identified direction.
 // Only Iteration needed
 // Recursion base case always be the smallest problem hence fill it first in table.
 public static int fibTabulation(int n) {
     
     int[] dp = new int[n + 1]; // creating table
     
     for (int i = 0; i <= n; i++) {
         if (i == 0 || i == 1) { // we know already
             dp[i] = i;
         } else {
             dp[i] = dp[i - 1] + dp[i - 2]; // last 2 index elements sum
         }
     }
     
     return dp[n]; // return nth fibonacci
     
 }

}
