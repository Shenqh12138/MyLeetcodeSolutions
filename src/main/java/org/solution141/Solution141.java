package org.solution141;

import java.util.HashMap;

public class Solution141 {
    // 环形链表三连问： 1. 是否有环 2. 找出环的入口 3. 环中节点个数
    public boolean hasCycle(ListNode head) {
        // hashtable
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head != null){
            if (!map.containsKey(head.next)){
                map.put(head.next, 0);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
