package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/5/8.
 */
public class SimplifyPath_71 {
    public static String simplifyPath(String path) {
        String[] splitedPath = path.split("/");
        String[] resultPath = new String[splitedPath.length];
        int resultCursor = 0;
        for(int i = 0; i < splitedPath.length; i++){
            String folder = splitedPath[i];
            if(folder.equals(".") || folder.length() == 0){
                continue;
            }else if(folder.equals("..")){
                if(--resultCursor < 0) resultCursor = 0;
            }else{
                resultPath[resultCursor++] = folder;
            }
        }

        String result = "/";
        for(int i = 0; i < resultCursor; i++){
            result += resultPath[i] + (i < resultCursor - 1 ? "/" : "");
        }

        return result;
    }
}
