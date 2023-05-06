package algorithm;

public class Solution {
    public void sortColors(int[] nums) {
        solve(nums,0,nums.length-1);
    }

    private void solve(int[] nums, int left, int right) {
        if (left >= right){
            return;
        }
        int i = left;
        int j = right;

        while (i < j){
            while (i < j && nums[j] >= nums[left]){
                j--;
            }
            while (i < j && nums[i] <= nums[left]){
                i++;
            }
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        int tmp = nums[left];
        nums[left] = nums[i];
        nums[i] = tmp;

        solve(nums,left,i-1);
        solve(nums,i+1,right);
    }
}
