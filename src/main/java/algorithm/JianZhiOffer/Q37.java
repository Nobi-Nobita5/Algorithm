package algorithm.JianZhiOffer;
/*
[1,2,3,3,3,3,4,5],3
 */
public class Q37 {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length <= 0 || array == null) return 0;
        int first = solve(array,k);//第一次出现的位置
        int last = solve(array,k+1);//后面一个元素第一次出现的位置，就可以两个相减得到结果
        return (first==array.length||array[first]!=k)?0:last-first;//
    }

    private int solve(int[] array, int k) {
        int lo = 0;
        int hi = array.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid]>=k){
                hi = mid;//[1,2,3,3]
            }else {
                lo = mid+1;
            }//保证返回的lo是k第一次出现的位置，如果不存在，返回的就是后面一个元素的位置
             //那么，如果返回的lo=array.length就可以成为后面一个元素不存在的判断条件
        }
        return lo;
    }
}
