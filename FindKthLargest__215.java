import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author efraim.zhu
 * @Date 2020/6/19
 **/
public class FindKthLargest__215 {
    /**
     *
     * 215. 数组中的第K个最大元素
     *
     在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

     示例 1:

     输入: [3,2,1,5,6,4] 和 k = 2
     输出: 5
     示例 2:

     输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     输出: 4
     说明:

     你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public static void main(String[] args) {


        int[] arr = {3,2,1,5,6,4};
        int k = 2;
        Solution solution = new Solution();
        int ret = solution.findKthLargest(arr, k);
        System.out.println(ret);



    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);

            for (int num : nums) {
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(num);
                }else{
                    if (priorityQueue.peek() < num) {
                        priorityQueue.poll();
                        priorityQueue.offer(num);
                    }
                }
            }

            return priorityQueue.peek();
        }
    }

}


