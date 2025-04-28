package exam.didi;

import java.util.Scanner;
/*
一个救助站，多个居民点，有多条边，救助站能访问所有居民点，判断是否删除任意一条边后救助站仍然可以访问任意一个居民点
ac:直接判断任意两点之间是否有2条或以上的边数 bfs

2   //几组数据
4 5 //救助站到居民点，居民点之间的边数
.。
。。
。。
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // k组
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            // 数据读取
            int n = sc.nextInt(), m = sc.nextInt();

            boolean[][] map = new boolean[n+1][n+1];
            for (int j = 0; j < m; j++) {
                int c = sc.nextInt(), r = sc.nextInt();
                map[c][r] = map[r][c] = true;
            }

            //  每行每列应不少于2个true
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                int countRow = 0, countCol = 0;
                for (int l = 1; l <= n; l++) {
                    if (map[j][l])  countRow++;
                    if (map[l][j])  countCol++;
                }

                if (countCol < 2 || countRow < 2) {
                    System.out.println("No");
                    flag = true;
                    break;
                }
            }
            if (!flag) System.out.println("Yes");
        }

    }
}