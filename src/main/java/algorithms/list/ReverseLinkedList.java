package algorithms.list;

public class ReverseLinkedList {

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    Node newHead;
    // Recursive
    Node reverse(Node currentNode) {
        if(currentNode.next == null) {
            newHead = currentNode;
            return currentNode;
        }
        Node prev = reverse(currentNode.next);
        currentNode.next = null;
        prev.next = currentNode;
        return currentNode;
    }

    //iterative
    Node reverse2(Node head) {
        Node first = null;
        Node second = head;
        while(second != null) {
            Node temp = second.next;
            second.next = first;;
            first = second;
            second = temp;
        }
        return first;
    }
    public static void main(String[] args) {

        Node h = new Node(1, new Node(2, new Node(3, new Node(4, null))));

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
       // reverseLinkedList.reverse(h);
       // Node rHead = reverseLinkedList.newHead;
        Node rHead = reverseLinkedList.reverse2(h);
        while ( rHead != null) {
            System.out.print(rHead.value + " -> ");
            rHead = rHead.next;
        }
    }
}
