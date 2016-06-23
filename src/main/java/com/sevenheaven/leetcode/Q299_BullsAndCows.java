package com.sevenheaven.leetcode;

import java.util.ArrayList;

public class Q299_BullsAndCows {
    private static ArrayList<Character> secretCache = new ArrayList<Character>();
    private static ArrayList<Character> guessCache = new ArrayList<Character>();
    
    public static String getHint(String secret, String guess) {
        if(secret.length() == guess.length()){
            
            int bull = 0;
            int cow = 0;
            
            for(int i = 0; i < secret.length(); i++){
                char sC = secret.charAt(i);
                char gC = guess.charAt(i);
                
                if(sC == gC){
                    bull++;
                }else{
                    
                    int containsSC = contains(guessCache, sC);
                    int containsGC = contains(secretCache, gC);
                    
                    if(containsSC != -1 || containsGC != -1){
                        
                        if(containsGC != -1){
                            secretCache.remove(containsGC);
                            if(containsSC == -1) secretCache.add(sC);
                            
                            cow++;
                        }
                        
                        if(containsSC != -1){
                            guessCache.remove(containsSC);
                            if(containsGC == -1) guessCache.add(gC);
                            
                            cow++;
                        }
                        
                    }else{
                        if(i != secret.length() - 1){
                            secretCache.add(sC);
                            guessCache.add(gC);
                        }
                    }
                }
            }
            
            return bull + "A" + cow + "B";
        }
        
        return "0A0B";
    }
    
    private static int contains(ArrayList<Character> container, char target){
        
        int result = -1;
        
        for(int i = 0; i < container.size(); i++){
            if(target == container.get(i)){
                result = i;
                break;
            }
        }
        
        return result;
    }
}
