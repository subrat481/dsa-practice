import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        
        int tar = scn.nextInt();
        printTargetSumSubsets(arr, 0, "", 0, tar);

    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        
        // Once we reached at end (positive base case)
        if (idx == arr.length) {
            // Print only subset whose sum is target
            if (sos == tar) {
                System.out.println(set + ".");
            }
            return;
        }
        
        // Stop wasting time
        if (sos > tar) {
            return;
        }
        
        // There are 2 options
        // element (arr[idx]) want to become the part of sos
        // element (arr[idx]) don't want to become the part of sos
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
        
    }

}
