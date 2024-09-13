package org.solution11;

import org.junit.Test;

public class Solution11 {

    @Test
    public void test() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。

     * @param height 高度数组
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int i = 0, j = height.length - 1, max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
