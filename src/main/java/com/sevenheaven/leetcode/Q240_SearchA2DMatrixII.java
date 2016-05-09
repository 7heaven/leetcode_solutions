package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/4.
 */
public class Q240_SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int[] row = matrix[i];
            if(target >= row[0] && target <= row[row.length - 1]){
                if(target == row[0] || target == row[row.length - 1]) return true;
                int start = 0;
                int end = row.length - 1;
                int current = row.length >> 1;
                while(start != end){
                    if(target == row[current]) return true;
                    if(target > row[current]){
                        start = current;
                    }else{
                        end = current;
                    }

                    current = start + ((end - start) >> 1);
                    if(current == start){
                        if(target == row[start] || target == row[end]){
                            return true;
                        }else{
                            if(i == matrix.length - 1) return false;
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }
}
