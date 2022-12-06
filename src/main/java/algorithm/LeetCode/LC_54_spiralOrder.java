package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xionghx
 * @Date: 2022/07/05/15:19
 * @Version: 1.0
 * 思路：四个指针
 */
public class LC_54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int left = 0, right = matrix[0].length-1;
        int top = 0, down = matrix.length-1;

        while (true) {
            for (int i = left; i <= right; ++i) {
                arr.add(matrix[top][i]);
            }
            top++;
            if (top > down) break;
            for (int i = top; i <= down; ++i) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int i = right; i >= left; --i) {
                arr.add(matrix[down][i]);
            }
            down--;
            if (top > down) break;
            for (int i = down; i >= top; --i) {
                arr.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;

        }
        return arr;
    }
}
