package algorithm.JianZhiOffer;

public class Q44 {
    //反转单词顺序
    public class Solution {
        public String ReverseSentence(String str) {
            if (str.length()==0||str==null||str.matches("\\s+")) return str;//为空或长度为0，正则匹配任意个数的空格，制表符，换页符等
            StringBuilder sb = new StringBuilder();
            String[] s = str.split(" ");
            for (int i = s.length-1; i >=1 ; i--) {
                sb.append(s[i]+" ");//加空格
            }
            sb.append(s[0]);
            return sb.toString();
        }
    }
}
