package interview;
/*
进行length/2次比较就完事了
 */
public class judge_判断回文字符串 {
    public boolean judge (String str) {
        // write code here
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
