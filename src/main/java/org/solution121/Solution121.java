package org.solution121;

import org.junit.Test;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    @Test
    public void maxProfitTest() {
        System.out.println(maxProfit(new int[]{1, 2}));
    }
}
