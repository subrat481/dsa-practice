import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  public static void insertionSort(int[] arr) {
    
    // Insert the ith element into already sorted array using reverse bubbling
    for (int i = 1; i < arr.length; i++) { // let's assume that arr[0] is already sorted at beginning
        // reverse bubbling
        for (int j = i - 1; j >= 0; j--) { // going into sorted array from back to front completely if necessary
            if (isGreater(arr, j, j + 1)) { // bubbling - comparing whether arr[j] element isGreater than arr[j + 1] element
                swap(arr, j, j + 1); // if yes! let's swap
            } else {
                break; // otherwise no need to go further into sorted array as all elements are already sorted before jth element
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

  // return true if jth element is greater than ith element
  public static boolean isGreater(int[] arr, int j, int i) {
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
    insertionSort(arr);
    print(arr);
  }

}
