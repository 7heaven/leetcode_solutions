package com.sevenheaven.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 7heaven on 16/4/30.
 */
public class FlattenNestedListIterator_341 {

    public interface NestedInteger{
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    public static class NestedIntegerImpl implements NestedInteger{

        private Integer mSingleInteger;
        private List<NestedInteger> mNestedList;

        public NestedIntegerImpl(List<NestedInteger> nestedList){
            mNestedList = nestedList;
        }

        public NestedIntegerImpl(Integer singleInteger){
            mSingleInteger = singleInteger;
        }

        @Override
        public boolean isInteger(){
            return mSingleInteger != null;
        }

        @Override
        public Integer getInteger(){
            return mSingleInteger;
        }

        @Override
        public List<NestedInteger> getList(){
            return mNestedList;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {
        private Integer[] integers;
        private List<Integer> integersList;
        private int cursor;

        public NestedIterator(List<NestedInteger> nestedList) {
            integersList = resolveList(nestedList);
            integers = new Integer[integersList.size()];
            integersList.toArray(integers);
        }

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
