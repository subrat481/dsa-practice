import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        
        // base case -> return a new array of size found so far - fsf
        if (idx == arr.length)  return new int[fsf];
        
        if (arr[idx] == x) { // Chceking if element is present
            int iarr[] = allIndices(arr, x, idx + 1, fsf + 1); // increase index & fsf both
            iarr[fsf] = idx; // while returning in recursion-> fill newly created array and return
            return iarr;
        } else {
            int iarr[] = allIndices(arr, x, idx + 1, fsf); // increase only index
            return iarr; // while returning in recursion-> simply return newly created array
        }
        
        // While going on top of recursion stack we will count the size of the array
        // While reaching on top- create a new array of count size and return.
        // While coming down- fill that array and return.
    }

}
