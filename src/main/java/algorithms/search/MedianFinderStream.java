package algorithms.search;

import java.util.PriorityQueue;

/**
 * @author vinay.saini
 * @created 02/08/2020 - 10:43 PM
 */
public class MedianFinderStream {

    PriorityQueue<Integer> minQ = new PriorityQueue<>();
    PriorityQueue<Integer> maxQ = new PriorityQueue<>((x, y) -> y -x);

    public void addNum(int num) {
        if(maxQ.isEmpty()) {
            maxQ.add(num);
            return;
        }
        if(num <= maxQ.peek()) {
            minQ.add(maxQ.poll());
            maxQ.add(num);
        } else {
            if(minQ.size() < maxQ.size()) {
                minQ.add(num);
            } else {
                maxQ.add(minQ.poll());
                minQ.add(num);
            }
        }
    }

    public double findMedian() {
        int n1 = maxQ.size();
        int n2 = minQ.size();
        if(n1 == 0) {
            return 0;
        }
        if((n1+n2)%2 != 0) {
            return maxQ.peek();
        } else {
            return (minQ.peek() + maxQ.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinderStream medianFinderStream = new MedianFinderStream();
        medianFinderStream.addNum(1);
        medianFinderStream.addNum(2);
        medianFinderStream.addNum(3);
        System.out.println(medianFinderStream.findMedian());
    }
}
