package exam.didi;

import java.util.Scanner;
/*
 * 给一个字符串s，你可以至多选择两个不同位置的字符进行交换（可以选择不交换，保留原串），问所有可能中字典序最小的串。
 *
 * 有关字典序：对于长度相同的串a和串b，串a的字典序小于串b当且仅当存在一个位置i使得串a和串b的前i-1个字符完全相同且串a的第i个
 * 字符小于串b的第i个字符。即a1=b1,a2=b2,...ai-1=bi-1且ai<bi。
 */
public class Main_1 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        char[] array = s.toCharArray();
        recur(0,array.length,array);
        System.out.println(array);
    }
    static void recur(int start,int end,char[] arr){
        if (start>=end) return;
        char min = arr[end-1];
        int index = end-1;
        for (int i = end-1; i >=start; i--) {
            if (arr[i] < min){
                min = arr[i];
                index = i;
                if (min == 'a') break;
            }
        }
        for (int i = start; i < index; i++) {
            if (arr[i]>min){
                arr[index] = arr[i];
                arr[i] = min;
                return;
            }
        }
        recur(index+1,end,arr);
    }
}