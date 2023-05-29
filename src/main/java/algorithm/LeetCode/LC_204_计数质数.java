package algorithm.LeetCode;

import java.util.Arrays;

public class LC_204_计数质数 {

    /**
     * 依次判断每个数是否为质数，超时。
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *我们设 isPrime[i] 表示i 是不是质数，
     * 如果是质数则为 1 ，否则为 0
     * 从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即0。
     * 这样在运行结束的时候我们即能知道质数的个数。
     * @param n
     * @return
     */
    public int countPrimes_方法二(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if(isPrime[i] == 1){
                ans+=1;
                if((i + i) < n){
                    for(int j = i + i;j< n ; j = j+i){
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
