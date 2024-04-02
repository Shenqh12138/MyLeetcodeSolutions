package org.solution88;

import org.junit.Test;

import java.util.Arrays;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = nums1.length - 1; i >= 0; i--, j--) {
            nums1[j] = nums1[i];
        }
        int index = 0, nums1Index = n, nums2Index = 0;
        for (; index < nums1.length; index++) {
            if (nums1Index == m + n) {
                nums1[index] = nums2[nums2Index++];
                continue;
            }
            if (nums2Index == n) {
                break;
            }
            if (nums1[nums1Index] <= nums2[nums2Index]) {
                nums1[index] = nums1[nums1Index++];
            } else {
                nums1[index] = nums2[nums2Index++];
            }
        }
    }

    // 官方题解
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    @Test
    public void Test() {
        int[] nums1 = {0, 0, 0, 0};
        int m = 0;
        int[] nums2 = {4, 12, 16, 24};
        int n = 4;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
