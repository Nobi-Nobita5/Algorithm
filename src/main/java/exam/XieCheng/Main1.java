package exam.XieCheng;
/*
完整的SQL，以两个换行结尾。
SQL中所有的原始表名，每行一个表名。

如果有多个表名，按照出现的先后顺序输出

select t.id, t.name, t.tag_id
from (
    ​select user.id, user.name, tag.tag_id
    ​from user
    ​inner join user_tag
) t

user
user_tag
 */
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer res = new StringBuffer();
        String s;
        while ((s = sb.readLine())!=null){
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                if (s1[i].equals("from")){
                    int k = i+1;
                    if (!s1[k].equals("(")){
                        if (res.toString().contains(s1[k])){
                            continue;
                        }else res.append(s1[k]).append("\n");
                    }
                }
                if(s1[i].equals("join")){
                    if (res.toString().contains(s1[i])){
                        continue;
                    }else res.append(s1[i]).append("\n");
                }
            }
        }
        System.out.println(res);
    }
}