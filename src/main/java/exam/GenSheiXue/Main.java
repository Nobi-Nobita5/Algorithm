package exam.GenSheiXue;

import java.util.Scanner;

public class Main {
    private  static int res=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        solve(n,m);
        System.out.println(res);
    }

    private static void solve(int n, int m) {
        for (int i = 1; i <= m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp = i + i / 2;
            }
            if (temp == m) {
                res = i;
            }
        }
    }
}
