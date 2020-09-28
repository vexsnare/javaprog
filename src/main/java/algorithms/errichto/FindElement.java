package algorithms.errichto;

/**
 * @author vinay.saini
 * @created 22/09/2020 - 8:11 PM
 */
public class FindElement {
    int findIndex(int[] ar, int x, boolean searchLeft) {
       int lo = 0;
       int hi = ar.length - 1;
       int idx = -1;
       while(lo <= hi) {
           int m = lo + (hi-lo)/2;
           if(ar[m] < x) {
               lo = m + 1;
           } else if(ar[m] > x){
               hi = m - 1;
           } else {
               idx = m;
               if(searchLeft) {
                   hi = m - 1;
               } else lo = m + 1;
           }
       }
       return idx;
    }


    public static void main(String[] args) {
        FindElement findElement = new FindElement();
        int[] ar = {1,2,2,2,2,2,3,3,3,4};
        int startIndex = findElement.findIndex(ar, 2, true);
        int endIndex = findElement.findIndex(ar, 2, false);
        System.out.println(startIndex + " " + endIndex);
    }
}
