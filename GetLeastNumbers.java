import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author efraim.zhu
 * @Date 2020/6/19
 **/
public class GetLeastNumbers {
    /**
     输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

     示例 1：

     输入：arr = [3,2,1], k = 2
     输出：[1,2] 或者 [2,1]
     示例 2：

     输入：arr = [0,1,2,1], k = 1
     输出：[0]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public static void main(String[] args) {

        /**
         * 思路1： 每次取最小值；重复k次，则可以得到结果
         * 效率：O(k * O(n))
         *
         */
        int[] arr = {1, 3, 5, 7, 9, 15, 21};
        int k = 5;
        int[] ret = getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(ret));



    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> leastNumerHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2-t1;
            }
        });

        if (arr.length < k) {
            throw new RuntimeException("not valid");
        }
        for (int num : arr) {
            if (leastNumerHeap.size() < k) {
                leastNumerHeap.add(num);
            } else {
                if (num < leastNumerHeap.peek()) {
                    leastNumerHeap.poll();
                    leastNumerHeap.add(num);
                }
            }
        }

        int[] ret = new int[k];
        int i = 0;
        while (!leastNumerHeap.isEmpty()) {
            ret[i] = leastNumerHeap.poll().intValue();
            i++;
        }
        return ret;

    }
}
