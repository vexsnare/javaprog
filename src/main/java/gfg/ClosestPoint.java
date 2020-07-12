package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by vinaysaini on 7/7/16.
 * http://www.geeksforgeeks.org/closest-pair-of-points/
 * O n*log(n)*log(n)
 * Can be optimize upto nlogn if we keep track of sorted points by y-coordinates
 */
class ClosestPoint {
    public static void main(String[] args) {
        Point[] ar = { new Point(2, 7), new Point(12, 30), new Point(40, 50), new Point(5, 10), new Point(12, 10), new Point(3,4)
                ,new Point(0,5), new Point(0, 0), new Point(4,0)};
        Arrays.sort(ar, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        int n = ar.length;
        System.out.println(findClosest(ar, 0, n-1));
    }
    static double dist(Point p, Point q) {
        double x = p.x - q.x;
        double y = p.y - q.y;
        return Math.sqrt(x*x + y*y);
    }
    // BruteForce
    static double findSmallestDistByBruteForce(Point[] ar, int lo , int hi) {
        double d = Double.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            for (int j = i+1 ; j <= hi; j++) {
                if(dist(ar[i], ar[j]) < d) d = Math.min(d,dist(ar[i], ar[j]));
            }
        }
        return d;
    }

    static double findClosest(Point[] ar, int lo, int hi) {
        if(hi - lo <= 3) {
            return findSmallestDistByBruteForce(ar, lo, hi);
        }
        int mi = (lo + hi)/2;
        double dl = findClosest(ar, lo, mi);
        double dr = findClosest(ar, mi+1, hi);
        double d = Math.min(dl, dr);
        ArrayList<Point> strip = new ArrayList<Point>();
        for (int i = lo; i <= hi ; i++) {
            if(ar[mi].x - ar[i].x <= d) strip.add(ar[i]);
        }
        Collections.sort(strip, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i+1; j < strip.size() && strip.get(j).y - strip.get(i).y < d; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }
        }
        return d;
    }

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
