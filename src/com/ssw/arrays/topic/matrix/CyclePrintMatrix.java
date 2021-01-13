package com.ssw.arrays.topic.matrix;

/**
 * 转圈打印矩阵
 * <p>
 * 要求：额外空间复杂度O(1)
 */
public class CyclePrintMatrix {


    public static void cyclePrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }


    /**
     * (tR,tC)是矩阵左上节点，(dR,dC)是数组右下节点
     * <p>
     * 顺时针打印此两个节点围成的矩阵
     */
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) { //表示2个节点在同一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) { //表示两个节点在同一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        cyclePrint(matrix);

    }
}
