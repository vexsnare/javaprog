import java.util.Scanner;

/**
 * Created by vinaysaini on 10/10/16.
 */
class SegmentTree {
    int[] st;
    SegmentTree(int[] ar) {
        int n = ar.length;
        int height = (int) Math.ceil(Math.log(n)/Math.log(2));
        int size = (int) Math.pow(2, height+1) - 1;
        st = new int[size];
        constructST(ar, 0, 0, n-1);
    }
    int getMid(int si, int ei) {
        return (si + ei) / 2;
    }
    boolean inInterval(int si, int ei, int i) {
        return i >= si && i <= ei;
    }
    int constructST(int[]ar, int i, int si, int ei) {
        if(si == ei) {
            st[i] = ar[si];
            return st[i];
        }
        int mi = getMid(si, ei);
        st[i] = constructST(ar, 2*i+1, si, mi) + constructST(ar, 2*i+2, mi+1, ei);
        return st[i];
    }

    void updateValue(int index, int diff, int si, int ei, int i) {
        if(si == ei) {
            st[i] += diff;
            return;
        }
        int mid = getMid(si, ei);
        if(inInterval(si, mid, index)) {
            updateValue(index, diff, si, mid, 2*i+1);
        } else {
            updateValue(index, diff, mid+1, ei, 2*i+2);
        }
        st[i] += diff;
    }

    int getSum(int l, int r, int si, int ei, int i) {
        if(l == si && r == ei) {
            return st[i];
        }
        int mi = getMid(si, ei);
        if(mi < l) return getSum(l, r, mi+1, ei, 2*i+2);
        if(r <= mi) return getSum(l, r, si, mi, 2*i+1);
        return getSum(l, mi, si, mi, 2*i+1) + getSum(mi+1,r, mi+1, ei, 2*i+2);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
       // int [] ar = {1,2,3,4,5};
        SegmentTree st = new SegmentTree(ar);
        for (int i = 0; i < st.st.length; i++) {
            System.out.print(st.st[i] + " ");
        }
        System.out.println();
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int qtype = in.nextInt();
            if(qtype == 1) {
                int index = in.nextInt();
                int newValue = in.nextInt();
                int diff = newValue - ar[index];
                st.updateValue(index, diff, 0, ar.length-1, 0);
            } else {
                int l = in.nextInt();
                int r = in.nextInt();
                System.out.println(st.getSum(l, r, 0, ar.length-1, 0));
            }
        }
    }
}
