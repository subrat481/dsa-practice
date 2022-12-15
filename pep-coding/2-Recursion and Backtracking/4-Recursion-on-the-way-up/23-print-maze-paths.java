import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
            printMazePaths(1, 1, n, m, "");
            
	    }
        
      // Labels and Options Style Approach
      // This is called as Recursion on the way up
      // Memory Optimized - (n+1)*n
      // Previously we have taken (2^n)*n in FE (faith-expectation) kind of recursion.
	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        
	        // Handle Smartly
	        // Don't go out of the board
	        if (sr > dr || sc > dc) {
	            return; // don't do anything, simply return
	        }
	        
	        // Smart Base case
	        // When we reached rhe destination
	        if (sr == dr && sc == dc) {
	            System.out.println(psf);
	            return;
	        }
	        
	        // There are only 2 options - horizontal and vertical
	        // Call Randomly/Stupidly and Base case smartly
	        printMazePaths(sr, sc + 1, dr, dc, psf + "h"); // Horizontal call
	        printMazePaths(sr + 1, sc, dr, dc, psf + "v"); // Vertical call
	        
	    }

	}
