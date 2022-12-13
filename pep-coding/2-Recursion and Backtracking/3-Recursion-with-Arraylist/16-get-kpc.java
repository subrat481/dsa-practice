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
        ArrayList<String> res = getKPC(str);
        System.out.println(res);

    }

    public static ArrayList<String> getKPC(String str) {
        
        // base case
        if (str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        
        // 678
        char ch = str.charAt(0); // 6
        String ros = str.substring(1); // 78
        ArrayList<String> rres = getKPC(ros); // faith -> [6 combinations/words of 78]
        
        // Meeting the expectation
        ArrayList<String> myres = new ArrayList<>(); // expectation -> [prepare 24 words of 678]
        String codeForCh = codes[ch - '0']; // converting character to integer
        for (int i = 0; i < codeForCh.length(); i++) {
            char chcode = codeForCh.charAt(i);
            for (String rstr: rres) {
                myres.add(chcode + rstr);
            }
        }
        
        return myres;
    }

}
