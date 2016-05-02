package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class ReverseVowelsOfString_345 {

    public static String reverseVowels(String s) {

        char[] resultChar = new char[s.length()];
        int descent_i = resultChar.length - 1;
        int ascent_i = 0;

        char asc_swap = 0;
        int asc_swap_index = -1;
        char desc_swap = 0;
        int desc_swap_index = -1;

        while(ascent_i <= descent_i && ascent_i < resultChar.length && descent_i >= 0){
            char asc_char = s.charAt(ascent_i);
            char desc_char = s.charAt(descent_i);

            if(checkVowel(asc_char)){
                asc_swap = asc_char;
                asc_swap_index = ascent_i;
            }else{
                resultChar[ascent_i] = asc_char;
                ascent_i++;
            }

            if(checkVowel(desc_char)){
                desc_swap = desc_char;
                desc_swap_index = descent_i;
            }else{
                resultChar[descent_i] = desc_char;
                descent_i--;
            }

            if(asc_swap != 0 && desc_swap != 0){
                resultChar[desc_swap_index] = asc_swap;
                resultChar[asc_swap_index] = desc_swap;
                asc_swap = 0;
                desc_swap = 0;
                ascent_i++;
                descent_i--;
            }

        }

        return String.valueOf(resultChar);
    }

    private static boolean checkVowel(char c){
        return c == 97 || c ==  101 || c ==  105 || c ==  111 || c ==  117
                || c == 65 || c == 69 || c == 73 || c == 79 || c == 85;
    }
}
