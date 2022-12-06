package algorithm.LeetCode;

/**
 * @Author: Xionghx
 * @Date: 2022/08/26/16:54
 * @Version: 1.0
 * 思路和算法：O(1) 的额外空间
 *
 * 我们可以用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1) 的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含0。
 * 因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含0。
 *
 * 在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。
 *
 */
public class LC_73_矩阵置零_方法2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false,flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                flagCol0 = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0){
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;//二维数组中间有0的，第一行第一列对应元素会被置为0
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    //二维数组中间没有0的，第一行第一列对应元素有0的，对应的列也会被置为0，因为判断条件的下标是从0开始的
                    //所以不用担心如{{1,0,1},{1,1,1},{1,1,1}}这种情况
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
