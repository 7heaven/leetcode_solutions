package com.sevenheaven.leetcode;

import java.util.List;

/**
 * Created by 7heaven on 16/5/10.
 */
public class Q281_ZigzagIterator {
    public static class ZigzagIterator {

        private int minSize;
        private int totalSize;
        private int cursor = 0;

        private List<Integer> max;
        private List<Integer> v1;
        private List<Integer> v2;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            minSize = v1.size() > v2.size() ? v2.size() : v1.size();
            totalSize = v1.size() + v2.size();
            max = v1.size() > v2.size() ? v1 : v2;
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            int i = cursor;
            cursor++;
            //判断奇偶数
            if((i & 0x1) == 0){
                return i >= minSize << 1 ? max.get(i - minSize) : v1.get(i >> 1);
            }else{
                return i >= minSize << 1 ? max.get(i - minSize) : v2.get((i - 1) >> 1);
            }
        }

        public boolean hasNext() {
            return cursor < totalSize;
        }
    }
}
