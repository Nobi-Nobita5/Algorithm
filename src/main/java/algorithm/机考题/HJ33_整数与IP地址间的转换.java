package algorithm.机考题;

import java.util.*;

public class HJ33_整数与IP地址间的转换 {
    private static final int N = 4;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String res = convert(str);
            System.out.println(res);
        }
    }

    public static String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                //ipv4地址有四段，从左到右处理，每次处理新的一段时，将之前的一段乘以256再加上后面一段的数。（因为每段占8位，它们之间的进制差是256）
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                //从左到右处理int整数，每次将该数对256取余作为ipv4的低位。
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);//上述String的拼接方法，最开始生成的低位会留下一个"."
        }
    }
}
