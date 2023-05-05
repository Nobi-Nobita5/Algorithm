package algorithm;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];

        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            //判断s[i]是否是0，执行动态转换方程

            if (s.charAt(i) != '0') dp[i] = dp[i-1];
            int num = 10 * (s.charAt(i-1) - '0') + (s.charAt(i) - '0');
            if (num >= 10 && num <= 26){
                if (i == 1) dp[i] = dp[i] + 1;
                else {
                    dp[i] = dp[i] + dp[i-2];
                }
            }
        }
        return dp[s.length() -1 ];
    }
}
