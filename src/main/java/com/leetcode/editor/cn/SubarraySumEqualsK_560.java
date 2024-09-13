//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2476 👎 0

package com.leetcode.editor.cn;

/**
 * 和为 K 的子数组
 *
 * @author shenqh12138
 * @date 2024-09-13 23:29:16
 */
public class SubarraySumEqualsK_560 {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK_560().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums.length == 0)
                return 0;
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = 0; j + i < nums.length; j++) {
                    sum += nums[i + j];
                    if (sum == k){
                        result++;
                        break;
                    }
                    if (sum > k)
                        break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}