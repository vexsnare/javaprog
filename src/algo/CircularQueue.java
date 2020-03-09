package algo;

import java.util.Scanner;

public class CircularQueue {
    int size = 3;
    int[] ar = new int[size];
    boolean full = false;
    int i = 0;
    int j = 0;
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

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int typeOfopr = scanner.nextInt();
            if(typeOfopr == 1) {
                circularQueue.push(scanner.nextInt());
            } else {
                System.out.println(circularQueue.pop());
            }
        }
    }
}
