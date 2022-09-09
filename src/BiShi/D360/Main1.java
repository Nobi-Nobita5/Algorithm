package BiShi.D360;

import java.util.Scanner;
/*
我现在在第一个矿洞，求最多能拿到的金子数

输入
5 10 2  N,M,K分别是矿洞数，飞机一次最远飞的距离，飞机可以飞几次
0 5    到第一个矿洞的距离，矿洞的金子数量
8 6
10 8
18 12
22 15
输出
25
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            a[i]= sc.nextInt();
            b[i]= sc.nextInt();
        }
        res+=b[0];
        int index = 1;
        int index1 = 0;
        int temp = 0;
        for (int i = 1; i <= K; i++) {
            while (Math.abs(a[index]-a[index1])<=M){
                index = index+1;
            }
            index = index-1;
            int max = Integer.MIN_VALUE;
            for (int j = index1+1; j <=index ; j++) {
                if (b[j]>max) max = b[j];
                temp = j;
            }
            index1 = temp;
            index = index1+1;
            res +=max;
        }
        System.out.println(res);
    }
}
