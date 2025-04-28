package exam.DeKe;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8_合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//这一个循环每道题都有，就是用来让方法不退出，可以多次输入测试用例的，删掉也没有影响
            Map<Integer, Integer> map = new TreeMap<>();
            int n = in.nextInt();
            /**
             * nextLine()用法：
             * 注意nextLine()函数会接收当前位置开始的一行数据和回车符号。
             * 如当用户输入一行文本后按下回车键，nextLine() 方法会读取回车符之前的文本。
             * ---------------
             * 这里我们先读取了一个int n = in.nextInt();
             * 此时当前行还剩余空格和回车，所以需要单独写一个String s1 = in.nextLine();来接收回车符号前没用的数据。
             */
            String s1 = in.nextLine();
            for (int i = 0; i < n; i++) {
                String[] s = in.nextLine().split(" ");
                Integer key = Integer.valueOf(s[0]);
                Integer value = Integer.valueOf(s[1]);
                map.put(key, map.getOrDefault(key, 0) + value);
            }
            Iterator<Map.Entry<Integer, Integer>> iterators = map.entrySet().iterator();
            while (iterators.hasNext()) {
                Map.Entry<Integer, Integer> next = iterators.next();
                System.out.println(next.getKey() + " " + next.getValue());
            }
        }
    }
}
