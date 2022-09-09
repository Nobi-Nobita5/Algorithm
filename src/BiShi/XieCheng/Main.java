package BiShi.XieCheng;

import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcSimilarity(String name1, String name2) {
        int sum = 0;
        int m = 0,n = 0;
        String[] s1 = name1.split(" ");
        String[] s2 = name2.split(" ");

        while (m<s1.length && n<s2.length){
            String str1 = s1[m];
            String str2 = s2[n];

            if (str1.length()>str2.length()){
                if (str1.indexOf(str2)!=-1) {
                    String str21 = str1.replace(str2, "");
                    for (int i = 0; i < str21.length(); i++) {
                        sum += Integer.valueOf(str21.charAt(i));
                    }
                    m++;
                    n++;
                    continue;
                }
                for (int i = 0; i < str1.length(); i++) {
                    sum += Integer.valueOf(str1.charAt(i));
                }
                for (int i = 0; i < str2.length(); i++) {
                    sum += Integer.valueOf(str2.charAt(i));
                }
                m++;
                n++;
                continue;

            }else if (str1.length()<str2.length()){
                if (str2.indexOf(str1)!=-1) {
                    String str22 = str2.replace(str1, "");
                    for (int i = 0; i < str22.length(); i++) {
                        sum += Integer.valueOf(str22.charAt(i));
                    }
                    m++;
                    n++;
                    continue;
                }

                for (int i = 0; i < str1.length(); i++) {
                    sum += Integer.valueOf(str1.charAt(i));
                }
                for (int i = 0; i < str2.length(); i++) {
                    sum += Integer.valueOf(str2.charAt(i));
                }
                m++;
                n++;
                continue;
            }

        }

        while (m<s1.length){
            String str4 = s2[m];
            for (int i = 0; i <str4.length() ; i++) {
                sum += Integer.valueOf(str4.charAt(i));
            }
            n++;
        }

        while (n<s2.length){
            String str3 = s2[n];
            for (int i = 0; i <str3.length() ; i++) {
                sum += Integer.valueOf(str3.charAt(i));
            }
            n++;
        }
        
        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String name2 = in.nextLine();

            int sum = calcSimilarity(name1, name2);
            System.out.println(sum);
        }
    }
}
