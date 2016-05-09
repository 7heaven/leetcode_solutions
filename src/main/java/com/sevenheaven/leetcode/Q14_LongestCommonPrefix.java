package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class Q14_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length == 0) return result;
        int currIndex = 0;
        char preChar = 0;
        while(true){

            for(int i = 0; i < strs.length; i++){
                final String str = strs[i];
                if(str != null && str.length() > currIndex){
                    if(preChar == 0){
                        preChar = str.charAt(currIndex);
                    }else{
                        if(preChar != str.charAt(currIndex)){
                            return result;
                        }
                    }
                }else{
                    return result;
                }
            }


            result += preChar;

            currIndex++;
            preChar = 0;
        }
    }
}
