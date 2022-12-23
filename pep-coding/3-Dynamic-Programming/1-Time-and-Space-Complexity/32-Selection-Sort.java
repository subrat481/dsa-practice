import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // Placing minimum to the correct position
  public static void selectionSort(int[] arr) {
    
    // Placing minimum to the correct position in each outer iteration
    for (int i = 0; i < arr.length - 1; i++) { // n-1 iterations to sort n items
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (isSmaller(arr, j, minIndex)) { // comparing whether arr[j] element isSmaller than arr[minIndex] element
                minIndex = j; // if yes! then declare jth index as minIndex
            }
        }
        swap(arr, i, minIndex); // sattlement at the end
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
    selectionSort(arr);
    print(arr);
  }

}
