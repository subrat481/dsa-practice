import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

  // We'll generally use count sort when values are more but range is small
  // i.e: Sorting marks of the students - # students are more but marks range is small
  public static void countSort(int[] arr, int min, int max) {
      
      int range = max - min + 1;
      
      // Prepare frequency array by filling frequencies of each elements in original array.
      // Iterate over the original array once and fill frequency array
      int frequencyArr[] = new int[range];
      for (int i = 0; i < arr.length; i++) {
          int index = arr[i] - min;
          frequencyArr[index] = frequencyArr[index] + 1; // or frequencyArr[index]++;
          // frequencyArr[index]++;
      }
      
      // Converting frequency array into Prefix Sum array to maintain stability or relative ordering of elements (stable sorting)
      // To hold the position of each element in original array
      // Iterate over the frequencyArr once and convert into prefix sum array
      for (int i = 1; i < frequencyArr.length; i++) {
          // store the position by adding the frequency of previous index frequency.
          frequencyArr[i] = frequencyArr[i] + frequencyArr[i - 1]; // But remember - we have position stored in prefix sum array hence we need to convert position into index (position - 1) when using it.
      }
      
      // Prepare the answer (sorted array)
      // Iterate over original array again from back
      int ans[] = new int[arr.length];
      for (int i = arr.length - 1; i >= 0; i--) {
          int value = arr[i]; // pick the element from original array
          int position = frequencyArr[value - min]; // collecting corresponding position from prefix sum array
          int index = position - 1; // converting position to answer array index
          ans[index] = value; // store the value in answer array to its position
          
          frequencyArr[value - min]--; // decreasing the position
          // frequencyArr[position]--; // that's wrong! think about it.
      }
      
      // Converting original array into answer array
      // Iterate over the original array
      for (int i = 0; i < arr.length; i++) {
          arr[i] = ans[i];
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
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
