package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TopKFrequentElements {

    static int[] run(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] result = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        return result;


    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(run(nums, k)));


    }



}
