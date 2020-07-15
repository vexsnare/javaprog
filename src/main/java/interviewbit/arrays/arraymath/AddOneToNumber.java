package interviewbit.arrays.arraymath;

import helpers.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class AddOneToNumber {

    private ArrayList<Integer> removeAllZeroAndRevert(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();
        int k = 0;
        while (input.get(k) == 0 && k < input.size() - 1) k++;

        for (int i = input.size()-1; i >= k ; i--) {
            result.add(input.get(i));
        }
        return result;
    }

    private ArrayList<Integer> plusOne(ArrayList<Integer> input) {
        ArrayList<Integer> result;
        if(input.isEmpty()) {
            return new ArrayList<>();
        }
        result = removeAllZeroAndRevert(input);
        int carry = 1;
        int i = 0;
        while (carry > 0 && i < result.size()) {
            int d = result.get(i) + carry;
            result.set(i, d%10);
            carry = d / 10;
            i++;
        }
        if(carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(9);
        input.add(9);
        input.add(9);
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        List<Integer> result = addOneToNumber.plusOne(input);
        new Printer<Integer>().printList(result, ",");

    }

}




