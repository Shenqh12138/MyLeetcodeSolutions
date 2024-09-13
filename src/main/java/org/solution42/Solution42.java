package org.solution42;

import org.junit.Test;

import java.util.HashSet;

public class Solution42 {
    /**
     * 动态规划法
     * @param height 高度
     * @return 返回
     */
    public int trap(int[] height) {
        // 记录每一个节点的左、右的最高高度
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int water = 0;
        left[0] = right[height.length - 1] = 0;
        // 生成节点的左右最高高度
        for (int i = 1; i < height.length - 1 ; i++){
            left[i] = Math.max(left[i - 1], height[i - 1]);
            right[height.length - 1 - i] = Math.max(right[height.length - i], height[height.length - i]);
        }
        // 记录每一个节点的水
        for (int j = 1;j<height.length - 1; j++){
            water += Math.max(0, Math.min(left[j], right[j]) - height[j]);
        }
        return water;
    }

    @Test
    public void test(){
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0)
            return 0;
        int result = 0, i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (j<s.length()){
            if (set.add(s.charAt(j))){
                j++;
            } else {
                result = Math.max(result, j-i);
                i++;
                j++;
            }
        }
        return result;
    }
}
