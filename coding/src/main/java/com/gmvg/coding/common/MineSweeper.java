package com.gmvg.coding.common;

import java.util.Arrays;

/*
Sample Data 
	 0 0 0 0 0 0 
	 0 0 0 0 1 0
	 0 0 1 0 1 0

one represent the bomb
*/

public class MineSweeper {

public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        int[][] excpetedOut1 = {{0, 1,-1}, {1, 2, 1},{-1, 1, 0}};
        int response1[][] = mineSweeper(bombs1, 3, 3); //should return:
        //System.out.println(Arrays.deepToString(response));
        System.out.println(Arrays.deepEquals(excpetedOut1, response1));
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        int[][] excpetedOut2 = {{-1, -1, 2, 1}, {2, 3, -1, 1},{0, 1, 1, 1}};
        int response2[][] = mineSweeper(bombs2, 3, 4) ;
        System.out.println(Arrays.deepEquals(excpetedOut2, response2));
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        int[][] excpetedOut3 = {{1, 2, 2, 1, 0}, {1, -1, -1, 2, 0},{1, 3, -1, 2, 0},{0, 1, 2, 2, 1},{0, 0, 1, -1, 1}};
        int response3[][] = mineSweeper(bombs3, 5, 5) ;
        System.out.println(Arrays.deepEquals(excpetedOut3, response3));
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
		for (int row = 0; row< bombs.length; row++) {
            //System.out.println(bombs[row][0] +", " + bombs[row][1]);
            field[bombs[row][0]][bombs[row][1]] = -1;
        }
        for (int row = 0; row< field.length; row++) {
            for (int col = 0 ; col < field[row].length ; col++) {
                if (field[row][col] == -1) continue;

                int count = 0 ;
                if (isMine(field, row, col-1)) count++;
                if (isMine(field, row, col+1)) count++;
                if (isMine(field, row-1, col)) count++;
                if (isMine(field, row+1, col)) count++;
                if (isMine(field, row-1, col-1)) count++;
                if (isMine(field, row-1, col+1)) count++;
                if (isMine(field, row+1, col-1)) count++;
                if (isMine(field, row+1, col+1)) count++;
                field[row][col] = count;
            } 
		}
        return field;
    }

    private static boolean isMine(int[][] field, int row,int col) {
        if ((field.length <= row) || row < 0 || (field[row].length <= col) || col < 0) return false;
        else return (field[row][col] == -1);
    }
} 