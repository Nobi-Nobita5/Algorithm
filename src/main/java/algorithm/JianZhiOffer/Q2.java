package algorithm.JianZhiOffer;
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Q2 {
    /*
        思路2：在原字符串上进行扩容替换
        注意：要从后往前遍历替换，因为从前往后遍历的话原来的字符会被“%20”覆盖，（setLength是在字符串后添加容量）
        步骤：1.计算出扩容之后字符串的长度,使用str.setLength函数扩容
             2.遍历字符串，使用str.setCharAt函数替换字符
         */
    public String replaceSpace(StringBuffer str) {
        int newSpace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                newSpace++;
            }
        }
        int oldLength = str.length();
        int newLength = oldLength + newSpace*2;
        str.setLength(newLength);
        int oldIndex = oldLength-1;
        int newIndex = newLength-1;
        for(;oldIndex>=0 && oldLength<newLength;oldIndex--){
            if (str.charAt(oldIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else str.setCharAt(newIndex--,str.charAt(oldIndex));
        }
        return str.toString();
    }
}
