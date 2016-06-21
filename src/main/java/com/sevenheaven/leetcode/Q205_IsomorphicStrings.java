package com.sevenheaven.leetcode;

public class Q205_IsomorphicStrings{
    public static boolean isIsomorphic(String s, String t) {
        int size = s.length();
        char[] sChars = new char[size];
        char[] tChars = new char[size];
        
        boolean result = true;
        int iChars = 0;
        int sizeChars = 0;
        for(int i = 0; i < size; i++){
            boolean charExists = false;
            for(int j = 0; j < sizeChars; j++){
                if(sChars[j] == s.charAt(i)){
                    charExists = true;
                    if(tChars[j] != t.charAt(i)){
                        result = false;
                    }
                    
                    break;
                }
                
                if(tChars[j] == t.charAt(i)){
                    charExists = true;
                    if(sChars[j] != s.charAt(i)){
                        result = false;
                    }
                    
                    break;
                }
            }
            
            if(!result) break;
            
            if(!charExists){
                sChars[iChars] = s.charAt(i);
                tChars[iChars] = t.charAt(i);
                iChars++;
                sizeChars++;
            }
        }
        
        return result;
    }
}
