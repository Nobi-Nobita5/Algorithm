package BiShi.GenSheiXue;

import java.util.*;
public class Main1 {
    //不用库函数求平方根
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Double n = new Double(sc.nextInt());
        Double res;
        res = solve(n);
        System.out.println(String.format("%.3f",res));
    }

    private static Double solve(double a) {
        double x = 7;//随便一个初始值，1，88866，什么的都可以
        while (true){
            x = (x+a/x)/2;
            if (Math.abs((x*x -a))<1e-9) return x;
        }
    }
}