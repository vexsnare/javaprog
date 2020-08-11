package interviewbit.arrays.simulationarray;

import helpers.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/pascal-triangle/
 */
public class PascalTriangle {

    private List<List<Integer>> solve(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n <= 0) return ans;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for (int row = 1; row <= n; row++) {
            temp = new ArrayList<>();
            for (int i = 0; i <= row; i++) {
                int lastIndex = ans.size() - 1;
                List<Integer> last = ans.get(lastIndex);
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
        List<List<Integer>> ans = pascalTriangle.solve(5);
        for (List<Integer> ar: ans) {
            Printer.print(ar);
        }
    }
}
