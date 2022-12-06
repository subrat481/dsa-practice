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
        System.out.println(power(x, n));
    }

    public static int power(int x, int n){
        if (n == 0) return 1; // base case
        int xpnm1 = power(x, n - 1); // faith
        int xpn = x * xpnm1; // expectation
        return xpn;
    }

}
