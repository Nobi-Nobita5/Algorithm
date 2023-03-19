package algorithm.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 *
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 *  
 *
 * 提示：
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 * -----------------------------------
 * 思路：BFS广度优先遍历求最短路径：
 * 当前位置的8个方向的单元格为一层遍历，最短路径就是遍历到右下角单元格的遍历的层数
 */
public class LC_1091_二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        if (row==0||col==0||grid[0][0]!=0||grid[row-1][col-1]!=0) return -1;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});//队列储存坐标，方便使用坐标方向矢量遍历队列元素的邻居元素
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        int step = 1;
        int[][] d = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};//2*2*2 = 8种方向变动
        while (!queue.isEmpty()){
            //必须在循环前把 queue.size()固定，因为size在循环内会变化
            int size = queue.size();
            //依次遍历当前队列中的元素
            for (int k = 0; k < size; k++) {
                int[] pop = queue.pop();
                for (int l = 0; l < 8; l++) {//循环8次，获取每种方向矢量
                    int xx = pop[0];
                    int yy = pop[1];
                    if (xx==row-1 && yy == col-1) return step;//当前单元格已到达终点就返回（应对特殊情况{{0}}）
                    int x = xx + d[l][0];
                    int y = yy + d[l][1];
                    //枚举所有邻居元素
                    if(x>=0 && x<row && y>=0 && y<col && !visited[x][y] && grid[x][y]==0) {//未越界、未访问、等于0的
                        if(x==row-1 && y==col-1)//再判断邻居元素坐标是否已经到达右下角
                            return step+1;//到了直接返回
                        queue.offer(new int[]{x,y});//没到加入队列
                        visited[x][y]=true;//标记已访问
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
