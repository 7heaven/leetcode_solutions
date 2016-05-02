package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class ZigZagConvertion_6 {
    public static String convert(String s, int numRows) {
        //创建一个char数组作为返回值的储存，方便修改特定位置的字符
        char[] resultChar = new char[s.length()];

        //cursor用来指示当前指向的字符串s的位置
        int cursor = 0;
        //指示结果数组当前需要填充的位置
        int resultCursor = 0;
        //当前行
        int resultRow = 0;
        //当前行的首字符位于结果数组的下标
        int recordedRowStart = 0;
        //两个纵行之间的间隔字符数
        final int perClip = (numRows - 2 < 0 ? 0 : numRows - 2) + numRows;
        final int length = s.length();

        //resultChar数组内的字符没有填充完的时候保持循环
        while(resultCursor < length){
            if(resultRow == 0){
                //
                cursor = resultCursor * perClip;
            }else if(resultRow == numRows - 1){
                cursor = resultRow + (resultCursor - recordedRowStart) * perClip;
            }else{
                final int posAtRow = resultCursor - recordedRowStart;
                final int revertRow = numRows - 1 - resultRow;

                cursor = (posAtRow & 1) == 0 ? resultRow + (posAtRow >> 1) * perClip : numRows + (revertRow - 1) + ((posAtRow - 1) >> 1) * perClip;
            }

            if(cursor >= length){
                cursor = resultRow + 1;
                recordedRowStart = resultCursor;
                resultRow++;
            }else{
                resultChar[resultCursor] = s.charAt(cursor);
                resultCursor++;
            }
        }

        return String.valueOf(resultChar);
    }
}
