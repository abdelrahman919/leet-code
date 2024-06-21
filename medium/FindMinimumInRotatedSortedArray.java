package medium;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/1288058990/
* */
public class FindMinimumInRotatedSortedArray {


    //1st solution
    /*    static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            int m = (l + r) / 2;
            int lNum = nums[l];
            int mNum = nums[m];
            int rNum = nums[r];
            if (lNum > rNum) {
                //if both l and m nums are greater the rnum
                //then the portion l->m is part of the greater portion of array and we can skip
                if (mNum > rNum) {
                    l = m + 1;
                    //if mNun is smaller than rNum it means it lies within the smaller portion, so we move r to m
                } else {
                    r = m;
                }
                //To break while condition after result is found
            } else {
                l++;
                if (lNum < min) {
                    min = lNum;
                }
            }
        }
        return min;
    }*/




    //2nd solution
    //same idea but cleaner code with less conditions
    static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l <= r) {
            int lNum = nums[l];
            int rNum = nums[r];
            if (lNum < rNum) {
                return Math.min(lNum, min);
            }
            int m = (l + r) / 2;
            int mNum = nums[m];
            min = Math.min(min, mNum);
            if (mNum >= lNum) {
                l = m + 1;
            } else {
                r = m - 1;

            }
        }
        return min;
    }



    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
//        int[] nums = new int[]{1,2,3,4,5,6,7,0};
//        int[] nums = new int[]{3,4,5,6,1,2};
//        int[] nums = new int[]{4,5,0,1,2,3};
        int[] nums = new int[]{2,1};
//        int[] nums = new int[]{5, 1, 2, 3, 4};
//        int[] nums = new int[]{3,4,5,1,2};
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));

    }

}



