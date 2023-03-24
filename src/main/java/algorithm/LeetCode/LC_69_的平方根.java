package algorithm.LeetCode;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 *
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *  
 *
 * 提示：
 *
 * 0 <= x <= 2^31 - 1
 *
 * ----------------------------------
 * 由于x的平方根的整数部分 ans 是满足 k^2 <= x的最大 k 值。
 * 我们可以对 1 ~ x 区间进行二分查找，得到答案
 * --------------------------------
 * 时间复杂度O(logN)
 */
public class LC_69_的平方根 {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int lo = 1, hi = x;
        int res = 0;
        while(lo <= hi){
            //为了死循环，if中两种操作都会让指针跳过可能为答案的mid，也就是说任意一个指针并没有【尽量获取最终答案】的责任（我们最终返回的也不是任意一个指针）。
            //故两指针相遇时(lo = hi)，可能指向最终答案，我们必须再进行一次循环，保证将可能的答案更新到 res 中。
            int mid = lo + (hi - lo) / 2;
            if((long)mid * mid <= x){//(long)避免int数越界
                res = mid;//mid * mid <= x 的最大mid值，当前可能是最大mid值，但lo会跳过mid，所以将mid赋值给res保留;
                lo = mid + 1;//不能 lo = mid ,然后返回lo, 这样会有死循环
            }else if((long)mid * mid > x){
                hi = mid - 1;
            }
        }
        return res;
    }
}
