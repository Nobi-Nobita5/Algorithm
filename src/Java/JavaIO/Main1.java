package Java.JavaIO;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            int length = str.length();
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (str.charAt(i)==' ') { // 或者 if (str.substring(i, i + 1).equals(" ")) {
                    break;
                }
                count++;
            }
            System.out.println(count);
        }


        //String.split() 一个或多个空格分割字符串
        @Test
        public void test(){
            String s = "1 12    4";
            String[] s1 = s.split("\\s+");//匹配任意一个或多个空格

            Arrays.sort(s1,(o1, o2)->Integer.parseInt(o1)>Integer.parseInt(o2)?1:-1);
            System.out.println(Arrays.toString(s1));
        }
}
