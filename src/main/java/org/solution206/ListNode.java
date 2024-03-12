package org.solution206;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (ListNode next = this; next!=null;next = next.next){
            str.append(next.val).append("  ");
        }
        return str.toString();
    }
}
