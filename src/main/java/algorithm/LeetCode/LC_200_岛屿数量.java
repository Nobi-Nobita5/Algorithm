package algorithm.LeetCode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 */
public class LC_200_岛屿数量 {
    /**
     * 方法一：dfs；题解中收藏了dfs模板
     * 深度优先搜索，每个被搜索到的1都会被重置为2.最终岛屿的数量就是进行深搜的次数
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1'){
                    ++res;
                    dfs(grid,r,c);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (r<0||r>=grid.length||c<0||c>=grid[0].length)return;
        // 如果这个格子不是岛屿，也直接返回
        if (grid[r][c]!='1') return;
        // 将格子标记为「已遍历过」
        grid[r][c] = '2';
        // 访问上、下、左、右四个相邻结点
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
