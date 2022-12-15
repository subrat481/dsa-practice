import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
        
    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        // base case
        // Easy/Simple Base Case
        // No need to worry about (within board condition) cases
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        
        // Horizontal moves within dc - sc
        // If you're within the last column/wall
        // Moved smartly (handled within board condition) in horizontal direction and simple base case
        for (int mv = 1; mv <= dc - sc; mv++) {
            printMazePaths(sr, sc + mv, dr, dc, psf + "h" + mv);
        }
        
        // Vertical moves within dr - sr
        // If you're within the last row/wall
        // Moved smartly (handled within board condition) in vertical direction and simple base case
        for (int mv = 1; mv <= dr - sr; mv++) {
            printMazePaths(sr + mv, sc, dr, dc, psf + "v" + mv);
        }
        
        // Diagonal moves within dc - sc & dr - sr
        // If you're within the last column/wall as well as within the last row/wall
        // Moved smartly (handled within board condition) in diagonal direction and simple base case
        for (int mv = 1; mv <= dc - sc && mv <= dr - sr; mv++) {
            printMazePaths(sr + mv, sc + mv, dr, dc, psf + "d" + mv);
        }
        
    }

}
