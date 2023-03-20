import algorithm.TreeNode;

import java.util.*;

public class Test {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (grid[0][0] != 0 && grid[r-1][c-1] !=0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[r][c];
        queue.offer(new int[]{0,0});
        int dist = 1;
        seen[0][0] = true;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int x = 0;
        int y = 0;
        while (!queue.isEmpty()){
            //必须在循环前把 queue.size()固定，因为size在循环内会变化
            int size = queue.size();
            //依次遍历当前队列中的元素
            /*
            * 这里必须套一层for循环的原因是：
            * 1. 与LC_102_层序遍历二叉树相似，我们 dist += 1 的操作必须在当前层的所有元素都被操作一次后再执行。（每个元素出队列，该元素邻居节点入队列 算一次操作）
            * 2. 如果不用for循环，dist 会在每一个元素被操作一次后进行自加一，是不符合题意的。因为我们应该使用BFS，在每一层遍历后，距离加一，才能得到最短路径。
            * */
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                int xx = poll[0];
                int yy = poll[1];
                for (int i = 0; i < 8; i++) {
                    x = xx + dir[i][0];
                    y = yy + dir[i][1];
                    if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 0 && !seen[x][y]) {
                        queue.offer(new int[]{x, y});
                        seen[x][y] = true;
                    }
                    if (x == r - 1 && y == c - 1) return dist + 1;
                }
            }
            dist += 1;
        }
        return -1;
    }
}
