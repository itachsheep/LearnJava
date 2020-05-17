package com.hr收集腾讯笔试;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class _8_实现Lru算法 {
    public static void main(String[] args) {

    }
}

/**
 * https://leetcode-cn.com/problems/lru-cache/solution/san-chong-fang-fa-dai-ni-shou-si-lrusuan-fa-javaba/
 *
 * 1，使用LinkedHashMap实现
 * 在Java中，其实LinkedHashMap已经实现了LRU缓存淘汰算法，
 * 需要在构造函数第三个参数传入true，表示按照时间顺序访问。可以直接继承LinkedHashMap来实现。
 *
 * 但是LinkedHashMap会自动扩容，如果想实现限制容量删除队列顶端元素，
 * 需要重写removeEldestEntry()方法，当map里面的元素个数大于了缓存最大容量，删除链表的顶端元素。
 *
 * @param <K>
 * @param <V>
 */
class LruLinkedHashMap<K,V> extends LinkedHashMap {
    private int capacity;
    public LruLinkedHashMap(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry entry) {
        return size() > capacity;
    }
}


/**
 * 2, 使用双向链表结构+HashMap实现
 * 相当于重新实现了 linkedHashmap
 *
 *
 * @param <K>
 * @param <V>
 */
class LruCache<K,V> {
    class Node {
        public V val;
        public K key;
        public Node next;
        public Node pre;
        public Node(K k, V x) {
            key = k;
            val = x; }
    }

    private int size;
    private HashMap<K, Node> map;
    private Node head;
    private Node tail;

    LruCache(int size) {
        this.size = size;
        map = new HashMap<>();
    }

    /**
     * 添加元素
     * 1.元素存在，将元素移动到队尾
     * 2.不存在，判断链表是否满。
     * 如果满，则删除队首元素，放入队尾元素，删除更新哈希表
     * 如果不满，放入队尾元素，更新哈希表
     */
    public void put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            //更新值
            node.val = value;
            moveNodeToTail(node);
        } else {
            Node newNode = new Node(key, value);
            //链表满，需要删除首节点
            if (map.size() == size) {
                Node delHead = removeHead();
                map.remove(delHead.key);
            }
            addLast(newNode);
            map.put(key, newNode);
        }
    }

    public void moveNodeToTail(Node node) {
        if (tail == node) {
            return;
        }
        if (head == node) {
            head = node.next;
            head.pre = null;
        } else {
            //调整双向链表指针
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.pre = tail;
        node.next = null;
        tail.next = node;
        tail = node;
    }


    public void addLast(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            //连接新节点
            tail.next = newNode;
            newNode.pre = tail;
            //更新尾节点指针为新节点
            tail = newNode;
        }
    }

    public Node removeHead() {
        if (head == null) {
            return null;
        }
        Node res = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = res.next;
            head.pre = null;
            res.next = null;
        }
        return res;
    }

}
