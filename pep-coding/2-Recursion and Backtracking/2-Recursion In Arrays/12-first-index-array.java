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
        
        int x = scn.nextInt();
        System.out.println(firstIndex(arr, 0, x));
    }

    public static int firstIndex(int[] arr, int idx, int x){
        
        if (idx == arr.length) {
            return -1;
        }
        
        // Wrong approach as we are traversing through the entire array
        // int fiisa = firstIndex(arr, idx + 1, x); // faith
        // if (arr[idx] == x) {
        //     return idx;
        // } else {
        //     return fiisa;
        // }
        
        // Correct approach because once we find the ekement then we'll return the index and stop going through the top of the recursion stack.
        if (arr[idx] == x) {
            return idx;
        } else {
            int fiisa = firstIndex(arr, idx + 1, x); // faith
            return fiisa;
        }
        
        
    }

}
