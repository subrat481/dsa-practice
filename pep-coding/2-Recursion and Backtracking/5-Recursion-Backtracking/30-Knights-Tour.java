import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        int [][] chess = new int[n][n]; // square matrix
        printKnightsTour(chess, r, c, 1);
        
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        
        // base case (negative base case)
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        }
        
        // base case (positive base case)
        if (upcomingMove == chess.length * chess.length) {
            chess[r][c] = upcomingMove; // we have still not moved so we have to first move
            displayBoard(chess); // then print the path so far
            chess[r][c] = 0; // unreserve the place and explore more paths
            return;
        }
        
        // Total labels are visit each place
        // Total Options are 8 moves
        chess[r][c] = upcomingMove; // moved and reserve the place by move number
        printKnightsTour(chess, r - 2, c + 1, upcomingMove + 1); // top-2, right-1
        printKnightsTour(chess, r - 1, c + 2, upcomingMove + 1); // top-1, right-2
        printKnightsTour(chess, r + 1, c + 2, upcomingMove + 1); // down-1, right-2
        printKnightsTour(chess, r + 2, c + 1, upcomingMove + 1); // down-2, right-1
        printKnightsTour(chess, r + 2, c - 1, upcomingMove + 1); // down-2, left-1
        printKnightsTour(chess, r + 1, c - 2, upcomingMove + 1); // down-1, left-2
        printKnightsTour(chess, r - 1, c - 2, upcomingMove + 1); // top-1, left-2
        printKnightsTour(chess, r - 2, c - 1, upcomingMove + 1); // top-2, left-1
        chess[r][c] = 0; // unmoved and unreserved the place
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
