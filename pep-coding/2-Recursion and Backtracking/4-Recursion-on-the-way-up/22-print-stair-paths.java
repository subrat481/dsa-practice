import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");

    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized - (n+1)*n
    // Previously we have taken (2^n)*n in FE (faith-expectation) kind of recursion.
    public static void printStairPaths(int n, String psf) {
        
        // base case
        if (n < 0) {
            return; // There is no way to reach 0 from negative / underground
        }
        
        if (n == 0) {
            System.out.println(psf); // print the path and return
            return;
        }
        
        // There are only 3 options - 1 step, 2 step and 3 step
        printStairPaths(n - 1, psf + "1");
        printStairPaths(n - 2, psf + "2");
        printStairPaths(n - 3, psf + "3");
        
    }

}
