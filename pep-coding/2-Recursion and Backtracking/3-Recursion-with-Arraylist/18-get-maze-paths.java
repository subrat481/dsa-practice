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
        ArrayList<String> paths = getMazePaths(1, 1, n, m);
        System.out.println(paths);

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    // Draw the Maze/Board along with corresponding Eular diagram.
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        
        // base case
        if (sr == dr && sc == dc) {
            ArrayList<String> bres = new ArrayList<>(); // there is 1 way to move to dr, dc from dr, dc
            bres.add(""); // stay there don't move, means blank
            return bres;
        }
        
        // Handeling out of maze condition
        // If you're within the last column/wall
        ArrayList<String> hpaths = new ArrayList<>();
        if (sc < dc) {
            hpaths = getMazePaths(sr, sc + 1, dr, dc); // horizontal move
        }
        
        // If you're within the last row/wall
        ArrayList<String> vpaths = new ArrayList<>();
        if (sr < dr) {
            vpaths = getMazePaths(sr + 1, sc, dr, dc); // vertical move
        }
        
        // ArrayList<String> hpaths = getMazePaths(sr, sc + 1, dr, dc); // horizontal move
        // ArrayList<String> vpaths = getMazePaths(sr + 1, sc, dr, dc); // vertical move
        
        // Expectation - Prepare your answer from faith
        ArrayList<String> paths = new ArrayList<>(); // answer list
        // Appending 'h' in front of all paths for horizontal move
        for (String hpath: hpaths) {
            paths.add("h" + hpath);
        }
        
        // Appending 'v' in front of all paths for vertical move
        for (String vpath: vpaths) {
            paths.add("v" + vpath);
        }
        
        return paths;
    }

}
