package org.solution128;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class Solution128 {

    /**
     *
     * 解题思路，滑动窗口
     * @param args 参数数组
     * @return 最长序列（不要求序列元素在原数组中连续）的长度
     */
    public int longestConsecutive(int[] args) {
        int[] nums = removeDuplicatesAndSort(args);
        if (nums.length <= 1)
            return nums.length;
        int start = 0, index = 1, end = 1, sub = 1;
        for (; index < nums.length; index++) {
            if (nums[index] - nums[index - 1] == 1) {
                // 符合条件则窗口往后扩大
                end++;
            } else {
                // 否则重置窗口
                start = end;
                end++;
            }
            // 暂存窗口最大值
            if (end - start > sub)
                sub = end - start;
        }
        return sub;
    }

    private static int[] removeDuplicatesAndSort(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (int num : set) {
            result[i++] = num;
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
