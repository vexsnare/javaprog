package interviewbit.arrays.simulationarray;

import helpers.Printer;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/pascal-triangle/
 */
public class PascalTriangle {

    private ArrayList<ArrayList<Integer>> solve(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(n <= 0) return ans;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for (int row = 1; row <= n; row++) {
            temp = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                int lastIndex = ans.size() - 1;
                ArrayList<Integer> last = ans.get(lastIndex);
                if (i - 1 >= 0 && i < last.size()) {
                    temp.add(last.get(i) + last.get(i - 1));
                } else temp.add(1);

            }
            ans.add(temp);
        }
        return ans;

    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle= new PascalTriangle();
        ArrayList<ArrayList<Integer>> ans = pascalTriangle.solve(5);
        Printer<Integer> printHelper = new Printer<>();
        for (ArrayList<Integer> ar: ans) {
            printHelper.printList(ar, ",");
        }
    }
}
