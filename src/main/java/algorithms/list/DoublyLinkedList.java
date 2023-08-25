package algorithms.list;

import utils.DLNode;
import lombok.Data;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 3:31 PM
 */
@Data
public class DoublyLinkedList<T> {
    int size;
    DLNode<T> head;
    DLNode<T> tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean remove(DLNode<T> node) {
        assert node != null && size != 0;
        if(size == 1) {
            this.head = node;
            this.tail = node;
        } else {
            if (tail == node) {
                this.tail = node.prev;
                node.prev.next = null;
            } else if (head == node) {
                this.head = node.next;
                node.next.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
        size--;
        return true;
    }
    public DLNode<T> addFront(DLNode<T> node) {
        size++;
        if(head == null) {
            this.head = node;
            this.tail = node;
            return node;
        }
        node.next = head;
        head.prev = node;
        this.head = node;
        return node;
    }

    public DLNode<T> addFrontByValue(T value) {
        return addFront(new DLNode<>(value));
    }

    public void display() {
        DLNode<T> node = this.head;
        while (node != null) {
            node.show();
            node = node.next;
        }
        System.out.println();
    }
}
