package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/2.
 */
public class ValidAnagram_242 {
    /**
     * 判断String t是否是String s的字母乱序排列结果，
     * 由于仅限定于小写字母，可以使用一个26长度的int数组，并用每个字母-'a'作为下标来存放字母个数
     * s内出现字母对应数组位置+1，t内出现字母对应数组位置-1互相抵消。如果结果整个数组都是零则表示t包含并仅仅包含所有s的字母。
     * 为了避免再多一次的循环判断数组内容，用一个32位的int来存放数组每个位置是否为零
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        final int s_length = s.length();
        final int t_length = t.length();

        if(s_length != t_length) return false;
        if(s_length == 0) return true;

        //用来存放26个小写字母出现的次数
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
