import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        
        if (n == 1) return 1; // base case
        
        int fnm1 = factorial(n - 1); // faith
        int nf = n * fnm1; // expectation
        return nf;
    }

}
