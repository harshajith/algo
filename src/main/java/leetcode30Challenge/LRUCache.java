package leetcode30Challenge;


import java.util.HashMap;

/**
 * LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 /* capacity *)
 * /**
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity = 0;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            remove(current);
            addFirst(current);
            return current.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            if (map.containsKey(key)) {
                Node current = map.get(key);
                remove(current);
                Node newNode = new Node(key, value);
                addFirst(newNode);
            } else {
                Node newNode = new Node(key, value);
                remove(tail);
                addFirst(newNode);
            }
        } else {
            Node newNode = new Node(key, value);
            addFirst(newNode);
        }
    }

    public void addFirst(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;

        if (tail == null) {
            tail = head;
        }
        map.put(node.key, node);
    }


    public void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        map.remove(node.key);
    }

    public static class Node {
        Node next;
        Node prev;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }




}
