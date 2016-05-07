package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class StringToInteger_8 {
    public static int myAtoi(String str) {
        //长度为零的时候直接返回0
        if(str.length() == 0) return 0;
        int cursor = 0;

        //去除头部的空格
        while(str.charAt(cursor) == ' ') cursor++;
        //判断是否负数
        boolean negative = str.charAt(cursor) == '-';
        //前面有+号或者-号的时候cursor进一
        cursor += negative || str.charAt(cursor) == '+' ? 1 : 0;
        int result = 0;
        final int length = str.length();
        for(; cursor < length; cursor++){
            //取str的当前位并减去'0' 得到实际的数值
            final int single = ((int) str.charAt(cursor)) - '0';
            if(single < 0 || single > 9) break;

            //判断进行下一步操作是否会超出int最大值或者最小值 如果是直接返回最大值或者最小值
            if(result >= 214748364){
                if((single >= 8 || result > 214748364) && negative){
                    return Integer.MIN_VALUE;
                }
                if((single >= 7 || result > 214748364) && !negative){
                    return Integer.MAX_VALUE;
                }
            }

            //result进一位并加上当前的数值
            result *= 10;
            result += single;

        }

        return negative ? ~result + 1 : result;
    }
}
