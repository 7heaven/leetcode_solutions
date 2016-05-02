package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class ReverseString_344 {
    public static String reverseString(String s) {
        char[] result = new char[s.length()];
        int ascIndex = 0;
        int descIndex = result.length - 1;
        while(ascIndex <= descIndex){
            result[ascIndex] = s.charAt(descIndex);
            result[descIndex] = s.charAt(ascIndex);

            ascIndex++;
            descIndex--;
        }

        return String.valueOf(result);
    }
}
