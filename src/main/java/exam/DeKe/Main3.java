package exam.DeKe;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int count = 0;
        int count1 = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = (int) Math.sqrt(split.length);
        int[][] a = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(split[k]);
                k++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j]==1){
                    count++;
                }else if (a[i][j]==0){
                    count1++;
                }
            }
        }
        if (count==split.length||count1==split.length)
            System.out.println(-1);
        else System.out.println(count+2);
    }
}
