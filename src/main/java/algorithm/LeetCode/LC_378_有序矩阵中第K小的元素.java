package algorithm.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *  
 *
 * 提示：
 *
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -109 <= matrix[i][j] <= 109
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 <= k <= n2
 *  
 *
 * 进阶：
 *
 * 你能否用一个恒定的内存(即 O(1) 内存复杂度)来解决这个问题?
 * 你能在 O(n) 的时间复杂度下解决这个问题吗?这个方法对于面试来说可能太超前了，但是你会发现阅读这篇文章（ this paper ）很有趣。
 *
 * --------------------------------------
 * 方法一：小根堆，把所有元素放进小根堆中，结果就是poll()出的第n个。
 * 时间复杂度：O(n^2),n是方形矩阵的边长，因为遍历了二维数组
 */
public class LC_378_有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int res = 0;
        int row = matrix.length,col = matrix[0].length;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;//升序，小根堆
            }
        });
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return  res;
    }
}

/**
 * 方法二：二分查找
 * 1. 找出二维矩阵中最小的数 left，最大的数rright，那么第 k 小的数必定在left ~right 之间。
 * 2. mid =(left + right)/2；在二维矩阵中寻找小于等于 mid 的元素个数 count。  【时间复杂度：O(n)，n是方形矩阵的边长】
 * 3. 若这个count 小于k，表明第 k 小的数在右半部分且不包含mid。调整左边界。
 * 4. 若这个count 大于k，表明第 k 小的数在左半部分且可能包含mid。调整右边界。
 * 5. 因为每次循环中都保证了第 k 小的数在left ~right之间，当left=right 时，第k小的数即被找出。
 * 主意：这里的left mid right是数值，不是索引位置。
 *
 * 时间复杂度：O(nlogn)，n是矩阵的边长
 * 空间复杂度：O(1)
 * */
class LC_378_有序矩阵中第K小的元素_方法二{
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }
}
