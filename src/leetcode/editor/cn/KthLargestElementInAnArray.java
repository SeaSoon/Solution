//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1755 👎 0

package leetcode.editor.cn;

import java.util.Random;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] a, int l, int r, int index) {
            int q = randomPartition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                // 闭区间，所以有+1 -1
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        private int randomPartition(int[] a, int l, int r) {
            // + l 防止index比l小 + 1是为了防止bound是0？0的话报异常
            int i = this.random.nextInt(r - l + 1) + l;
            swap(a, i, r);
            return partition(a, l, r);
        }

        private int partition(int[] a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; j++) {
                if (a[j] <= x) {
                    swap(a, ++i, j);
                }
            }
            // 最终x的位置在i+1处
            swap(a, i + 1, r);
            return i + 1;
        }

        private void swap(int[] a, int i, int r) {
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}