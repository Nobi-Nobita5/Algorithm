import algorithm.TreeNode;

import java.util.*;

public class Test {
    public int longestSubstring(String s, int k) {
        return dfs(s, k);
    }

    private int dfs(String s, int k) {
        int[] countChar = new int[26];
        String split = "";

        for (int i = 0; i < s.length(); i++) {
            countChar[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < countChar.length; i++) {
            if (countChar[i] < k) {
                split = String.valueOf('a' + (char)('i'));
                break;
            }
        }

        if (split.equals("")){
            return s.length();
        }

        int max = 0;

        String[] split1 = s.split(split);
        for (String currentString:
             split1) {
            int currentMax = dfs(currentString, k);
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
