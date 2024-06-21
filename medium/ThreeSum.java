package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/description/

*/

public class ThreeSum {


    //2nd solution
    //Much more memory efficient and a lot faster
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            twoSum(outerList ,nums, i, length);
        }
        return outerList;
    }

    static void twoSum(List<List<Integer>> outerList, int[] sortedNums, int i, int length) {
        //Eliminating duplicate results since array is sorted
        if (i > 0 && sortedNums[i] == sortedNums[i-1]) {
            return;
        }
        int searchTarget = -sortedNums[i];
        int l = i+1;
        int r = length - 1;
        while (l < r) {
            if (sortedNums[l] + sortedNums[r] == searchTarget) {
                outerList.add(Arrays.asList(
                        sortedNums[i],
                        sortedNums[l],
                        sortedNums[r]
                ));
                l++;
                //If the current num is equal to the next Keep incrementing until the
                while (sortedNums[l] == sortedNums[l - 1] && l < r) {
                    l++;
                }
            }
            if (sortedNums[l] + sortedNums[r] < searchTarget) {
                l++;
            } else {
                r--;
            }

        }
    }




    /*
    1st solution
    slow and not memory efficient

static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> outerList = new HashSet<>();
    Arrays.sort(nums);
    int length = nums.length;
    for (int i = 0; i < length-2; i++) {
        twoSum(outerList ,nums, i, length);
    }
    return outerList.stream().toList();
}


    static void twoSum(Set<List<Integer>> outerList, int[] sortedNums, int i, int length) {
        List<Integer> innerList = new ArrayList<>();
        int searchTarget = -sortedNums[i];
        int l = i+1;
        int r = length - 1;
        while (l < r) {
            innerList = new ArrayList<>();
            int ln = sortedNums[l];
            int rn = sortedNums[r];
            int in = sortedNums[i];
            if (sortedNums[l] + sortedNums[r] == searchTarget) {
                innerList.add(sortedNums[i]);
                innerList.add(sortedNums[l]);
                innerList.add(sortedNums[r]);
                    outerList.add(innerList);
                l++;
                continue;
            }
            if (sortedNums[l] + sortedNums[r] < searchTarget) {
                l++;
            } else {
                r--;
            }

        }
    }*/


    public static void main(String[] args) {
        int[] numbers = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] numbers = new int[]{0,1,1};
//        int[] numbers = new int[]{1,2,-2,-1};
//        int[] numbers = new int[]{-2,0,1,1,2};
//        int[] numbers = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(threeSum(numbers));


    }

}
