import java.util.*;

/**
 * @Author efraim.zhu
 * @Date 2020/6/19
 **/
public class TopKFrequent__347 {
    /**
     给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     示例 1:
     输入: nums = [1,1,1,2,2,3], k = 2
     输出: [1,2]
     示例 2:

     输入: nums = [1], k = 1
     输出: [1]
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public static void main(String[] args) {

        int[] arr = {1};
        int k = 1;
        Solution solution = new Solution();
        int[] ret = solution.topKFrequent(arr, k);
        System.out.println(Arrays.toString(ret));



    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length < k) {
                throw new RuntimeException("invalid input");
            }

            //sort
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num) + 1);
                } else {
                    map.put(num, 0);
                }
            }

            //top k
            PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(k, (t1, t2) ->
                    t1.getValue() - t2.getValue());

            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                if (priorityQueue.size() < k) {
                    priorityQueue.add(integerIntegerEntry);
                } else {
                    if (integerIntegerEntry.getValue() > priorityQueue.peek().getValue()) {
                        priorityQueue.poll();
                        priorityQueue.add(integerIntegerEntry);
                    }
                }

            }

            int[] ret = new int[k];
            int i = 0;
            while (i < k) {
                ret[i] = priorityQueue.poll().getKey();
                i++;
            }

            return ret;
        }
    }

}


