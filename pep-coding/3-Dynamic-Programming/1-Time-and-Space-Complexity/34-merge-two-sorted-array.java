import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
    
    // resultant array
    int res[] = new int[a.length + b.length];
    
    int i = 0;
    int j = 0;
    int k = 0;
    
    // Comparing each elements of both the arrays
    while (i < a.length && j < b.length) {
        if (a[i] < b[j]) {
            res[k] = a[i];
            i++;
        } else {
            res[k] = b[j];
            j++;
        }
        k++;
    }
    
    // If index j reached at the end of array b then
    while (i < a.length) {
        res[k] = a[i];
        i++;
        k++;
    }
    
    // If index i reached at the end of array a then
    while (j < b.length) {
        res[k] = b[j];
        j++;
        k++;
    }
    
    return res; // returning resultant array
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}
