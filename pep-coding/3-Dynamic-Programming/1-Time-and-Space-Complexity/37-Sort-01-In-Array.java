import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // partitioning in 0's and 1's elements in given array
  public static void sort01(int[] arr) {
    
    // i to end --> unknown elements
    // j to i - 1 --> all elements are euqals to 1
    // 0 to i - 1 --> all elements are euqals to 0
    // 0 is the pivot element by default
    int i = 0;
    int j = 0;
    
    // processing will be continued as long as long there are unknown elements
    while (i < arr.length) {
        if (arr[i] == 1) {
            i++; // decrease the element from unknown region and growth in 1's region automatically.
        } else { // otherwise element euqals to 0 (pivot element by default)
            swap(arr, i, j);
            i++; // decrease the element from unknown region
            j++; // and growth 0's (pivot element) region
        }
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort01(arr);
    print(arr);
  }

}
