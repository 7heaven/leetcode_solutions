package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class IntegerBreak_343 {
    public static int integerBreak(int n) {
        if(n < 3){
            return 1;
        }else if(n == 3){
            return 2;
        }else if(n == 4){
            return 4;
        }

        n = n - 3;
        int result = 3;

        while(n > 0){
            n = n - 3;
            if(n > 1){
                result *= 3;
            }else if(n > 0){
                result *= 4;
                n = 0;
            }else{
                result *= n + 3;
                n = 0;
            }
        }

        return result;
    }
}
