import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // partitioning in 3 regions 0's region, 1's region & 2's region
  public static void sort012(int[] arr){
    
    // i to k --> unknown elements region
    // 0 to j - 1 --> 0's elements region
    // j to i - 1 --> 1's elements region
    // k + 1 to end -> 2's elements region
    
    int i = 0;
    int j = 0;
    int k = arr.length - 1;
    
    // Processing will be continued as long as there are any unknown elements
    while (i <= k) { // if i didn't cross k yet
        if (arr[i] == 0) {
            swap(arr, i, j); // swap the i element with jth index element
            i++; // decrease the element from unknown region
            j++; // and growth in 0's elements region
            // Here we can increase i (i++) as we are sure that jth element was 1
        } else if (arr[i] == 1) {
            i++; // increase in 1's elements region and decrease in unkwon elements region automatically
        } else {
            swap(arr, i, k); // swap the i element with kth index element
            k--; // increase 2's elements region
            // Also we can't increase i (i++) because we are not sure that what come from kth index & it could be 0 also.
            // And decrease k (k--) because we are sure that ith element was 2
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
    sort012(arr);
    print(arr);
  }

}
