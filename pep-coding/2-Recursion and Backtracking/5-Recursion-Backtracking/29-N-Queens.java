import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int chess[][] = new int[n][n];
        printNQueens(chess, "", 0);
        
    }
    
    // qsf is queen so far
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    
    // Generally function you'll find the labels
    // Options are the calls that you made inside the function
    public static void printNQueens(int[][] chess, String qsf, int row) {
        
        if (row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        
        // There are # col are the total options
        // And # row are the lables
        for (int col = 0; col < chess.length; col++) { // chess is square so col < chess.length
            if (queenIsSafe(chess, row, col)) { // If queen is safe then place the queen
                chess[row][col] = 1; // placing queen
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0; // removing queen    
            }
        }
        
    }
    
    // We need to check all previous rows -> vertically, diagonally left and diagonally right
    // Queen should not be present in above location hence new placed queen is safe
    // No need to check in same row as we haven't placed any queen so far
    // No need to check below the row as we haven't placed any queen so far
    public static boolean queenIsSafe(int chess[][], int row, int col) {
        
        // All previous rows vertically
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        // All previous rows diagonally left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        // All previous rows diagonally right
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1) {
                return false;
            }
        }
        
        return true;
        
    }
}
