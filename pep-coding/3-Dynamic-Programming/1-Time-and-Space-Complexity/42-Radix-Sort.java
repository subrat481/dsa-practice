import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // Presendence of places in increasing order while sorting -> 1st place < 10th place < 100th place .. and so on so forth
  // While doing higher presedence sorting- preserve the order of its immediate less precedence.
  // Pre-requisite - count sort - as it maintain the stability to preserve the order of elements.
  public static void radixSort(int[] arr) {
      
      // Run the loop till all places digits in maximum value in array are finished
      // Collect the maximum in the array
      int max = Integer.MIN_VALUE; // Integer minimum;
      for (int value: arr) {
          if (value > max) {
              max = value;
          }
      }
      
      // Run the loop
      int exp = 1; // begin with unit place (i.e: exponent = 1)
      while (exp <= max) {
          countSort(arr, exp);
          exp = exp * 10; // sort for unit place, 10th place, 100th place... and so on so forth upto the max place.
      }
      
  }

  public static void countSort(int[] arr, int exp) {
      
      // numbers in the array can be in range of 0 to 9 hence range will be 10
      int min = 0;
      int max = 9;
      int range = max - min + 1; // 10
      
      // make frequency array
      int frequencyArr[] = new int[range];
      for (int i = 0; i < arr.length; i++) {
          // int index = ((arr[i] / exp) % 10) - min; // or int index = arr[i];
          // frequencyArr[index] = frequencyArr[index] + 1; // or frequencyArr[index]++;
          frequencyArr[arr[i] / exp % 10]++;
      }
      
      // convert it into prefix sum array
      for (int i = 1; i < frequencyArr.length; i++) {
          frequencyArr[i] = frequencyArr[i] + frequencyArr[i - 1];
      }
      
      // stable sorting (filling ans array)
      int ans[] = new int[arr.length];
      for (int i = arr.length - 1; i >= 0; i--) {
          // int value = arr[i];
          // int position = frequencyArr[value - min]; // or int position = frequencyArr[value];
          int position = frequencyArr[arr[i] / exp % 10]; // or int position = frequencyArr[arr[i]];
          int index = position - 1;
          
          // ans[index] = value;
          ans[index] = arr[i];
          
          // frequencyArr[value - min]--; // frequencyArr[value]--;
          frequencyArr[arr[i] / exp % 10]--;
      }
      
      // filling original array with the help of ans array
      for (int i = 0; i < arr.length; i++) {
          arr[i] = ans[i];
      }
      
      System.out.print("After sorting on " + exp + " place -> ");
      print(arr);
      
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
    radixSort(arr);
    print(arr);
  }

}
