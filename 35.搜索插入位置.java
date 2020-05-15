
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 */

// @lc code=start
class Solution35 {
    public static void main(String[] args) {
        int[] test = { 1, 3, 5, 6 };
          System.out.println(new Solution35().searchInsert(test, 2));
    }

    /**
     * 思路：
     * 找到第一个>=target 值得坐标即可；
     * 如果nums[0]>target return 0 ;
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return searchArray(nums, 0, nums.length - 1, target);
    }

    public int searchArray(int[] nums, int begin, int end, int findInt) {
        if (findInt <= nums[0]) {
            return 0;
        }
        while (begin <= end) {
            int mid = (end + begin) / 2;
            if (nums[mid] <= findInt) {
                if (nums[mid] == findInt) {
                    return mid;
                }
                begin= mid+1;
            }else{
                end = mid-1;
            }
        }

        return end+1;
    }

}
// @lc code=end
