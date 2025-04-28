package exam.MeiTuan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            b[i] = sc.nextInt();
        }
        solve(a,b);
    }

    private static void solve(int[] a, int[] b) {
        for (int i = 1; i <=b.length-1 ; i++) {
            int temp = b[i];
            a[temp] = 0;
            int x = 0;
            int y = 0;
            int sum = 0;
            if (b[i]==1){
                for (int j = 2; j <=a.length-1 ; j++) {
                    sum+=a[j];
                }
                System.out.println(sum);
                continue;
            }
            if (b[i]==a.length-1){
                for (int j = 1; j <=a.length-2 ; j++) {
                    sum+=a[j];
                }
                System.out.println(sum);
                continue;
            }
            for (int j = 1; j <=temp-1; j++) {
                x += a[j];
            }
            for (int j = i+1; j <=a.length-1; j++) {
                y += a[j];
            }
            System.out.println(Math.max(x,y));
        }
    }
}
