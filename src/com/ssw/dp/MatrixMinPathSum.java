package com.ssw.dp;

/**
 * 求二维数组最小的路径和
 * <p>
 * 问题：给定一个全是正数的二维数组，要求从左上角走到右下角，每次向右或者向下。沿途走过的数字累加起来
 * 求最小的路径和
 */
public class MatrixMinPathSum {

    //递归版本 若二维数组M行N列,时间复杂度 2^(N*M)
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

    public static int getMinPath(int[][] m) {
        return minPath(m, 0, 0);//最终目标
    }

    // TODO: 2021/1/19  记忆化搜索实现动态规划 使用傻缓存保存已经处理过的递归过程，避免重复递归运算  时间复杂度 N*M


    /**
     * 动态规划，构建dp解空间
     */
    public static int minPathByDp(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = m[row - 1][col - 1];

        for (int j = row - 2; j >= 0; j--) {
            dp[j][col - 1] = m[j][col - 1] + dp[j + 1][col - 1];
        }
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = m[row - 1][i] + dp[row - 1][i + 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = m[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(getMinPath(m));
        System.out.println(minPath2(m));
        System.out.println(minPathByDp(m));

    }

    //for test
    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col]; //创建dp解空间
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
