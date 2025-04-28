package exam.DeKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        Main2 main = new Main2();
        ArrayList<String> list1 = main.Permutation(sb.toString());
        int k = sc.nextInt();
        System.out.println(list1.get(k-1));
    }
    public ArrayList<String> Permutation(String str) {
        if (str.length()==0||str==null) return list;
        solve(str.toCharArray(),0);
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
        //循环确定一个位置的字母的每种情况，递归
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
