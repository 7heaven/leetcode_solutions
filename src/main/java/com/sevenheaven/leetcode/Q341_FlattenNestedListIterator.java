package com.sevenheaven.leetcode;

import com.sevenheaven.leetcode.associate.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 7heaven on 16/4/30.
 */
public class Q341_FlattenNestedListIterator {

    public static class NestedIterator implements Iterator<Integer> {
        private Integer[] integers;
        private List<Integer> integersList;
        private int cursor;

        public NestedIterator(List<NestedInteger> nestedList) {
            integersList = resolveList(nestedList);
            integers = new Integer[integersList.size()];
            integersList.toArray(integers);
        }

        //降维操作，把所有的数值合并到一个大的数组中
        private List<Integer> resolveList(List<NestedInteger> nestedList){
            List<Integer> resultList = new ArrayList<Integer>();
            for(int i = 0; i < nestedList.size(); i++){
                NestedInteger intg = nestedList.get(i);
                if(intg.isInteger()){
                    resultList.add(intg.getInteger());
                }else{
                    resultList.addAll(resolveList(intg.getList()));
                }
            }

            return resultList;
        }

        @Override
        public Integer next() {
            return integers[cursor++];
        }

        @Override
        public boolean hasNext() {
            return integers.length > cursor;
        }
    }
}
