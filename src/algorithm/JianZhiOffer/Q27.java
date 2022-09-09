package algorithm.JianZhiOffer;
import java.util.*;
//字符串的排列
//https://blog.csdn.net/zangdaiyang1991/article/details/88657331?ops_request_misc=%25257B%252522request%25255Fid%252522%25253A%252522161278310316780269827749%252522%25252C%252522scm%252522%25253A%25252220140713.130102334.pc%25255Fall.%252522%25257D&request_id=161278310316780269827749&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-1-88657331.pc_search_result_cache&utm_term=%25E5%25AD%2597%25E7%25AC%25A6%25E4%25B8%25B2%25E7%259A%2584%25E6%258E%2592%25E5%2588%2597Java

//1.面对这样的题目，我们需要将复杂问题分解化，分解成一个一个小问题。
// 将一个字符串分为两部分：第一部分为它的第一个字符，第二部分为后面所有的字符

/*
求整个字符串的全排列，可以看成两步：

第一步首先求所有可能出现在第一个位置的字符，
即把第一个字符和后面所有的字符交换;

第二步固定第一个字符，求后面所有字符的排列。
这时候仍然把后面的字符分成两部分，后面的第一个字符，和这个字符之后的所有字符，
然后把后面的第一个字符和它后面的字符交换。
 */
public class Q27 {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str.length()==0||str==null) return list;
        solve(str.toCharArray(),0);
        ArrayList<String> list = new ArrayList<>(new HashSet<>(this.list));//去重
        Collections.sort(list);
        return this.list;
    }

    private void solve(char[] charArray, int i) {
        if (i==charArray.length-1) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < charArray.length; j++) {
                str.append(charArray[j]);
            }
            list.add(str.toString());
        }
        for (int j = i; j <charArray.length ; j++) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            solve(charArray,i+1);
            //交换过之后，要换回来才能保证是第一个元素与后面的元素进行依次交换
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }

    }
}
