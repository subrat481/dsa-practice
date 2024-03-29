import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printSS(str, "");

    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized - (n+1)*n
    // Previously we have taken (2^n)*n in FE (faith-expectation) kind of recursion.
    public static void printSS(String ques, String ans) {
        
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        // There are only 2 options - first char will come or not come
        printSS(roq, ans + ch); // first char want to come
        printSS(roq, ans + ""); // first char don't want to come
        
    }

}
