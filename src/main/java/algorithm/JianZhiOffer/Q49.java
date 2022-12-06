package algorithm.JianZhiOffer;

//正则表达式匹配字符串
//转换成long型数值
//加上+-号
//判断是否越界
public class Q49 {
    public int StrToInt(String str) {
        if (!str.matches("[+,-]?\\d+")) return 0;// \d代表[0-9] 但是要写成\\d才行。
        long res = 0;//long类型，避免溢出。不能用int
        for (int i = str.length()-1; i >=0; i--) {
            if (str.charAt(i)=='+'||str.charAt(i)=='-') break;
            res += Math.pow(10,str.length()-1-i)*(str.charAt(i)-'0');
        }
        if (str.charAt(0)=='-') res = -res;
        //溢出就返回0，用long类型的res来比较，
        //如果定义为int res,那再比较就没有意义了，int范围为[-2147483648,2147483647]
        if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
