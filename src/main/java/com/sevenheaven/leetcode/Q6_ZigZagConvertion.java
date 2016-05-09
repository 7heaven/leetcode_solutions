package com.sevenheaven.leetcode;

/**
 * Created by 7heaven on 16/4/30.
 */
public class Q6_ZigZagConvertion {
    /**
     * 这个是一个比较有意思的问题，刚开始没有看懂规律的话，可以用runcode配合不同的参数看正确结果来得出
     * pattern如下:
     *
     * 对于一个字符串 比如 "abcdefghijklmnopqrstuvwxyz", numRows=5 按照一下方式排列：
     *
     * a   i   q   y
     * b  hj  pr  xz
     * c g k o s w
     * df  ln  tv
     * e   m   u
     *
     * 然后按照上面的排列逐行把字符放入结果字符串中，变成"aiqybhjprxzcgkoswdflntvemu"
     *
     * 斜向排列的字母次序是和纵向相反的，所以对字符串进行拆解的时候，需要关注两种情况，一种是纵向的排列，一种是斜向的排列
     * 再，斜向的排列仅出现在首行和末行以外的地方，所以需要把首行和末行也做单独处理，拆分如下：
     *
     * a|   |i|   |q|   |y
     * -------------------
     * b|  h|j|  p|r|  x|z
     * c| g |k| o |s| w |
     * d|f  |l|n  |t|v  |
     * -------------------
     * e|   |m|   |u|   |
     *
     * @param s
     * @param numRows
     * @return
     */
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
            //处理首行的情况
            if(resultRow == 0){
                //首行就是单纯的用cursor相对于当前行的位置乘以两个纵行之间的间隔
                cursor = resultCursor * perClip;
            }else if(resultRow == numRows - 1){
                //末行和首行相同，只是不能直接用cursor来乘，必须减去行的第一个字符在result数组中的位置
                cursor = resultRow + (resultCursor - recordedRowStart) * perClip;
            }else{
                final int posAtRow = resultCursor - recordedRowStart;
                final int revertRow = numRows - 1 - resultRow;

                //处理中间部分的状况，分为奇数行和偶数行，奇数行就是纵向排列的字符，偶数行就是斜向排列的字符
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
