
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

//todo 还没通过
// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int[] test = { 1, 3, 5, 6 };
    
        return searchArray(test, 0, test.length - 1, target);
    }

    public int searchArray(int[] nums, int begin, int end, int findInt) {
        if (begin >= end) {
            if(nums[end] == findInt){
                return end;
            } else if((end-1)>=0 ){
                return end-1;
            }
            return end+1;
        }
        int mid = (end + begin) / 2;
        if (nums[mid] < findInt) {
            return searchArray(nums, mid + 1, end, findInt);
        }
        if (nums[mid] == findInt) {
            return mid;
        }
        return searchArray(nums, begin, end - 1, findInt);

    }

}
// @lc code=end
