package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.NestedInteger;

import java.util.List;

/**
 * Created by 7heaven on 16/5/10.
 */
public class Q339_NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;

        return getSum(nestedList, 1);
    }

    //递归，每次调用getSum都把weight+ 1
    private int getSum(List<NestedInteger> nestedList, int weight){
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++){
            NestedInteger integer = nestedList.get(i);
            if(integer.isInteger()){
                sum += integer.getInteger() * weight;
            }else{
                sum += getSum(integer.getList(), weight + 1);
            }
        }

        return sum;
    }
}
