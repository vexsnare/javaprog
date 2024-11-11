package nov7_2024.search;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
public class Search2dMatrix {

    // We start from top right corner, why ?
    // since this point has property that all left elements are less
    // and all down elements are greater than current element making it pivot points to decide which way to go

    private boolean inRange(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i <= matrix.length - 1 && j >= 0) {
            if(target == matrix[i][j]) return true;
            if(target > matrix[i][j]) i++;
            else j--;
        }
        return false;
    }
}
