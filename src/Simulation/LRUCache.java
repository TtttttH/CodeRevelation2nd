package Simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * No.146 LRUCache(middle)
 */
public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache = new HashMap<>(); //{key, Node}
    int size;
    int capacity;

    public LRUCache (int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        else {
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = val;
            moveToHead(node);
        } else {
            node = new Node(key, val);
            if (size == capacity) {
                removeLast();
                size --;
            }

            addToHead(node);
            cache.put(key, node);
            size ++;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void removeLast() {
        Node last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        cache.remove(last.key);
    }

    class Node {
        Node next;
        Node pre;
        int key;
        int val;
        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
