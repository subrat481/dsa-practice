import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next(); // 123
        printEncodings(str, "");

    }
    
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    // 123
    public static void printEncodings(String ques, String asf) {
        
        // base case
        if (ques.length() == 0) {
            System.out.println(asf);
            return;
        }
        
        // first number is zero- then simply return
        if (ques.charAt(0) == '0') {
            return;
        }
        
        // we have 2 options-> call for first number and 2nd call for number of first 2 characters
        String ch0 = ques.substring(0, 1); // "1"
        String roq0 = ques.substring(1); // "23"
        
        // call for first number
        printEncodings(roq0, asf + (char) (Integer.parseInt(ch0) + 'a' - 1));
        
        if (ques.length() >= 2) { // question must have length more than equals to 2
            // Then extracting first 2 characters from ques and convert them into number
            String ch01 = ques.substring(0, 2); // "12"
            String roq01 = ques.substring(2); // "3"
            
            // Call for the number of first 2 characters
            if (Integer.parseInt(ch01) <= 26) { // that number must be some alphabate
                printEncodings(roq01, asf + (char) (Integer.parseInt(ch01) + 'a' - 1));
            }
        }
        
    }

}
