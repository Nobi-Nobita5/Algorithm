/**
 * @param {number[]} nums
 * @return {number}
 */
/*
解题思路
在不建立map表的情况下，如何完成重复判断？
这里，我们必须利用 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内 这个条件
根据这个条件，我们可以使用计数排序的思路，将数字放到对应索引的位置

如果当前索引与所在位置值相等，则表示该位置已排序，无需处理，进入下一位置
否则，将当前索引与该值作为索引进行交互，结果是目标值与索引对应上了
在条件2之前，判断要交换的值与当前值 是否相等，如果相等，则表示该值重复，返回该值
当遍历完后，依然没有找到重复值，则表示不存在重复，返回-1
 */
let nums = [2, 3, 1, 0, 2, 5, 3];
function solution(nums) {
    let len = nums.length;
    let i  = 0 ;
    while(i < len) {
        if(i == nums[i]) {
            i++;
            continue;
        }
        if(nums[i] == nums[nums[i]]) {
            return nums[i];
        }
        swap(nums, i, nums[i])
    }
    return -1;
};

function swap(nums, i, j) {
    let temp = nums[i];
    nums[i] = nums[j]
    nums[j] = temp;
}
let findRepeatNumber = solution(nums);
alert(findRepeatNumber);


