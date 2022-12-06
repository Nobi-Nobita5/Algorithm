package BiShi.DeKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        Collections.sort(a);
        boolean[] b = new boolean[n];
        int m = sc.nextInt();

        int count = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (a.get(i)>=m){
                if (a.get(i-1)<m) temp = i;
                count++;
            }
        }
        for (int i = 0; i < temp-1; i++) {
            for (int j = i+1; j < temp; j++) {
                if (!b[i]&&!b[j]&&(a.get(i)+a.get(j))>=m){
                    count++;
                    b[i] = true;
                    b[j] = true;
                }
            }
        }
        System.out.println(count);
    }
}
