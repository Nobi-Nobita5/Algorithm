package algorithm.JianZhiOffer;
/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 */
public class Q65 {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (solve(board, word, i, j, vis, 0)) {
                    // 找到一种情况即可
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(char[][] board, String word, int x, int y, boolean[][] vis, int index) {
        // 越界处理以及每个方格只能访问一次
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y]) {
            return false;
        }
        // 匹配到某一位置不满足条件
        if (word.charAt(index) != board[x][y]) {
            return false;
        }
        // 匹配成功
        if (index == word.length() - 1) {
            return true;
        }

        vis[x][y] = true; // x，y位置的标记

        boolean flag = solve(board, word, x + 1, y, vis, index + 1) ||
                solve(board, word, x - 1, y, vis, index + 1) ||
                solve(board, word, x, y + 1, vis, index + 1) ||
                solve(board, word, x, y - 1, vis, index + 1);
        //递归代码之后的代码是在递归完成之后回溯回来依次运行的。当回溯回来依次运行下面的代码时，
        //已经完成了从x，y出发对所有坐标的深度遍历
        vis[x][y] = false; // x，y位置的标记状态回溯
        return flag;
    }
}
