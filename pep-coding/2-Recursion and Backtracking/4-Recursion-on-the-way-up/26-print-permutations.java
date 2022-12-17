import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        printPermutations(str, "");

    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    // abc
    public static void printPermutations(String ques, String asf) {
        
        // base case
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        // There are ques length options
        // Each option is of each character and will be appended in the answer
        // Below loop will terminate once question is completed
        for (int spot = 0; spot < ques.length(); spot++) {
            char ch = ques.charAt(spot); // ith character
            String roq = ques.substring(0, spot) + ques.substring(spot + 1); // before that character + rest of string after this character
            printPermutations(roq, asf + ch); // passing rest of question and character will be appended with the answer
        }
        
    }

}
