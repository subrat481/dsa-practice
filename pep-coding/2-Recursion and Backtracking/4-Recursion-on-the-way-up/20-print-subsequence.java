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
    
    // Memory Optimized - (n+1)*n
    // Previously we have taken (2^n)*n
    public static void printSS(String ques, String ans) {
        
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        printSS(roq, ans + ch);
        printSS(roq, ans + "");
        
    }

}
