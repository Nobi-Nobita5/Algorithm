package algorithm.JianZhiOffer;
//旋转数组的最小值,二分法，array[mid]跟array[hi]进行比较
public class Q6 {
    public int minNumberInRotateArray(int [] array) {
        int lo = 0;
        int hi = array.length-1;
        while (lo<hi){
            int mid = lo + (hi-lo)/2;
            if (array[mid]>array[hi]){
                lo = mid+1;
            }else if(array[mid]<array[hi]){
                hi = mid;
            }else hi = hi-1;
        }
        return array[hi];
    }
}
