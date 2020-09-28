package algorithms.list; /**
 * Created by vinaysaini on 5/5/16.
 * Edit on 15-July-2020
 */

import commons.LLNode;

import java.util.List;

/**
 * Singly linked list
 */
public class LinkedList {
    LLNode head = null;

    LinkedList(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            addNodeAtStart(new LLNode(values.get(i)));
        }
    }

    void addNodeAtStart(LLNode x) {
        if(head == null) {
            head = x;
        } else {
            LLNode rest = head;
            x.next = rest;
            head = x;
        }
    }

    void deleteNodeByValue(int v) {
        boolean isDeleted = false;
        if (head == null) isDeleted = true;
        else {
            if(head.value == v) {
                head = head.next;
                isDeleted = true;
            }
            else {
                LLNode temp = head;
                LLNode prev = head;
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
    void addAtIndex(LLNode x, int i) {
        if (i == 0) {
            x.next = head;
            head = x;
        } else {
            LLNode temp = head;
            int index = 0;
            for (int j = 0; j < i - 1; j++) {
                temp = temp.next;
            }
            x.next = temp.next;
            temp.next = x;
        }
    }
    LLNode reverseList(LLNode x) {
        if(x.next==null) {
            head = x;
            return x;
        } else {
            LLNode cur = reverseList(x.next);
            x.next = null;
            cur.next = x;
            return x;
        }
    }
    void addNodeAtEnd(LLNode x) {
        if(head == null) head = x;
        else {
            LLNode temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = x;
        }
    }

    void display() {
        LLNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " - > ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

}


