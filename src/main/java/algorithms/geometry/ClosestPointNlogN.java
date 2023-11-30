package algorithms.geometry;

import java.util.*;

/**
 * Created by vinaysaini on 7/7/16.
 * http://www.geeksforgeeks.org/closest-pair-of-points-onlogn-implementation/
 * O n*log(n)
 * ar_y : sorted points by y-coordinates
 */
class ClosestPointNlogN {
    public static void main(String[] args) {
        Point[] ar = { new Point(2, 7), new Point(12, 30), new Point(40, 50), new Point(5, 10),
                new Point(12, 10), new Point(3, 4), new Point(0, 5), new Point(0, 0), new Point(4, 0)};
        Arrays.sort(ar, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });
        List<Point> ar_y = Arrays.asList(ar);
        Collections.sort(ar_y, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });
        int n = ar.length;
        System.out.println(findClosest(ar,ar_y, 0, n-1));
    }
    static double dist(Point p, Point q) {
        double x = p.x - q.x;
        double y = p.y - q.y;
        return Math.sqrt(x*x + y*y);
    }
    // Brute Force
    static double findSmallestDistByBruteForce(Point[] ar, int lo , int hi) {
        double d = Double.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            for (int j = i+1 ; j <= hi; j++) {
                if(dist(ar[i], ar[j]) < d) d = Math.min(d,dist(ar[i], ar[j]));
            }
        }
        return d;
    }

    static double findClosest(Point[] ar, List<Point> ar_y, int lo, int hi) {
        if(hi - lo <= 3) {
            return findSmallestDistByBruteForce(ar, lo, hi);
        }
        int mi = (lo + hi)/2;
        // handling the case when x coordinates are same
        while (mi+1 <= hi && ar[mi+1].x == ar[mi].x) mi++;

        Point midPoint = ar[mi];
        List<Point> arLeftY = new ArrayList<Point>();
        List<Point> arRightY = new ArrayList<Point>();
        for (int i = 0; i < ar_y.size(); i++) {
            if (ar_y.get(i).x <= midPoint.x) {
                arLeftY.add(ar_y.get(i));
            } else {
                arRightY.add(ar_y.get(i));
            }
        }
        double dl = findClosest(ar, arLeftY, lo, mi);
        double dr = findClosest(ar, arRightY,  mi+1, hi);
        double d = Math.min(dl, dr);

        ArrayList<Point> strip = new ArrayList<Point>();
        for (int i = 0; i < ar_y.size() ; i++) {
            if(Math.abs(midPoint.x - ar_y.get(i).x) <= d) strip.add(ar_y.get(i));
        }
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
