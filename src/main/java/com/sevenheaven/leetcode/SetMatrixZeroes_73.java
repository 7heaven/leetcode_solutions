package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class SetMatrixZeroes_73 {
    public static void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        boolean hasZero = false;
        int[] columns = new int[matrix.length];
        int[] rows = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    hasZero = true;
                    rows[j] = 1;
                    columns[i] = 1;
                }
            }
        }

        if(hasZero){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(columns[i] == 1 || rows[j] == 1){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

    }
}
