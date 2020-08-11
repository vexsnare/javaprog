package adhoc;/* IMPORTANT: Multiple classes and nested static classes are supported */


//uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Record implements Comparable<Record> {
    public int gcd;
    public int i;
    public int j;

    Record(int x, int y, int z) {
        this.gcd = x;
        this.i = y;
        this.j = z;
    }

    public int compareTo(Record r) {
        return -this.gcd + r.gcd;
    }

}

class TestClass {
    List<Record> records = new ArrayList<>();

    private int gcd(int x, int y) {
        if(x == 0) return y;
        return gcd(y%x, x);
    }



    boolean isTaken(boolean [] taken, int i, int j) {
        for(int t = 0; t < taken.length; t++) {
            if(t == i && taken[i]) return true;
            if(t == j && taken[j]) return true;
        }
        return false;
    }

    private int solve(int[] ar, int n) {
        for(int i = 0; i < 2*n; i++) {
            for(int j = i+1; j < 2*n; j++) {
                int gcd = gcd(ar[i], ar[j]);
                records.add(new Record(gcd, i, j));
            }
        }
        Collections.sort(records);
        boolean [] taken = new boolean[2*n];
        int score = 0;
        int round = n;
        for(int k = 0; k < records.size(); k++) {
            int g = records.get(k).gcd;
            int i = records.get(k).i;
            int j = records.get(k).j;
            if(!isTaken(taken, i, j)) {
                taken[i] = true;
                taken[j] = true;
                score += g * round;
                round--;
            }
        }
        return score;
    }


    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */

        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[2*n];
        for(int i = 0; i < 2*n; i++) {
            ar[i] = s.nextInt();
        }

        TestClass tc = new TestClass();
        tc.solve(ar, n);


        // Write your code here

    }
}
