import java.io.*;
import java.util.*;

public class Main {

  // Here we sort in days, months and years
  // years are having higher precedence followed by months and dates.
  public static void sortDates(String[] arr) {
      
      countSort(arr, 1000000, 100, 32); // sort days; &range = 31 - 0 + 1 = 32
      countSort(arr, 10000, 100, 13); // sort months; &range = 12 - 0 + 1 = 13
      countSort(arr, 1, 10000, 2501); // sort years; &range = 2500 - 0 + 1 = 2501; given in question
      
  }

  // to maintain the relative order or stability
  public static void countSort(String[] arr, int div, int mod, int range) {
    
      // make frequency array
      int frequencyArr[] = new int[range];
      for (int i = 0; i < arr.length; i++) {
          // Integer.parseInt(arr[i], 10) -> to force JVM to convert it into Integer with base 10 instead of Octal to Interger with base 8, specially for dates and months.
          frequencyArr[Integer.parseInt(arr[i], 10) / div % mod]++; // use decimal number system instead of octal number system.
      }
      
      // convert it into prefix sum array
      for (int i = 1; i < frequencyArr.length; i++) {
          frequencyArr[i] += frequencyArr[i - 1];
      }
      
      // stable sorting (filling ans array)
      String ans[] = new String[arr.length]; // answer will be of type String
      for (int i = arr.length - 1; i >= 0; i--) {
          int position = frequencyArr[Integer.parseInt(arr[i], 10) / div % mod];
          int index = position - 1;
          ans[index] = arr[i];
          frequencyArr[Integer.parseInt(arr[i], 10) / div % mod]--;
      }
      
      // filling original array with the help of ans array
      for (int i = 0; i < arr.length; i++) {
          arr[i] = ans[i];
      }
    
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
