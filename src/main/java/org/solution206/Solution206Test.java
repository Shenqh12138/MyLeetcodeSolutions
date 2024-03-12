package org.solution206;

import org.junit.Test;

public class Solution206Test {
    @Test
    public void test(){
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(listNode1);
        Solution206 solution206 = new Solution206();
        solution206.reverseList(listNode1);
        System.out.println(listNode1);
    }
}
