package algorithm.JianZhiOffer;

public class Q30 {
    /*
    这题目应该是最基础的动态规划的题目：
    最大子数组的和一定是由当前元素和之前最大连续子数组的和叠加在一起形成的，
    因此需要遍历n个元素，看看当前元素和其之前的最大连续子数组的和能够创造新的最大值。
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int dp[] = new int[array.length];
        dp[0] = array[0];
        int max = array[0];//注意全是负数的情况
        for (int i = 1; i < array.length; i++) {
            //dp存放的要么是当前值array[i]，要么是array[i]+dp[i-1]
            //但是如果最后加上的负数，那结果一定会变小，所以要用max记录最大值。
            dp[i] = Math.max(array[i],array[i]+dp[i-1]);
            if (dp[i]>max) max = dp[i];
        }
        return max;
    }
}
