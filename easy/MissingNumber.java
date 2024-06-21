package easy;

/*
https://leetcode.com/problems/missing-number/description/
*/
public class MissingNumber {

    static int missingNumber(int[] nums) {
        int max = 0;
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
            sum += num;
        }

        int calculatedSum =  ((max * (max + 1)) / 2 - (min * (min - 1))/ 2);

        if (calculatedSum == sum) {
            if (min == 1) {
                return 0;
            } else {
                return max + 1;
            }
        }
        return calculatedSum - sum;

    }


    public static void main(String[] args) {
//        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums = new int[]{1, 3,2};

        System.out.println(missingNumber(nums));
    }




}
