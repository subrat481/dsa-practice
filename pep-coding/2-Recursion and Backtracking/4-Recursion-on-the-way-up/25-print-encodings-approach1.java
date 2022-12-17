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
        } else if (ques.length() == 1) { // print the answer
            char ch = ques.charAt(0); // '1'
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0'; // 1
                char alpha = (char) ('a' + chv - 1); // 'a'
                System.out.println(asf + alpha);
                return;
            }
        }
        
        // we have 2 options-> call for first number and 2nd call for number of first 2 characters
        char ch = ques.charAt(0); // '1'
        String roq = ques.substring(1); // "23"
        
        if (ch == '0') { // first number is zero- then simply return
            return;
        } else {
            // call for first number
            int chv = ch - '0'; // 1
            char alpha = (char) ('a' + chv - 1); // 'a'
            printEncodings(roq, asf + alpha);
        }
        
        // Then extracting first 2 characters from ques and convert them into number
        String ch12 = ques.substring(0, 2); // "12"
        String roq12 = ques.substring(2); // "3"
        
        // Call for the number of first 2 characters
        int ch12v = Integer.parseInt(ch12); // 12
        if (ch12v <= 26) { // that number must be some alphabate
            char alpha12 = (char) ('a' + ch12v - 1); // i <-- corresponding alphabate
            printEncodings(roq12, asf + alpha12);
        }
        
    }

}
