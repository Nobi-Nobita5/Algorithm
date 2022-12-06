package algorithm.LeetCode;

import java.util.Scanner;

public class ShuZiSanJiaoXing {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int min;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = sca.nextInt();
            }
        }
        b[0][0] = a[0][0];
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0){
                    b[i][j] = b[i-1][j] + a[i][j];
                }else if(i==j) {
                    b[i][j] = b[i-1][j-1] + a[i][j];
                } else b[i][j] = Math.min(b[i-1][j-1],b[i-1][j]) + a[i][j];
            }
        }
        min = b[n-1][0];
        for (int i = 1; i < n; i++) {
            if (b[n-1][i]<min){
                min = b[n-1][i];
            }
        }
        System.out.println(min);

//        int i = solve(a,0,0,a.length-1);
//        System.out.println(i);
    }

//    private static int solve(int[][] a, int i, int j, int n) {
//        if (i==n) return a[i][j];
//        int x = solve(a,i+1,j,n);
//        int y = solve(a,i+1,j+1,n);
//        return a[i][j]+Math.min(x,y);

    //   }
}
