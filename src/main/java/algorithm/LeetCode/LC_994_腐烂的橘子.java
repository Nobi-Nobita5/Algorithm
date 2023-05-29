package algorithm.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * ------------------
 * 应该是广度优先搜索算法
 */
public class LC_994_腐烂的橘子 {
    public static void main(String[] args) {
        orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }

    public static int orangesRotting(int[][] grid) {

        int time =0;
        int row = grid.length;
        int col = grid[0].length;

        Deque<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[row][col];

        //'2'的节点先入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        //方向矢量
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

        //bfs
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 4; j++) {
                    int xx = x ,yy = y;
                    xx += dir[j][0];
                    yy += dir[j][1];
                    //判断当前poll出的节点的四个方向上是否有橘子，有就腐烂,加入队列，标记为已访问
                    if (xx >= 0 && xx < row && yy >= 0 && yy < col && !visited[xx][yy] && grid[xx][yy] == 1){
                        grid[xx][yy] = 2;
                        queue.offer(new int[]{xx,yy});
                        visited[xx][yy] = true;
                    }
                }
            }
            time+=1;
        }

        //以下代码都是处理特殊情况
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        boolean flag = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) flag = true;
            }
        }
        if (!flag) return 0;

        if (row == 1 && col == 1 && grid[0][0] != 2) return time;
        else {
            return time - 1;
        }
    }
}
