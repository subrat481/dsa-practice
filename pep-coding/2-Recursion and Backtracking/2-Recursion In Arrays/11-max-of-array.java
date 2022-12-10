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
        System.out.println(maxOfArray(arr, 0));
    }

    public static int maxOfArray(int[] arr, int idx){
        
        if (idx == arr.length - 1)  return arr[idx]; // base case-> recursion will go upto last idx and return that element as it is the max at last index.
        
        int mif = maxOfArray(arr, idx + 1); // faith- it will give the max till idx + 1
        
        return arr[idx] > mif ? arr[idx] : mif; // meet faith with expectation -> compare faith max with first idx and return
        
    }

}
