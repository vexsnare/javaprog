package algo; /**
 * Created by vinaysaini on 5/5/16.
 */

/**
 * Singly linked list
 */
public class LinkedList {
    static Node head = null;
    public static void main(String[] args) {
        init();
        display();
        deleteNodeByValue(4);
        deleteNodeByValue(100);
        deleteNodeByValue(100);
        deleteNodeByValue(4);

        display();
        addAtIndex(new Node(55), 2);
        display();
        addAtIndex(new Node(0), 0);
        display();
        reverseList(head);
        display();
    }
    static void init() {
        int[] ar = {4,3,2,15,8,19,21,4,90};
        for (int i = 0; i < ar.length; i++) {
            int value = ar[ar.length-i-1];
            addNodeAtStart(new Node(value));
        }
        addNodeAtEnd(new Node(100));
    }
    static void addNodeAtStart(Node x) {
        if(head == null) {
            head = x;
        } else {
            Node rest = head;
            x.next = rest;
            head = x;
        }
    }

    static void deleteNodeByValue(int v) {
        boolean isDeleted = false;
        if (head == null) isDeleted = true;
        else {
            if(head.value == v) {
                head = head.next;
                isDeleted = true;
            }
            else {
                Node temp = head;
                Node prev = head;
                temp = temp.next;
                while (temp != null && temp.value != v) {
                    prev = temp;
                    temp = temp.next;
                }
                if(temp != null) {
                    prev.next = temp.next;
                    isDeleted = true;
                }
            }
        }
        if(!isDeleted) {
            System.out.println("No such value exist: " + v);
        }
    }
    static void addAtIndex(Node x, int i) {
        if (i == 0) {
            x.next = head;
            head = x;
        } else {
            Node temp = head;
            int index = 0;
            for (int j = 0; j < i - 1; j++) {
                temp = temp.next;
            }
            x.next = temp.next;
            temp.next = x;
        }
    }
    static Node reverseList(Node x) {
        if(x.next==null) {
            head = x;
            return x;
        } else {
            Node cur = reverseList(x.next);
            x.next = null;
            cur.next = x;
            return x;
        }
    }
    static void addNodeAtEnd(Node x) {
        if(head == null) head = x;
        else {
            Node temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = x;
        }
    }

    static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " - > ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            next = null;
        }
    }
}


