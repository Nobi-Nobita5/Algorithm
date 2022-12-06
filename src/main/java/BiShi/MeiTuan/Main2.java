package BiShi.MeiTuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2 {
    private static int a = 0;
    private static int b = 0;
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        String s = br.readLine();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0;
        while (i<s.length()){
            if (i<s.length()&&s.charAt(i)>='a'&&s.charAt(i)<='z'){
                if ((i+1)<s.length()&&s.charAt(i+1)>='0'&& s.charAt(i+1)<='9'){
                    sb.append(" ");
                }
                s = s.substring(0,i) + s.substring(i+1);
            }
            if(i<s.length()&&s.charAt(i)>='0'&& s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }
            i++;
        }
        String[] s1 = sb.toString().split(" ");
        int[] num = new int[s1.length];
        for (int j = 0; j < num.length; j++) {
            for (int k = j; k <num.length-1 ; k++) {
                if (num[k]>num[k+1]){
                    int temp = num[k];
                    num[k] = num[k+1];
                    num[k+1] = temp;
                }
            }
        }
        for (int j = 0; j < num.length; j++) {
            System.out.println(num[j]);
        }
    }
}
