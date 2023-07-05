package BiShi.DeKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个由若干整数组成的数组，可以在数组内任意位置进行分割，将该数组分割成两个非空子数组，
 * 分别对子数组求和得到两个值，计算着两个值的差值，请输出所有分割方案中，差值最大的值。
 * 如输入1 -2 3 4 -9 7，输出 10
 */
public class Main_2 {
    /* 27% AC*/
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            //n个数字
            int n = Integer.valueOf(sc.nextLine());
            String[] strings = sc.nextLine().split(" ");
            //存放
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.valueOf(strings[i]);
            }
            //差值
            int maxDiff = Integer.MIN_VALUE;
            int leftSum = 0;
            int rightSum = 0;

            int totalSum = 0;

            //计算整个数组的和
            for (int i = 0; i < n; i++) {
                totalSum += arr[i];
            }

            //遍历分割点，计算差值
            for (int i = 0; i < n - 1; i++) {
                leftSum += arr[i];
                rightSum = totalSum - leftSum;
                int diff = Math.abs(leftSum - rightSum);
                maxDiff = Math.max(maxDiff, diff);
            }
            System.out.println(maxDiff);
        }
    }
}
