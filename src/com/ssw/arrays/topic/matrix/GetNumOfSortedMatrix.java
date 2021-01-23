package com.ssw.arrays.topic.matrix;

/**
 * 在行列都排好序的矩阵中找数
 * <p>
 * 要求：时间复杂度O(N+M),额外空间复杂度O(1).
 * <p>
 * 从右上角开始往左下查找
 */
public class GetNumOfSortedMatrix {

    public static boolean getNum(int[][] matrix, int k) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == k) {
                return true;
            } else if (matrix[row][col] > k) {
                col--;
            } else {
                row++;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println(getNum(matrix, 11));
    }
}
