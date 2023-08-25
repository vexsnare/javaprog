package algorithms.list; /**
 * Created by vinaysaini on 5/5/16.
 * Edit on 15-July-2020
 */

import utils.LNode;

import java.util.List;

/**
 * Singly linked list
 */
public class LinkedList {
    LNode head = null;

    LinkedList(List<Integer> values) {
        for (int i = 0; i < values.size(); i++) {
            addNodeAtStart(new LNode(values.get(i)));
        }
    }

    void addNodeAtStart(LNode x) {
        if(head == null) {
            head = x;
        } else {
            LNode rest = head;
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
                LNode temp = head;
                LNode prev = head;
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
    void addAtIndex(LNode x, int i) {
        if (i == 0) {
            x.next = head;
            head = x;
        } else {
            LNode temp = head;
            int index = 0;
            for (int j = 0; j < i - 1; j++) {
                temp = temp.next;
            }
            x.next = temp.next;
            temp.next = x;
        }
    }
    LNode reverseList(LNode x) {
        if(x.next==null) {
            head = x;
            return x;
        } else {
            LNode cur = reverseList(x.next);
            x.next = null;
            cur.next = x;
            return x;
        }
    }
    void addNodeAtEnd(LNode x) {
        if(head == null) head = x;
        else {
            LNode temp = head;
            while(temp.next != null) temp = temp.next;
            temp.next = x;
        }
    }

    void display() {
        LNode temp = head;
        while(temp != null) {
            System.out.print(temp.value + " - > ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

}


