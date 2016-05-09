package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class Q1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        //简单的两次循环遍历查找
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
