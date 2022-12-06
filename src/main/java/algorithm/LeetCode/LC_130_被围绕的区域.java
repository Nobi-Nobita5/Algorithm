package algorithm.LeetCode;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 *
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * --------------------------------------
 * 思路：来自收藏题解
 * 1.从为O的边缘开始dfs，把遇到的O置为#
 * 2.遍历网格，把遇到O置为X，#置为O
 * 这样就实现了把所有被陆地围绕的湖(O)变成陆地(X);
 * ------------------
 * 如何寻找和边界联通的O? 从边界出发，对图进行 dfs 和 bfs 即可。这里简单总结下 dfs 和 dfs。
 *
 * bfs 递归。可以想想二叉树中如何递归的进行层序遍历。
 * bfs 非递归。一般用队列存储。
 * dfs 递归。最常用，如二叉树的先序遍历。
 * dfs 非递归。一般用 stack。
 */
public class LC_130_被围绕的区域 {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        if (board == null ||r<=0 || c<=0) return;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //从边缘的O开始dfs
                boolean isEdge = i==0||j==0||i==r-1||j==c-1;
                if (isEdge && board[i][j] == 'O'){
                    dfs(board,i, j);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    /**
     * 使用dfs递归方式实现
     * @param board
     * @param r
     * @param c
     */
    private void dfs(char[][] board, int r, int c) {
        // board[i][j] == '#' 说明已经搜索过了
        if (r>=board.length || r<0 ||c>=board[0].length || c<0 ||board[r][c] == 'X'||board[r][c] == '#') return;
        if (board[r][c] == 'O') board[r][c] = '#';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}
