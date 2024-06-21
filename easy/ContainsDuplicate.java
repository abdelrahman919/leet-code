package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    static boolean run(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int currentNum : nums) {
            if (!set.add(currentNum)) {
                return true;
            }
        }
        return false;

    }



    public static void main(String[] args) {
        int[] nums ={1,2,3,1};
        System.out.println(run(nums));


    }




}
