package BiShi.XieCheng;

import java.util.Scanner;
/*
A了88%
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] p = sc.nextLine().split(" ");
        int[] price = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            price[i] = sc.nextInt();
        }
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        StringBuffer v = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            v.append(s[i]).append(",");
        }
        v.deleteCharAt(v.length()-1);
        String s1 = v.toString();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < p.length-1; i++) {
            for (int j = i+1; j <p.length ; j++) {
                String s2 = p[i] + "," + p[j];
                if (test(s1,s2)){
                    if ((price[i]+price[j])<min){
                        min = price[i]+price[j];
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else System.out.println(min);
    }
    public static boolean test(String s1,String s2){
        boolean b = true;
        String[] s = s1.split(",");
        for (int i = 0; i < s.length; i++) {
            if (s2.indexOf(s[i])==-1) b = false;
        }
        return b;
    }
}
