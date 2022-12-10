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
        
        displayArrReverse(arr, 0);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        
        if (idx == arr.length) return; // base case
        
        displayArrReverse(arr, idx + 1); // faith - it will print in reverse order till idx + 1
        System.out.println(arr[idx]); // faith + expectation
        
    }

}
