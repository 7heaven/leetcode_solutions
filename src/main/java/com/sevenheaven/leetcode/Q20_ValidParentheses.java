package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/7.
 */
public class Q20_ValidParentheses {
    public static boolean isValid(String s) {
        //栈数组，遇到([{的时候入栈，遇到)]}的时候出栈，需要出栈的时候先判断当前字符是否和上一个字符是一个pair，如果不是直接返回false
        char[] stacks = new char[s.length() + 1];

        //设为1减少下面再做一次数组越界判断
        int stackCursor = 1;
        for(int i = 0; i < stacks.length - 1; i++){
            final char curr = s.charAt(i);
            if(curr == '('){
                stacks[stackCursor++] = ')';
            }else if(curr == '['){
                stacks[stackCursor++] = ']';
            }else if(curr == '{'){
                stacks[stackCursor++] = '}';
            }else if(curr == ')' && stacks[stackCursor - 1] == curr){
                stackCursor--;
            }else if(curr == ']' && stacks[stackCursor - 1] == curr){
                stackCursor--;
            }else if(curr == '}' && stacks[stackCursor - 1] == curr){
                stackCursor--;
            }else{
                return false;
            }
        }

        //栈内为空的时候 返回true
        return stackCursor == 1;
    }
}
