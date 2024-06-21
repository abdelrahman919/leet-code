package medium;

/*
https://leetcode.com/problems/search-a-2d-matrix/description/
*/

public class Search2DMatrix {
    static boolean searchMatrix(int[][] matrix, int target) {
        int outerLength = matrix.length;
        int l = 0;
        int r = outerLength - 1;
        while (l <= r) {
        int middle = (l + r) / 2;
            if (target < matrix[middle][0]) {
                r = middle - 1;
            } else if (target > matrix[middle][matrix[middle].length - 1]) {
                l = middle + 1;
            } else {
                int[] searchArray = matrix[middle];
                l = 0;
                r = searchArray.length - 1;
                while (l <= r) {
                middle = (l + r) / 2;
                    if (target < searchArray[middle]) {
                        r = middle - 1;
                    } else if (target > searchArray[middle]) {
                        l = middle + 1;
                    } else {
                        return true;
                    }
                }
            }
            ////////////////////////
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix,13));
    }



}
