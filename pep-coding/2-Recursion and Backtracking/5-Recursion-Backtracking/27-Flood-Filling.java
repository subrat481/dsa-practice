import java.io.*;
import java.util.*;

/** 
@author: Subrat Kumar
**/
public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        
        boolean visited[][] = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }
    
    // asf -> answer so far
    // Labels and Options Style Approach
    // This is called as Recursion on the way up
    // Memory Optimized
    public static void floodfill(int[][] maze, int row, int col, String asf, boolean visited[][]) {
        
        // base case (negative base case)
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || 
                maze[row][col] == 1 || visited[row][col] == true) {
            return;
        }
        
        // Once we reached at destination (positive base case)
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(asf);
            return;
        }
        
        // There are total 4 options (top, left, down, right)
        
        visited[row][col] = true; // mark as visited to avoid StackOverFlow
        
        floodfill(maze, row - 1, col, asf + "t", visited); // top
        floodfill(maze, row, col - 1, asf + "l", visited); // left
        floodfill(maze, row + 1, col, asf + "d", visited); // down
        floodfill(maze, row, col + 1, asf + "r", visited); // right
        
        visited[row][col] = false; // mark as unvisited to print all the paths
    
    }
}
