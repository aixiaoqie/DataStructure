package com.ssw.arrays.topic.matrix;

/**
 * 之 字形打印矩阵
 * <p>
 * 要求:额外空间复杂度O(1)
 */
public class ZigZagPrintMatrix {


    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 按照对角线打印一个斜线上面的节点
     * boolean 表示打印的方向
     */
    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {//右上到左下
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) { //左下到右上
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

}
