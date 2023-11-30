package algorithms.search;

import java.util.PriorityQueue;

/**
 * Created by vinaysaini on 10/11/16.
 */

public class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((x, y)->y-x);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x,y)->x-y);

    public void addNum(int num) {
        if(maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if(num < maxHeap.peek()) {
            maxHeap.add(num);
            if(maxHeap.size() > (getTotalElement() + 1)/2) minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            if(minHeap.size() > getTotalElement()/2) maxHeap.add(minHeap.poll());
        }
    }
    public int getTotalElement() {
        return maxHeap.size() + minHeap.size();
    }

    // Returns the median of current data stream
    public double findMedian() {
        int N = getTotalElement();
        if(N%2 == 0) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else return maxHeap.peek();
    }

    public static void main(String[] args) {

        MedianFinder mf = new MedianFinder();
                mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);

//        mf.addNum(-1);
//
//        mf.addNum(-2);
//
//        mf.addNum(-3);
//        mf.addNum(-4);
        mf.addNum(-5);

        System.out.println(mf.findMedian());
    }
};

