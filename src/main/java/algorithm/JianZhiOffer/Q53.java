package algorithm.JianZhiOffer;

/*
解法：遍历字符串，遇到不满足的情况返回false，最后返回true
1.符号，小数点，底数E，e能出现的次数，位置
2.如果字符串是指数，则不能出现小数点
3.字符是否合法
 */
public class Q53 {
    public boolean isNumeric (String str) {
        // write code here
        char[] st = str.toCharArray();
        if(str==null)
            return false;
        boolean sign=false,decimal=false,hasE=false; //标记符号、小数点、指数符号E是否出现过
        for(int i=0;i<st.length;i++){
            if(st[i]=='e'||st[i]=='E'){ //有E或者e出现
                if(i==st.length-1) //E不能是最后一位，后面必须跟指数
                    return false;
                if(hasE) return false; //E只能出现一次
                hasE=true;
            }else if(st[i]=='.'){
                if(hasE||decimal||i==st.length-1) //指数不能有.小数点只能出现一次
                    return false;
                decimal=true;
            }else if(st[i]=='+'||st[i]=='-'){
                //第一次出现，开头或者e之后
                if(!sign && i!=0 && st[i-1]!='e' && st[i-1]!='E') //不在开头也不在e之后
                    return false;
                //第二次出现，E之后
                if(sign && st[i-1]!='E' && st[i-1]!='e')
                    return false;
                sign=true;
            }else if(st[i]>'9'||st[i]<'0') //不合法字符
                return false;
        }
        return true;
    }
}
