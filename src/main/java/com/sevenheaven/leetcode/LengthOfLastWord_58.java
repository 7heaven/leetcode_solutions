package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class LengthOfLastWord_58 {
    public static int lengthOfLastWord(String s) {
        int cursor = s.length() - 1;
        if(cursor < 0) return 0;
        char curr = s.charAt(cursor);
        while(curr == ' ' && cursor > 0) curr = s.charAt(--cursor);
        int count = 0;
        while(curr != ' '){
            count++;
            if(cursor > 0){
                curr = s.charAt(--cursor);
            }else{
                break;
            }
        }

        return count;
    }
}
