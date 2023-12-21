package algorithms.app;

import algorithms.list.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 4:49 PM
 */
public class LRUCache {

    static class Pair {
        int first;
        int second;
        Pair(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }

    private Map<Integer, DoublyLinkedList.DLNode> store;
    private DoublyLinkedList<Pair> doublyLinkedList;
    private int capacity;

    LRUCache(int size) {
        this.capacity = size;
        this.store = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public void set(int key, int value) {
        DoublyLinkedList.DLNode<Pair> node =  new DoublyLinkedList.DLNode<>(new Pair(key, value));
        if (store.size() >= capacity) {
            DoublyLinkedList.DLNode<Pair> lastUsed = doublyLinkedList.getTail();
            store.remove(lastUsed.value.first);
            doublyLinkedList.remove(lastUsed);
        }
        store.put(key, node);
        doublyLinkedList.addFront(node);
    }

    public int get(int key) {
        if(!store.containsKey(key)) {
            return -1;
        } else {
            DoublyLinkedList.DLNode<Pair> node  = store.get(key);
            doublyLinkedList.remove(node);
            doublyLinkedList.addFront(node);
            return node.value.second;
        }
    }

}
