import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // partitioning logic - basic algorithm
  // we can solve many questions using this (segregating <= pivot, > pivot, even-odd, 0-1, 0-non-zero etc)
  // dividing elements into mainly 2 regions
  // greater than pivot element region
  // less than or equals to pivot element region
  public static void partition(int[] arr, int pivot) {
    
    // 0 to j - 1 --> <= pivot (less than or equals to pivot element region)
    // j to i - 1 --> > pivot (greater than pivot eleement region)
    // i to end --> unknown (unknown region)
    
    int i = 0;
    int j = 0;
    
    while (i < arr.length) {
        if (arr[i] > pivot) { // if ith element is greater than pivot element
        
            i++; // decrease the element from unknown region and growth in greater region automatically
            
        } else { // otherwise element either lesser or equals to pivot element
        
            // swap the smaller or equal element with first bigger element in greater region
            // hence growth in smaller region with swapped small element
            // and greater region still remain same but shifted with recently swapped bigger element at the right
            
            swap(arr, i, j); // swap the element with jth index element
            i++; // decrease the element from unknown region
            j++; // and growth in less than or equals to pivot element region
            
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
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}
