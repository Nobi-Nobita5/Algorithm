package algorithm.LeetCode;

public class ZuiChangGongGongQianZhui {
    public String longestCommonPrefix (String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);//遍历第一个字符串的第i个字符
            for (int j = 1; j <strs.length ; j++) {//遍历后面字符串的第i个字符
                if (strs[j].length()<=i||strs[j].charAt(i)!=ch){
                    return sb.toString();//sb为空会自动返回空字符串
                }
            }
            sb.append(ch);//遍历后面字符串的第i个字符,都与ch相等则添加
        }
        return sb.toString();
    }
}
