package medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/
* */
public class ProductOfArrayExceptSelf {

    static int[] run(int[] nums) {
        int currentProduct = 1;
        int length = nums.length;
        int[] suffixProduct = new int[length];
        int[] result = new int[length];
        //Populating the suffix array
        for (int i = length-1; i >= 0; i--) {
            currentProduct *= nums[i];
            suffixProduct[i] = currentProduct;
        }
        currentProduct = 1;
        //Populating the input array with prefix products
        for (int i = 0; i < length; i++) {
            currentProduct *= nums[i];
            nums[i] = currentProduct;
        }
        for (int i = 0; i < length; i++) {
            int prefixIndex = i - 1;
            int suffixIndex = i + 1;
            if (i == 0) {
                result[i] = suffixProduct[1];
                continue;
            } else if (i == length - 1) {
                result[i] = nums[length-2];
                continue;
            }
            result[i] = suffixProduct[suffixIndex] * nums[prefixIndex];
        }

        return result;

    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
//        int[] nums = new int[]{-1,1,0,-3,3};


        System.out.println(Arrays.toString(run(nums)));

    }





}
