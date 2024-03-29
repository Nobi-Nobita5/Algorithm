package algorithm.LeetCode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * -----------------------------------
 * 方法一：n次二分查找  时间复杂度:O(logN)
 * ------------------------
 * 方法二：利用行列都升序的特点，移动边界x、y   时间复杂度:O(m+n)
 */
public class LC_240_搜索二维矩阵II {
    //方法二，移动边界
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;//从矩阵的左下角开始找
        while (x < matrix.length && y >= 0){
            if (matrix[x][y] > target){//如果当前元素大于target，说明要减小当前元素，那就y--。
                y--;
            }else if (matrix[x][y] < target){//如果当前元素小于target，说明要增大当前元素，那就x++。
                x++;
            }else {
                return true;
            }
        }
        return false;
    }
}
