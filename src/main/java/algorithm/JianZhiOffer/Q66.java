package algorithm.JianZhiOffer;

public class Q66 {
    //该问题可以用深度优先（递归实现） 或  广度优先搜索（队列实现）
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] vis = new boolean[rows][cols];
        return dfs(0,0,rows,cols,threshold,vis);
    }

    private int dfs(int x, int y, int m, int n, int k,boolean[][] vis) {
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1) return 0;//越界返回0
        if ((x / 10 + x % 10 + y / 10 + y % 10) > k) return 0;//位数之和大于k返回0
        if (vis[x][y]) return 0;//机器人走过该位置也返回0
        vis[x][y] = true;//满足条件，计算后把该位置设为走过的状态（true）
        return 1 + dfs(x - 1, y, m, n, k, vis) + dfs(x + 1, y, m, n, k, vis) + dfs(x, y - 1, m, n, k, vis) + dfs(x, y + 1, m, n, k, vis);
    }
}
