package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/2.
 */
public class ValidAnagram_242 {
    public static boolean isAnagram(String s, String t) {
        final int s_length = s.length();
        final int t_length = t.length();

        if(s_length != t_length) return false;
        if(s_length == 0) return true;

        int[] container = new int[26];
        int ct = 0;
        for(int i = 0; i < s_length; i++){
            final int sIndex = s.charAt(i) - 97;
            final int tIndex = t.charAt(i) - 97;

            container[sIndex] += 1;
            container[tIndex] -= 1;

            if(container[sIndex] == 0){
                ct &= ~(1 << sIndex);
            }else{
                ct |= 1 << sIndex;
            }
            if(container[tIndex] == 0){
                ct &= ~(1 << tIndex);
            }else{
                ct |= 1 << tIndex;
            }
        }

        return ct == 0;
    }
}
