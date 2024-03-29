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
        
        displayArr(arr, 0);
    }

    public static void displayArr(int[] arr, int idx){
        
        if (idx == arr.length) return; // base case
        
        System.out.println(arr[idx]); // faith + expectation
        displayArr(arr, idx + 1); // faith
    }

}
