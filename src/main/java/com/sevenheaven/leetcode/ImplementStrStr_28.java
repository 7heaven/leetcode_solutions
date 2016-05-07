package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */

public class ImplementStrStr_28 {
    //运行时间8ms,有待优化
    //这个问题最简单的方法就是返回haystack.indexOf(needle),但那样就违背了我们做题的初衷
    public static int strStr(String haystack, String needle) {
        final int hayLength = haystack.length();
        final int needleLength = needle.length();

        if(needleLength == 0) return 0;
        int index =  -1;
        final int remain = hayLength - needleLength;
        if(remain < 0) return -1;

        int needleCursor = 0;
        int recordMatchingStart = -1;
        char needleCurr = needle.charAt(needleCursor);
        //遍历字符串
        for(int i = 0; i < hayLength; i++){
            char hC = haystack.charAt(i);
            if(hC == needleCurr){
                //needle指针加一
                needleCursor++;
                if(needleCursor >= needleLength){
                    //已经匹配到needle字符串的末尾，说明haystack包含needle，
                    //返回当前位置-needle长度所得到的needle在haystack内部起始位置
                    index = i + 1 - needleLength;
                    break;
                }else{
                    //获取needle的下一个字符
                    needleCurr = needle.charAt(needleCursor);

                    //记录第一个匹配到的字符位置，方便字符串没有完全匹配的时候，回到记录的位置+1，再重新匹配字符串
                    if(recordMatchingStart == -1) recordMatchingStart = i;
                }
            }else{
                if(recordMatchingStart != -1){
                    //回到记录的匹配第一个字符的位置
                    i = recordMatchingStart;
                    recordMatchingStart = -1;
                }

                //未能成功匹配的时候，needle指针置零
                needleCursor = 0;
                needleCurr = needle.charAt(0);

            }
        }

        return index;

    }
}
