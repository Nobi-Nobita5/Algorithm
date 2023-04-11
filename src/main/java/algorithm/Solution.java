package algorithm;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[]{2,0,2,1,1,0};
        sortColors(a);
    }
    public static void sortColors(int[] nums) {
        int p = 0;
        int p1 = 0;
        while (p1 < nums.length){
            if (nums[p1] == 0){
                int t = nums[p];
                nums[p] = nums[p1];
                nums[p1] = t;
                p++;
            }
            p1++;
        }

        p1 = p;

        while (p1 < nums.length){
            if (nums[p1] == 1){
                int t = nums[p];
                nums[p] = nums[p1];
                nums[p1] = t;
                p++;
            }
            p1++;
        }
    }
}
