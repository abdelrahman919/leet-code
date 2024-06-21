package medium;

import java.util.*;
import java.util.stream.Collectors;
/*
https://leetcode.com/problems/longest-consecutive-sequence/submissions/1282922828/
* */
public class LongestConsecutiveSequence {
    //NOTE:
    //This problem required an o(n) time yet accepted answers with o(n log n) sort

    
    //1st solution without sorting the entire array
    static int run(int[] nums) {
        Set<Integer> consecutiveSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums) {
            int consecutive = num + 1;
            if (consecutiveSet.contains(consecutive)) {
                resultSet.add(consecutive);
                resultSet.add(num);
            }
        }
        int currentCount = 1;
        int max = 1;
        System.out.println(resultSet);
        List<Integer> list = new ArrayList<>(resultSet.stream().toList());
        Collections.sort(list);
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            int currentNum = list.get(i);
            int nextNum = list.get(i+1);
            if (nextNum - currentNum == 1) {
                currentCount++;
                if (currentCount > max) {
                    max = currentCount;
                }
            }else {
                 currentCount = 1;
            }
        }
        return max;
    }



    //2nd solution with sort
    static int run2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int currentCount = 1;
        int max = 1;
        for (int i = 0; i < length - 1; i++) {
            int currentNum = nums[i];
            int nextNum = nums[i + 1];
            if (nextNum - currentNum == 1) {
                currentCount++;
                if (currentCount > max) {
                    max = currentCount;
                }
            } else if (currentNum == nextNum) {

            } else {
                currentCount = 1;
            }

        }
        return max;
    }



    public static void main(String[] args) {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
//        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        int[] nums = new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
//        int[] nums = new int[]{0};
        int[] nums = new int[]{2,20,4,10,3,4,5};

        System.out.println(run(nums));
        System.out.println(run2(nums));









    }

}
