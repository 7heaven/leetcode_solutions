package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/9.
 */
public class Q243_ShortestWordDistance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0) return 0;
        int recordedStart = -1;
        int recordedStartHash = -1;
        int hash1 = word1.hashCode();
        int hash2 = word2.hashCode();
        int latestDistance = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            int hash = words[i].hashCode();
            if(hash == hash1 || hash == hash2){
                if(recordedStart == -1){
                    recordedStart = i;
                    recordedStartHash = hash;
                }else{
                    if(hash == recordedStartHash){
                        recordedStart = i;
                    }else{
                        int distance = i - recordedStart;
                        if(latestDistance > distance){
                            latestDistance = distance;

                        }

                        recordedStartHash = hash;
                        recordedStart = i;
                    }
                }
            }
        }

        return latestDistance;
    }
}
