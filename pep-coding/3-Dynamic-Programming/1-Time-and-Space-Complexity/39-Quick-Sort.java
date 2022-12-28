import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  public static void quickSort(int[] arr, int lo, int hi) {
    
    // Strictly greater than hi -> one more label of calls hence little more time consuming.
    // But we made this condition just for submission purpose.
    if (lo > hi) { // it can work only upto here -> (lo >= hi), hence no need blank calls on next label and this is efficient.
        return;
    }
    
    int pivot = arr[hi];
    int partitionIndex = partition(arr, pivot, lo, hi); // last element is pivot
    
    quickSort(arr, lo, partitionIndex - 1); // faith
    quickSort(arr, partitionIndex + 1, hi); // faith
    
    // Expectation will automatically be fulfilled as original array only being modified.
    
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    System.out.println("pivot index -> " + (j - 1));
    return (j - 1);
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    quickSort(arr, 0, arr.length - 1);
    print(arr);
  }

}
