package algorithm.LeetCode;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * ------------------------------------------
 * 方法一：两次二分查找
 *      由于每行的第一个元素大于前一行的最后一个元素，且每行元素是升序的，所以每行的第一个元素大于前一行的第一个元素，因此矩阵第一列的元素是升序的。
 *      我们可以对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
 * 方法二：一次二分查找
 *      二维数组抽象成一维数组
 *      若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
 */
public class LC_74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length,col = matrix[0].length;
        int lo = 0, hi = row * col - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int midRow = mid / col;//计算mid在第几行，如matrix[3][100]
            int midCol = mid % col;//计算mid在第几列
            if (matrix[midRow][midCol] < target){
                lo = mid + 1;
            }else if (matrix[midRow][midCol] > target){
                hi = mid - 1;
            }else return true;
        }
        return false;
    }
}
