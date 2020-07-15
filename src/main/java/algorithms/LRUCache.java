package algorithms;

import commons.DLLNode;
import commons.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 4:49 PM
 */
public class LRUCache {

    private Map<Integer, DLLNode<Pair<Integer, Integer>>> store;
    private DoublyLinkedList<Pair<Integer, Integer>> doublyLinkedList;
    private int capacity;

    LRUCache(int size) {
        this.capacity = size;
        this.store = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public void set(int key, int value) {
        DLLNode<Pair<Integer, Integer>> node =  new DLLNode<>(new Pair<>(key, value));
        if (store.size() >= capacity) {
            DLLNode<Pair<Integer, Integer>> lastUsed = doublyLinkedList.getTail();
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
            DLLNode<Pair<Integer, Integer>> node  = store.get(key);
            doublyLinkedList.remove(node);
            doublyLinkedList.addFront(node);
            return node.value.second;
        }
    }

}
