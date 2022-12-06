package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/08/26/16:51
 * @Version: 1.0
 *  O(m + n) 的额外空间
 */
public class LC_73_矩阵置零_方法1 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //用两个一维数组，记录每行每列是否包含0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //二次遍历matrix，若该元素所在行或列，存在有0的，那么该元素置为0
                if (row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
