package algorithm.LeetCode;

public class LC_1185_一周中的第几天 {
    int[] m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] week = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public String dayOfTheWeek(int day, int month, int year) {
        // 今天是 2022/1/3，星期一
        // 先看看是今天之前还是今天之后
        // 全部对比 1971/1/1 算
        int now = getDay(2022, 1, 3);
        int target = getDay(year, month, day);
        int d = target - now;
        return week[(70000 + d) % 7];
    }

    int getDay(int year,int month,int day){
        int res = day;
        /*
         以下两种情况的就是闰年:
         1,能被4整除而不能被100整除.
         2,能被400整除.
         2000年能被400整除,所以是闰年,比如1900年虽然能被4整除,但因为能被100整除,而不能被400整除,所以不是闰年
         闰年比平年多一天
         */
        for (int i = 1971; i < year; i++) {
            if (i % 400 == 0 || i % 4 == 0 && i % 100 != 0){
                res += 366;
            }else {
                res += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            res += m[i];
        }
        //判断今年是不是闰年
        if (month > 2 &&(year % 400 == 0 || year % 4 == 0 && year % 100 != 0)) res+=1;
        return res;
    }
}
