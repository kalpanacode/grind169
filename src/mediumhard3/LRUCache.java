// https://leetcode.com/problems/lru-cache/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard3;

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final DoublyLinkedList linkedList;

    private static class Node {
        int key;
        int val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        // Add node right after head (most recently used)
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a given node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Remove the last node (least recently used)
        Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        // Move node to front as recently used
        linkedList.remove(node);
        linkedList.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            // Move node to front
            linkedList.remove(node);
            linkedList.addFirst(node);
        } else {
            if (cache.size() == capacity) {
                // Remove LRU item
                Node lru = linkedList.removeLast();
                if (lru != null) {
                    cache.remove(lru.key);
                }
            }
            Node newNode = new Node(key, value);
            linkedList.addFirst(newNode);
            cache.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);                // cache is {1=1}
        lRUCache.put(2, 2);                // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1)); // returns 1
        lRUCache.put(3, 3);                // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2)); // returns -1 (not found)
        lRUCache.put(4, 4);                // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1)); // returns -1 (not found)
        System.out.println(lRUCache.get(3)); // returns 3
        System.out.println(lRUCache.get(4)); // returns 4
    }
}

