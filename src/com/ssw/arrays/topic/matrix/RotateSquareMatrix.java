package com.ssw.arrays.topic.matrix;

/**
 * 旋转正方形矩阵
 * <p>
 * 题目：给定一个正方形矩阵，将其旋转90度
 * <p>
 * 要求：额外空间复杂度O(1)
 */
public class RotateSquareMatrix {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 将正方形矩阵中每个节点旋转90度
     */
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        for (int i = 0; i < times; i++) {
            int tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }

    }

}
