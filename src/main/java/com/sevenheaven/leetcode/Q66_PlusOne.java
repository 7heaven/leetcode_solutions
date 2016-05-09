package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class Q66_PlusOne {
    public static int[] plusOne(int[] digits) {
        //当最高位也需要进一的时候，需要一个digits.length + 1的数组来存放
        int[] backup = new int[digits.length + 1];
        //判断当前是否需要进一位，初始值为true，因为最低位的时候需要加1
        boolean exceed = true;
        int plus = 0;

        //从最低位往最高位遍历
        for(int i = digits.length - 1; i >= 0; i--){
            //当前位置的数值，exceed==true的时候表示低一位超过了10
            plus = exceed ? digits[i] + 1 : digits[i];
            exceed = plus >= 10;
            digits[i] = exceed ? plus - 10 : plus;
            backup[i + 1] = digits[i];

            //不需要再进一位的时候，直接返回修改后的digits数组
            if(!exceed) return digits;

        }

        //遍历到最高位依然需要再进一位的时候，返回backup
        backup[0] = 1;
        return backup;
    }
}
