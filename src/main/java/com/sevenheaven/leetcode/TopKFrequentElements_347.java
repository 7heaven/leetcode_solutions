package com.sevenheaven.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 7heaven on 16/5/5.
 */
public class TopKFrequentElements_347 {
    //leetcode上运行时间355ms 有待优化
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Integer[] pInCKeys = new Integer[nums.length];
        int[] pInCValues = new int[nums.length];
        int kvCursor = 0;
        for(int i = 0; i < nums.length; i++){
            int kvInCount = -1;
            for(int j = 0; j <= kvCursor; j++){
                if(pInCKeys[j] != null && pInCKeys[j] == nums[i]){
                    pInCValues[j]++;
                    kvInCount = 1;
                    while(j > 0 && pInCValues[j] > pInCValues[j - 1]){
                        int temp = pInCValues[j];
                        int tempKey = pInCKeys[j];

                        pInCValues[j] = pInCValues[j - 1];
                        pInCValues[j - 1] = temp;

                        pInCKeys[j] = pInCKeys[j - 1];
                        pInCKeys[j - 1] = tempKey;

                        j--;
                    }
                    break;
                }
            }

            if(kvInCount == -1){
                pInCKeys[kvCursor] = nums[i];
                pInCValues[kvCursor] = 1;
                kvCursor++;
            }else{
                pInCValues[kvCursor]++;
            }
        }

        return Arrays.asList(Arrays.copyOf(pInCKeys, k));
    }
}
