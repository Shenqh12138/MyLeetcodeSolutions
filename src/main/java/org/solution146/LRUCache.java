package org.solution146;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node first = new Node();
    private final Node last = new Node();
    private final int capacity;
    private int size;

    public static class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;
        public Node(){

        }
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        first.next = last;
        last.pre = first;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null){
            //原链表中没有该元素--》将该元素存入链表头，并检查链表长度'
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > this.capacity) {
                cache.remove(last.pre.key);
                removeNode(last.pre);
                size--;
            }
        } else {
            //原链表中包含该元素-》将该元素存入链表头，并更新值，这个地方不是直接添加到头部，直接添加到头部会导致last指针异常
            node.value = value;
            moveToHead(node);
        }
    }

    public void removeNode(Node node){
        // 在原链表中删除当前node
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node){
        // 将该元素添加至链表头部
        node.pre = first;
        node.next = first.next;
        first.next.pre = node;
        first.next = node;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    @Test
    public void Test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put( 2, 1);
        lruCache.put( 1, 1);
        lruCache.put( 2, 3);
        lruCache.put( 4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
