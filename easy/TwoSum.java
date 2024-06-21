package easy;

import java.util.*;
/*
https://leetcode.com/problems/two-sum/description/
* */
public class TwoSum {

    static int target = 9;
    static List<Integer> nums = List.of(11, 7, 2, 5);

    //////////////////////////////////////////////

    public static void main(String[] args) {

        Map<Integer, Integer> complementary = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int currentInt = nums.get(i);
            Integer i1 = complementary.get(currentInt);
            if (i1 != null) {
                System.out.println(Arrays.toString(new Integer[]{i1, i}));
            } else {
                complementary.put(target-currentInt, i) ;
            }

        }
















    }







}










