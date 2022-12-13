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
        
        // Expectation - Prepare your answer from faith
        ArrayList<String> paths = new ArrayList<>(); // answer list
        
        // Horizontal moves within dc - sc
        // If you're within the last column/wall
        for (int mv = 1; mv <= dc - sc; mv++) {
            ArrayList<String> hpaths = getMazePaths(sr, sc + mv, dr, dc);
            for (String hpath: hpaths) {
                paths.add("h" + mv + hpath);
            }
        }
        
        // Vertical moves within dr - sr
        // If you're within the last row/wall
        for (int mv = 1; mv <= dr - sr; mv++) {
            ArrayList<String> vpaths = getMazePaths(sr + mv, sc, dr, dc);
            for (String vpath: vpaths) {
                paths.add("v" + mv + vpath);
            }
        }
        
        // Diagonal moves within dc - sc & dr - sr
        // If you're within the last column/wall as well as within the last row/wall
        for (int mv = 1; mv <= dc - sc && mv <= dr - sr; mv++) {
            ArrayList<String> dpaths = getMazePaths(sr + mv, sc + mv, dr, dc);
            for (String dpath: dpaths) {
                paths.add("d" + mv + dpath);
            }
        }
        
        return paths;
    }

}
