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
        System.out.println(lastIndex(arr, 0, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        
        // base case
        if (idx == arr.length)  return -1;
        
        int liisa = lastIndex(arr, idx + 1, x); // faith
        
        if (liisa == -1) { // it means we didn't find li in sub array
            if (arr[idx] == x) { // checking first element is equals to x
                return idx; // then return first element idx
            } else {
                return -1; // else return -1
            }
        } else { // already we got the li in sub array
            return liisa; // hence return same index
        }
    }

}
