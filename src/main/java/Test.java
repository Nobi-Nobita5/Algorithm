public class Test {
    private  int solve(int[] array, int k) {
        int lo = 0;
        int hi = array.length;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (array[mid] >= k){
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
