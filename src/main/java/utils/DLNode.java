package utils;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 3:32 PM
 */

public class DLNode<T> {
    public T value;
    public DLNode next;
    public DLNode prev;
    public DLNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public void show() {
        System.out.print(" -> " + this.value);
    }
}
