package exam.DeKe;

import java.util.Scanner;

/**
 * 小明和朋友玩跳格子游戏，有n个连续格子，每个格子有不同的分数，小朋友可以选择从任意格子起跳，但是不能跳连续的格子，也不能回头跳。
 * 给定一个代表每个格子得分的非负整数数组，计算能得到的最高分数；如输入 1 2 3 1，输入能得到的最高分 4
 * ------------------------
 * 在这个代码中，我们使用一个 dp 数组来记录到达每个格子时的最高分数。初始时，第一个格子的最高分数为其本身（dp[0] = arr[0]）。
 *
 * 然后，我们从第二个格子开始遍历，对于每个格子，我们有两个选择：
 *
 * 1。选择当前格子的分数加上往前2个格子的最高分数（arr[i] + dp[i - 2]）。
 * 2。不选择当前格子，保持前一个格子的最高分数（dp[i - 1]）。
 * 我们取这两个选择中的较大值，作为当前格子的最高分数。
 *
 * 最后，我们输出 dp[n - 1]，即到达最后一个格子时的最高分数，即为能得到的最高分数。
 *
 * 对于给定的示例输入 1 2 3 1，代码将输出 4，这是因为选择跳到第一个格子和第三个格子，可以得到总分 1 + 3 = 4，是能得到的最高分数。
 */
public class Main_3 {
    /* 100% AC*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] s = in.nextLine().split(" ");
            int n = s.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] dp = new int[n];
            dp[0] = arr[0];

            //计算每一个格子的最高分数，dp[n-1]存放所有情况的最高分
            for (int i = 0; i < n; i++) {
                if (i==1){
                    dp[i] = Math.max(arr[i],dp[i-1]);
                }else {
                    dp[i] = Math.max(arr[i] + dp[i -2],dp[i - 1]);
                }
            }
            System.out.println(dp[n - 1]);
        }
    }
}
