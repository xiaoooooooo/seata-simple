package com.order.leet;

import java.util.HashMap;

/**
 * 双向链表+hashmap实现lru
 * @author xiaojw
 * @describe LruList
 * @date 2021/1/28 16:13
 */
public class LruMap<K,V> {

    private HashMap<K,Node<V>> map = new HashMap<>();
    private int count;
    private int capacity;
    private Node head;
    private Node end;
    public LruMap(int size){
        capacity = size;
    }

    public boolean put(K key,V val){
        Node<V> node = Node.<V>builder().val(val).build();
        Node tmp = head;
        head = node;
        head.setNext(tmp);
        count++;
        removeEldestNode();
        map.put(key,node);
        return true;
    }

    private void removeEldestNode() {
        if(count>capacity){

        }
    }

    public V get(K key){
        Node<V> node = map.get(key);
        moveToHead(node);
        return node.getVal();
    }

    private void moveToHead(Node<V> node) {
//        if(node.)
    }
}
