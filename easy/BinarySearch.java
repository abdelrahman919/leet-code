package easy;

public class BinarySearch {

    static int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (target < nums[middle]) {
                r = middle - 1;
            } else if (target > nums[middle]) {
                l = middle + 1;
            } else {
                return nums[middle];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}

