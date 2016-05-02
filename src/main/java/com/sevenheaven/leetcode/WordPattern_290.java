package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class WordPattern_290 {
    public static boolean wordPattern(String pattern, String str) {

        boolean result = true;

        int[] chars = new int[26];

        String[] words = str.split(" ");
        if(words.length != pattern.length()) return false;

        for(int i = 0; i < words.length; i++){
            int p = pattern.charAt(i) - 97;
            int hash = words[i].hashCode();
            if(chars[p] == 0){
                chars[p] = hash;
                for(int j = 0; j < chars.length; j++){
                    if(chars[j] == hash && j != p){
                        result = false;
                        break;
                    }
                }
            }else if(chars[p] != hash){
                result = false;
                break;
            }
        }

        return result;
    }
}
