package commons;

/**
 * @author vinay.saini
 * @created 15/07/2020 - 3:32 PM
 */

public class DLLNode<T> {
    public T value;
    public DLLNode next;
    public DLLNode prev;
    public DLLNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public void show() {
        System.out.print(" -> " + this.value);
    }
}
