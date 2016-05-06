package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/5.
 */
public class Candy_135 {

    //submission运行时间15ms，远低于average level，有待优化
    public static int candy(int[] ratings) {
        boolean needSort = true;
        final int[] candies = new int[ratings.length];
        int totalCandies = 0;

        for(int i = 0; i < ratings.length; i++) candies[i] = 1;

        while(needSort){
            needSort = false;
            for(int i = 1; i < ratings.length; i++){
                if(ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]){
                    candies[i] = candies[i - 1] + 1;
                }
            }

            for(int i = ratings.length - 2; i >= 0; i--){
                if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]){
                    candies[i] = candies[i + 1] + 1;
                }

                if(i != 0 && !needSort){
                    final int offsetForward = ratings[i] - ratings[i + 1];
                    final int offsetBackward = ratings[i] - ratings[i - 1];
                    final int candyForward = candies[i] - candies[i + 1];
                    final int candyBackward = candies[i] - candies[i - 1];

                    if(offsetForward != 0){
                        if(getFirst(candyForward) != getFirst(offsetForward)) needSort = true;
                    }

                    if(offsetBackward != 0 && !needSort){
                        if(getFirst(candyBackward) != getFirst(offsetBackward)) needSort = true;
                    }
                }
            }
        }

        for(int i = 0; i < candies.length; i++) totalCandies += candies[i];

        return totalCandies;
    }

    public static int getFirst(int integer){
        return integer != 0 ? integer > 0 ? 1 : -1 : 0;
    }
}
