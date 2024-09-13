package org.solution283;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution283 {

    /**
     * 滑动窗口，维持一个0的窗口，每次扫描到非0元素，就与窗口的第一个元素交换，最右元素换成0，然后窗口右移。
     * @param nums 入参
     */
    public void moveZeroes(int[] nums) {
        if (nums == null)
            return;
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
