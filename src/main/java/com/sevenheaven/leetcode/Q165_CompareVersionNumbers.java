package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/29.
 */
public class Q165_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1Splited = version1.split("\\.");
        String[] v2Splited = version2.split("\\.");

        int count = v1Splited.length > v2Splited.length ? v2Splited.length : v1Splited.length;
        int result = 0;
        for(int i = 0; i < count; i++){

            int vcp = vCompare(v1Splited[i], v2Splited[i]);

            if(vcp != 0){
                result = vcp;
                break;
            }else{
                if(i == count - 1 && v1Splited.length != v2Splited.length){
                    if(v1Splited.length > v2Splited.length){
                        boolean larger = false;
                        for(int j = i + 1; j < v1Splited.length; j++){
                            if(largerThanZero(v1Splited[j])){
                                larger = true;
                                break;
                            }
                        }
                        if(larger) result = 1;
                    }else{
                        boolean larger = false;
                        for(int j = i + 1; j < v2Splited.length; j++){
                            if(largerThanZero(v2Splited[j])){
                                larger = true;
                                break;
                            }
                        }
                        if(larger) result = -1;
                    }
                }
            }
        }

        return result;
    }

    private static boolean largerThanZero(String v){
        final int vLength = v.length();
        if(vLength == 1) return v.charAt(0) > 48;
        if(v.charAt(0) == 45) return false;
        for(int i = vLength - 1; i >= 0; i--)
            if(v.charAt(i) > 48) return true;

        return false;
    }

    private static int vCompare(String v1, String v2){
        final int v1Length = v1.length();
        final int v2Length = v2.length();

        final int length = v1Length > v2Length ? v1Length : v2Length;
        int v1v2cp = v1Length - v2Length;
        int v2v1cp = v2Length - v1Length;

        if(v1v2cp < 0) v1v2cp = 0;
        if(v2v1cp < 0) v2v1cp = 0;


        int result = 0;
        for(int i = 0; i < length; i++){
            char vc1 = (i - v2v1cp) >= 0 ? v1.charAt(i - v2v1cp) : '0';
            char vc2 = (i - v1v2cp) >= 0 ? v2.charAt(i - v1v2cp) : '0';

            if(vc1 > vc2){
                result = 1;
                break;
            }else if(vc2 > vc1){
                result = -1;
                break;
            }
        }

        return result;
    }
}
