package com.ssw.dp;

/**
 * 求二维数组最小的路径和
 * <p>
 * 问题：给定一个全是正数的二维数组，要求从左上角走到右下角，每次向右或者向下。沿途走过的数字累加起来
 * 求最小的路径和
 */
public class MatrixMinPathSum {

    //递归版本
    public static int minPath(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + minPath(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPath(matrix, i + 1, j);
        }
        int right = minPath(matrix, i, j + 1);//右边位置到 右下角的最短
        int down = minPath(matrix, i + 1, j);//下面位置到 右下角的最短
        return matrix[i][j] + Math.min(right, down);
    }
}
