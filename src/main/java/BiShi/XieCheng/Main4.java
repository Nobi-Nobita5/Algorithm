package BiShi.XieCheng;

/*
小A大学毕业后，回家继承了老爸的租车公司。
现在小A的店内只剩下一辆汽车可出租，但是一天内有n个订单，
每个订单的用车开始时间为第x小时，用车结束时间为第y小时，订单金额为z，
请你帮小A安排订单，计算小A可以获得的最大收益。
注意：一辆车在同一个时间段内不能同时安排两个订单。开始时间和结束时间是小时维度的整数，可取1-24小时。

输入描述
第一行读入一个整数n，表示有n（1<=n<=10）个订单；
第二行读入用空格分隔的整数，表示订单的开始时间。
第三行读入用空格分隔的整数，表示订单的结束时间。
第四行读入用空格分隔的整数，表示订单金额。

输出描述
输出小A可以获得的最大收益。

样例输入
4
1 2 3 3
3 4 5 6
200 150 180 210
样例输出
410
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z = new int[n];
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            x[i] = p;
        }
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            y[i] = p;
        }
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            z[i] = p;
        }
        Arrays.sort(z);
        if (x[n-1]<y[0]){
            System.out.println(z[z.length-1]);
        }else {
            for (int i = z.length - 1; i >= z.length - 2; i--) {
                sum1 += z[i];
            }
            System.out.println(sum1);
        }
    }
}