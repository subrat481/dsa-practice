import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    // To understand zig-zag
    // we must draw eular diagram
    public static void pzz(int n){
        
        if (n == 0) {
            return;
        }
        
        // Before Recursion call
        // Pre-Area
        System.out.print(n + " ");
        pzz(n - 1); // first recursive call or left call
        
        // After first recursive call
        // In-Area
        System.out.print(n + " ");
        pzz(n - 1); // 2nd recursive call or right call
        
        // After second recursive call
        // Post-Area
        System.out.print(n + " ");
        
    }

}
