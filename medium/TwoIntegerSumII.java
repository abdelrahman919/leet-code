package medium;

import java.util.Arrays;

/*
https://neetcode.io/problems/two-integer-sum-ii
* */
public class TwoIntegerSumII {

    static int[] run(int[] numbers, int target) {
        int length = numbers.length;

        //Perform binary search on each element
        for (int i = 0; i < length; i++) {
            //Calculate the complementary for the current number
            int searchTarget = target - numbers[i];
            //left is i+1 because we are searching for complementary of current number (i)
            //And to avoid re searching since all numbers on left can be considered invalid
            int l = i + 1;
            int r = length - 1;
            //Binary search for the element
            while (l <= r) {
            int middle = (l + r) / 2;
                if (numbers[middle] == searchTarget) {
                    return new int[]{i+1, middle+1};
                }
                if (searchTarget > numbers[middle]) {
                    l = middle + 1;
                }
                else {
                    r = middle - 1;
                }
            }
        }

        return new int[0];

    }

    //More optimised o(n) solution
    //start at the 2 edges of the array and add the value of the 2 pointers
    //if it's bigger than target move right pointer to the left since array is sorted ascendingly
    //if it's smaller move the left pointer to the right
    static int[] run2(int[] numbers, int target) {
        int length = numbers.length;
        int[] result = new int[2];
        int l = 0;
        int r = length -1;
        while (l < r) {
            if (numbers[r] + numbers[l] == target) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }
            if (numbers[r] + numbers[l] > target) {
                r--;
            }else {
                l++;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4};
        int target = 3;
        System.out.println(Arrays.toString(run2(numbers, target)));

    }

}
