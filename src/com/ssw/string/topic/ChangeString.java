package com.ssw.string.topic;

/**
 * 字符串的调整与替换
 */
public class ChangeString {

    /**
     * 给定一个字符类型数组chas[],chas[]右半区全是空字符，左半区不含有空字符，现在想将左半区所有的空格全部替换成"%20"
     * 假设chas右半区足够大，可以满足所需要的空间，完成替换函数。
     * <p>
     * 例如： chas左半区看作字符串为"a b  c",替换后变成"a%20b%20%20c"
     * <p>
     * 要求：时间复杂度为O(N),额外空间复杂度为O(1)。
     * <p>
     * 解法：遍历一遍得到两个信息，chas左半区多大，记为len，左半区空格多少记为num;
     */

    public void replace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ') {
                num++;
            }
        }
        int j = len + 2 * num - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (chas[i] != ' ') {
                chas[j--] = chas[i];
            } else {
                chas[j--] = '0';
                chas[j--] = '2';
                chas[j--] = '%';
            }
        }
    }


    /**
     * 补充问题： 给定一个字符类型数组chas[],其中只含有数字字符和*字符。现在需要把所有的挪到chas的左面，数字放在chas的右面
     * <p>
     * 例如： chas看作字符串为"12**345",调整后为"**12345"
     * <p>
     * 要求：时间复杂度为O(N),额外空间复杂度为O(1);不得改变数字字符从左到右的顺序
     * <p>
     * 解：从右往左复制，遇到数字直接复制，遇到*不复制。当把数字字符复制完，把左半区都设置成*。
     */

    public void modify(char chas[]) {
        if (chas == null || chas.length < 2) {
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i >= 0; i++) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for (; j >= 0; j--) {
            chas[j--] = '*';
        }
    }
}
