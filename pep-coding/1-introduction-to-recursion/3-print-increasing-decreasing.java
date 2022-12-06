import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pdi(n);
    }

    public static void pdi(int n){
        if (n == 0) return;
        System.out.println(n); // While going down
        pdi(n - 1);
        System.out.println(n); // While coming up
    }

}
