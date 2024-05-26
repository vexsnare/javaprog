package psds.queue;

/**
 *
 * Implement a circular queue so that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new value
 *
 **/


// https://leetcode.com/problems/design-circular-queue/description/

public class CircularQueue {
    int size;
    int[] ar;
    boolean full;
    int i = 0;
    int j = 0;

    CircularQueue(int size) {
        this.size = size;
        this.full = false;
        ar = new int[size];
    }
    public int pop() {
        if(!full && i == j) {
            System.out.println("Empty");
            return -1;
        }
        if(full) full = false;
        int num = ar[i];
        i = (i+1) % size;
        return num;
    }

    public void push(int x) {
        if(full) {
            System.out.println("Can't its full");
            return;
        }
        ar[j] = x;
        System.out.println("Pushed " + x);
        j = (j + 1 ) % size;
        if(i == j) {
            full = true;
        }
    }

}
