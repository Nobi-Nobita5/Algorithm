package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:19
 * @Version: 1.0
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * -----------------------------------------------------
 * 思路：list.sort重写compare方法，(x + y).compareTo(y + x)
 */
public class LC_179_largestNumber {
    public String largestNumber(int[] nums) {
        //int数组转换为集合，方便重写Comparator
        ArrayList<String> list = new ArrayList<>();
        for (int num: nums) {
            list.add(num+"");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String o1 = x + y;
                String o2 = y + x;
                return o2.compareTo(o1);//303和330，用字符串拼接再比较即可
                //降序
            }
        });
        StringBuilder ret = new StringBuilder();
        for (String num : list) {
            ret.append(num);
        }
        if(ret.charAt(0) == '0'){
            return "0";
        }
        return ret.toString();
    }
}
