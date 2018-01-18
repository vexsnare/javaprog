package algo;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    QueueDll q;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        q = new QueueDll();
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            q.deleteNode(node);
            q.addNodeInFront(node);
            return node.value;
        } else return -1;
    }
    public void display() {
        q.display();
       // q.displayReverse();
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            System.out.println("value = " + node.value);
            node.value = value;
            q.deleteNode(node);
            System.out.println("#");q.display();
            q.addNodeInFront(node);
        } else {
            Node newNode = new Node(key, value);
            if(q.size == capacity) {
                Node lastNode = q.getLastNode();
                map.remove(lastNode.key);
                q.deleteNode(lastNode);
            }
            q.addNodeInFront(newNode);
            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.set(2, 1);
        lru.display();


        lru.set(1, 1);
        lru.display();

        System.out.println(lru.get(2));
        lru.set(4, 1);
        lru.display();

        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}

class Node {
    int value;
    int key;
    Node next;
    Node prev;
    Node(int k, int v) {
        this.value = v;
        this.key = k;
        this.next = null;
        this.prev = null;
    }
}

class QueueDll {
    int size;
    Node head;
    Node last;

    QueueDll() {
        this.size = 0;
        head = null;
        last = null;
    }

    Node addNodeInFront(Node node) {
        if (head == null) {
            head = node;
            node.prev = null;
            last = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            node.prev = null;
        }
        size++;
        return head;
    }

    Node deleteNode(Node node) {
        if (node.next == null) {
            if (node.prev == null) {
                head = null;
                last = head;
            } else {
                last = node.prev;
                node.prev.next = null;
            }
        } else if(node.prev == null) {
            node.next.prev = node.prev;
            head = node.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return head;
    }

    Node getLastNode() {
        return last;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("- [" + temp.key + ", " + temp.value + "]");
            temp = temp.next;
        }
        System.out.println();
    }

    void displayReverse() {
        Node temp = last;
        while (temp != null) {
            System.out.print("> [" + temp.key + ", " + temp.value + "]");
            temp = temp.prev;
        }
        System.out.println();
    }

}