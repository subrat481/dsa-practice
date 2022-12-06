import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xn = power(x, n);
        System.out.println(xn);
    }

    public static int power(int x, int n){
        
        // Base case
        if (n == 0) return 1;
        
        int xpn2 = power(x, n / 2); // faith
        int xpn = xpn2 * xpn2; // expectation
        
        // Handling odd power
        if (n % 2 != 0) xpn = x * xpn;
        
        return xpn;
    }

}
