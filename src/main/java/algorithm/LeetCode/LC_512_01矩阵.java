package algorithm.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * 示例 2：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * mat 中至少有一个 0 
 *
 * --------------------------------------------
 * 思路：求多个源点出发的最短路时：从超级源点出发的广度优先遍历，来自官方题解
 * 在最短路问题中，如果我们要求多个源点出发的最短路时，一般我们都会建立一个「超级源点」连向所有的源点。
 * 用「超级源点」到终点的最短路等价多个源点到终点的最短路。
 *
 * 1.先把所有0加入队列，相当于从超级源点出发进行了一次BFS，所有点对应的dist都维护0，
 * 2.再从每个0触发，每一层BFS得到该层的1到0的距离，维护到dist中，每遍历一层就是dist+=1
 *
 * 时间复杂度: O（M*N）
 * 空间复杂度: O（M*N）
 *
 * ！！！广度优先遍历需要确定一个唯一的出发点，先入队列。
 * 我们需要对于每一个 1 找到离它最近的 0。如果只有一个 0 的话，我们从这个 0 开始广度优先搜索就可以完成任务了；
 * 但在实际的题目中，我们会有不止一个 0。我们会想，要是我们可以把这些 0 看成一个整体好了。一开始我们就将所有的 0 加入队列，它们的初始距离为 0。
 * 这样以来，在广度优先搜索的过程中，我们每遇到一个 1，就将对应的dist矩阵位置的值设置为【这一层遍历的出发点的值+1】，也就是 这个 1 到最近的 0 的距离。
 *
 */
public class LC_512_01矩阵 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        if (row==0||col==0) return null;
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] seen = new boolean[row][col];
        //建立对应的“距离”矩阵
        int[][] dist = new int[row][col];
        //先把所有0加入队列，相当于从超级源点出发进行了一次BFS
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j]==0) {
                    deque.offer(new int[]{i, j});
                    seen[i][j] = true;
                    dist[i][j] = 0;//0的位置上相应的dist就是0
                }
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        //广度优先遍历
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] poll = deque.poll();
                int xx = poll[0];
                int yy = poll[1];
                for (int j = 0; j < 4; j++) {
                    int x = xx + dir[j][0];
                    int y = yy + dir[j][1];
                    if (x>=0&&x<row&&y>=0&&y<col&&!seen[x][y]){//不越界、未访问
                        dist[x][y] = dist[xx][yy] + 1;//距离加一
                        deque.offer(new int[]{x,y});
                        seen[x][y] = true;
                    }
                }
            }
        }
        return dist;
    }
}
