package BiShi.D360;

import java.util.Scanner;

public class Main {
    //1,2,3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i <n; i++) {
            res += a[i];
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                int temp = a[i]|a[j];
                res+=temp;
            }
        }
        System.out.println(res);
    }
}
