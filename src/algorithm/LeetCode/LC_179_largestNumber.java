package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: Xionghx
 * @Date: 2022/06/23/16:19
 * @Version: 1.0
 * 思路：list.sort重写compare方法，(x + y).compareTo(y + x)
 */
public class LC_179_largestNumber {
    public String largestNumber(int[] nums) {
        //int数组转换为集合，方便重写Comparator
        ArrayList<String> list = new ArrayList<>();
        for (int num:
                nums) {
            list.add(num+"");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String o1 = x + y;
                String o2 = y + x;
                return o2.compareTo(o1);//303和330，用字符串相加再比较即可
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
