package medium;

public class SearchInRotatedSortedArray {

    static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        int minIndex = 0;
        while (l <= r) {
            int lNum = nums[l];
            int rNum = nums[r];
            if (lNum < rNum) {
                if (lNum < min) {
                    return l;
                } else {
                    return minIndex;
                }
            }
            int m = (l + r) / 2;
            int mNum = nums[m];
            if (mNum < min) {
                min = mNum;
                minIndex = m;
            }
            if (mNum >= lNum) {
                l = m + 1;
            } else {
                r = m - 1;

            }
        }
        return minIndex;
    }

    static int binarySearch(int[] nums, int start, int finish, int target) {
        int l = start;
        int r = finish;
        //Check if our target should be within current array before searching
        if (!(nums[l] <= target && target <= nums[r])) {
            return -1;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    //1st we find the minimum value and then split array into 2 sorted arrays
    //we do a binary search on each portion
    static int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int result = binarySearch(nums, minIndex, nums.length - 1, target);
        if (result != -1 || minIndex - 1 < 0) {
            return result;
        }
        result = binarySearch(nums,0,minIndex-1,target);
        return result;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 4, 5, 6, 1, 2};
//        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums,target));

    }






}
