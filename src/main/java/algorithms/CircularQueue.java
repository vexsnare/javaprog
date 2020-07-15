package algorithms;

import java.util.Scanner;

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
