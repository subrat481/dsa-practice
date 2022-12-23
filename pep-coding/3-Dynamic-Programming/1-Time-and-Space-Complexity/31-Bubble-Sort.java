import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  public static void bubbleSort(int[] arr) {//7,-2,4,1,3
    
    for (int itr = 1; itr <= arr.length; itr++) { // n-1 iterations to sort n items
        for (int j = 0; j < arr.length - itr; j++) {
            if (isSmaller(arr, j + 1, j)) { // comparing whether arr[j+1] element isSmaller than arr[j] element
                swap(arr, j + 1, j); // if yes! let's swap
            }
        }
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    bubbleSort(arr);
    print(arr);
  }

}
