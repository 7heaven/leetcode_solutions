package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class ReverseVowelsOfString_345 {

    //这一题可以首先忽略所有非元音的字符，然后和344题相同从两头往中间靠拢，并交换字符
    public static String reverseVowels(String s) {

        char[] resultChar = new char[s.length()];
        int descent_i = resultChar.length - 1;
        int ascent_i = 0;

        //用来记录正方向查询的元音字符
        char asc_swap = 0;
        //正向元音字符在字符串的位置
        int asc_swap_index = -1;
        //用来记录反方向查询的元音字符
        char desc_swap = 0;
        //反向元音字符在字符串的位置
        int desc_swap_index = -1;

        while(ascent_i <= descent_i && ascent_i < resultChar.length && descent_i >= 0){
            char asc_char = s.charAt(ascent_i);
            char desc_char = s.charAt(descent_i);

            //查询正方向上的字符是否元音
            if(checkVowel(asc_char)){
                asc_swap = asc_char;
                asc_swap_index = ascent_i;
            }else{
                //不是元音，直接把当前的字符塞入字符数组中
                resultChar[ascent_i] = asc_char;
                ascent_i++;
            }

            //查询反方向上的字符是否元音
            if(checkVowel(desc_char)){
                desc_swap = desc_char;
                desc_swap_index = descent_i;
            }else{
                //不是元音，直接把当前的字符塞入字符数组中
                resultChar[descent_i] = desc_char;
                descent_i--;
            }

            //当记录的两个方向的元音字符都有数据的时候 进行交换，并进入下一个循环
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
