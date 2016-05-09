package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class Q26_RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                nums[index] = nums[i];
                index++;
            }

        }

        return index;
    }
}
