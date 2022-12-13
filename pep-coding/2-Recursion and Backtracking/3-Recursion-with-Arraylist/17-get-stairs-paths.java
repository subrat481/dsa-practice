import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);

    }

    // Solve it by Eular paths diagram
    // Since there are only 3 ways in which we can jump.
    // Jump with 1 step, Jump with 2 step and Jump with 3 steps
    public static ArrayList<String> getStairPaths(int n) {
        
        // base cases
        if (n == 0) {
            // There is 1 way to reach 0 from 0 i.e: blank
            ArrayList<String> bres = new ArrayList<>(); // List of size 1 as there is 1 way
            bres.add(""); // appending blank
            return bres;
        } else if (n < 0) {
            // There is no way to reach 0 from negative / underground
            ArrayList<String> bres = new ArrayList<>(); // List of size 0 as there is no way
            return bres;
        }
        
        ArrayList<String> rpaths1 = getStairPaths(n - 1); // Faith-1 ->> will returns all paths from n-1 to reach 0
        ArrayList<String> rpaths2 = getStairPaths(n - 2); // Faith-1 ->> will returns all paths from n-2 to reach 0
        ArrayList<String> rpaths3 = getStairPaths(n - 3); // Faith-1 ->> will returns all paths from n-3 to reach 0
        
        // Expectation - Create answer list
        ArrayList<String> paths = new ArrayList<>();
        
        // Append 1 on face of each paths returned from n-1 faith result i.e: rpaths1
        // Which will prepare all paths with 1 jump to reach 0
        for (String path: rpaths1) {
            paths.add(1 + path);
        }
        
        // Append 2 on face of each paths returned from n-2 faith result i.e: rpaths2
        // Which will prepare all paths with 2 jumps to reach 0
        for (String path: rpaths2) {
            paths.add(2 + path);
        }
        
        // Append 3 on face of each paths returned from n-3 faith result i.e: rpaths3
        // Which will prepare all paths with 3 jumps to reach 0
        for (String path: rpaths3) {
            paths.add(3 + path);
        }
        
        return paths;
    }

}
