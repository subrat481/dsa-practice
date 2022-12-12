import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String str = scn.next(); // abc
        ArrayList<String> res = getSubSequence(str);
        System.out.println(res);

    }
    
    // faith -> [--, -c, b-, bc]
    // expectation -> [---, --c, -b-, -bc, a--, a-c, ab-, abc]
    public static ArrayList<String> getSubSequence(String str) {
        
        // base case
        if (str.length() == 0)  {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        char ch = str.charAt(0); // a
        String ros = str.substring(1); // bc
        ArrayList<String> rres = getSubSequence(ros); // faith
        
        // Meeting our expectation from faith
        // Appending absent of a in rres
        ArrayList<String> myres = new ArrayList<>();
        for (String rstr: rres) {
            myres.add("" + rstr);
        }
        
        // Appending presence of a in rres
        for (String rstr: rres) {
            myres.add(ch + rstr);
        }
        
        return myres;
    }

}
