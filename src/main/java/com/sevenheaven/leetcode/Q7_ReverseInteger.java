package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/9.
 */
public class Q7_ReverseInteger {
    public static int reverse(int x) {
        boolean negative = x < 0;
        long result = 0;
        if(negative) x = -x;

        while(x > 0){
            final int lastDigit = getLast(x);
            x = divideTen(x);
            result *= 10;
            result += lastDigit;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;

        return negative ? (int) -result : (int) result;
    }

    //除10
    static int divideTen(int number){
        long invDivisor = 0x1999999AL;
        return (int) ((invDivisor * number) >> 32);
    }

    //取int的最后一位 （Hacker's Delight)
    static int getLast(int number){
        if(number >= (1 << 16)){
            int q = (int) ((0x51EB851FL * number) >>> 37);
            int r = number - 100 * q;

            number = r;

            q = (0xCCCD * number) >>> 19;
            r = number - 10 * q;


            return r;
        }else{
            int q = (0xCCCD * number) >>> 19;
            int r = number - 10 * q;

            return r;
        }

    }
}
