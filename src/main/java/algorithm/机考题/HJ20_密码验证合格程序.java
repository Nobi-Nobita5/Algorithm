package algorithm.机考题;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 描述
 * 密码要求:
 *
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 *
 * 数据范围：输入的字符串长度满足
 * 1
 * ≤
 * �
 * ≤
 * 100
 *
 * 1≤n≤100
 * 输入描述：
 * 一组字符串。
 *
 * 输出描述：
 * 如果符合要求输出：OK，否则输出NG
 */
public class HJ20_密码验证合格程序 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.next();
            if(str.length() <= 8){
                System.out.println("NG");
                continue;
            }
            if(getMatch(str)){
                System.out.println("NG");
                continue;
            }
            if(getString(str, 0, 3)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    // 校验是否有重复子串，递归实现
    private static boolean getString(String str, int l, int r) {
        // 不包含重复子串
        if(r >= str.length()) return false;

        //包含重复子串
        if (str.substring(r).contains(str.substring(l,r))) return true;
        else {
            return getString(str,l+1,r+1);
        }
    }
    // 检查是否满足正则,注意正则的使用;
    // 1.生成Pattern规则。2.生成匹配对象matcher。3.调用匹配方法，如matches()或find()
    private static boolean getMatch(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }
}
