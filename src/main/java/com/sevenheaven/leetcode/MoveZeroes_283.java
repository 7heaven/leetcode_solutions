package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/6.
 */
public class MoveZeroes_283 {
    public static void moveZeroes(int[] nums) {
        //记录最后一个零所在的位置
        int lastZeroSub = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(lastZeroSub == -1) lastZeroSub = i;
            }else{
                if(lastZeroSub != -1){
                    //数值交换
                    nums[lastZeroSub] = nums[i];
                    nums[i] = 0;

                    if(i - lastZeroSub > 1){
                        //当前交换的位置和上一个零记录的位置间隔超过1，说明上一个零后面一位也是零
                        lastZeroSub++;
                    }else{
                        //当前位置和上一个零记录间隔不超过1，直接让记录等于当前位置
                        lastZeroSub = i;
                    }
                }
            }
        }
    }
}
