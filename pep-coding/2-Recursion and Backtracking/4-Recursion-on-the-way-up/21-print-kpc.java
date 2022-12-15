import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {
    
    static String codes[] = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printKPC(str, "");

    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized - (n+1)*n
    // Previously we have taken (2^n)*n in FE (faith-expectation) kind of recursion.
    public static void printKPC(String ques, String asf) {
        
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        
        // There are length of codeForCh number of options - each char of the code want to come
        // String codeForCh = codes[ch - 48]; // converting character to integer
        String codeForCh = codes[ch - '0']; // code -> converting character to integer
        for (int i = 0; i < codeForCh.length(); i++) {
            char cc = codeForCh.charAt(i); // collecting char of code
            printKPC(roq, asf + cc); // char want to come with the ans
        }
        
    }

}
