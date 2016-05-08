package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class RangeSumQueryImmutable_303 {
    /**
     * 由于sumRange会大量调用，可以在构造函数内生成一个二维table的方式来储存所有i-j的结果，
     * 二维table的方式在leetcode submit solution的时候由于给的数组过大导致内存不足
     */
    public static class NumArray{
        private int[] results;

        public NumArray(int[] nums) {
            results = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++){
                results[i + 1] = results[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return results[j + 1] - results[i];
        }
    }
}
