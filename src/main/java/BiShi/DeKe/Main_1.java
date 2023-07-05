package BiShi.DeKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

/**
 * 1.输入的n个数字代表n个牌；
 * 2.每轮选手可以选择获取该轮牌，其总分加上该轮牌面分数，为其新的总分；
 * 3.选手也可以不选择本轮牌，直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮数小于等于3，则总分置为0；
 * 初始的分数为0。数出最后的分数的最大值。
 */
public class Main_1 {
    /* 55% AC*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(",");
        //n轮牌面
        int n = strings.length;
        //存放牌面
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.valueOf(strings[i]);
        }

        //遍历
        //1。正数直接获取
        //2。负数进行判断：
        //  1）如果轮次>3,判断【加上该负数后】和【res[i-3]】的大小
        //  2）如果轮次<=3,也是判断，加上大于0，就不回退，回退归零
        int res[] = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (ints[i] >=0 ) {
                curr+=ints[i];
                res[i] = curr;
            }
            else {
                //轮次大于3
                if (i > 2 ){
                    if ((curr + ints[i]) >= res[i -3]){
                        //加上更大
                        curr += ints[i];
                        res[i] = curr;
                    }else {
                        //回退更大
                        res[i] = res[i-3];
                    }
                }else {//轮次小于3
                    if ((curr + ints[i]) >= 0){
                        //加上大于0，就不回退
                        curr += ints[i];
                        res[i] = curr;
                    }else {
                        //回退更大
                        curr = 0;
                        res[i] = 0;
                    }
                }
            }
        }
        System.out.println(res[n-1]);
    }
}
