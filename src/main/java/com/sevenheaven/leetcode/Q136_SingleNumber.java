package com.sevenheaven.leetcode;

public class Q136_SingleNumber {

    public static int singleNumber(int[] nums) {
        if(nums.length == 0) return 0;
        boolean[] checked = new boolean[nums.length];
        int ascStart = 0;
        int descStart = nums.length - 1;
        while(ascStart != descStart){
            if(checked[ascStart]){
                ascStart++;
                continue;
            }
            boolean match = false;
            for(int i = ascStart + 1; i <= descStart; i++){
                if(nums[ascStart] == nums[i]){
                    match = true;
                    checked[ascStart] = true;
                    checked[i] = true;
                    break;
                }
            }
            
            if(match){
                ascStart++;
            }else{
                break;
            }
        }
        
        return nums[ascStart];
    }

}
