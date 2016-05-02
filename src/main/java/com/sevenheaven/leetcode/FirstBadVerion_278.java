package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class FirstBadVerion_278 {

    public static final int MAX_VERSION = 25;

    private static boolean isBadVersion(int v){
        return v == (int) Math.random() * 25;
    }

    public static int firstBadVersion(int n) {
        if(n == 1){
            return n;
        }

        int lastBadFound = -1;
        int start = 0;
        int end = n;
        int current = n >> 1;

        while(end != start){
            if(isBadVersion(current)){
                end = current;
                lastBadFound = current;
            }else{
                start = current;
            }

            current = start + ((end - start) >> 1);
            if(end - start == 1){
                current++;
                start++;
                if(isBadVersion(current)) lastBadFound = current;
            }
        }

        return lastBadFound;
    }
}
