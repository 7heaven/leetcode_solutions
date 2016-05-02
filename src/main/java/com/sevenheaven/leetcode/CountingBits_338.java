package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class CountingBits_338 {
    private static final long m1 = 0x5555555555555555L;
    private static final long m2 = 0x3333333333333333L;
    private static final long m4 = 0x0f0f0f0f0f0f0f0fL;
    private static final long m8 = 0x00ff00ff00ff00ffL;
    private static final long m16 = 0x0000ffff0000ffffL;
    private static final long m32 = 0x00000000ffffffffL;
    private static final long hff = 0xffffffffffffffffL;
    private static final long h01 = 0x0101010101010101L;

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++){
            result[i] = (int) popCount((long) i);
        }

        return result;
    }

    private static long popCount(long x){
        x -= (x >> 1) & m1;
        x = (x & m2) + ((x >> 2) & m2);
        x = (x + (x >> 4)) & m4;
        return (x * h01) >> 56;
    }
}
