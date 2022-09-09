import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] a = {10,2};
        String s = largestNumber(a);
        System.out.println(s);
    }
    public static String largestNumber(int[] nums) {
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
