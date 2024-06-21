package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 https://leetcode.com/problems/valid-anagram/submissions/1280619595/
*/

public class ValidAnagram {

    static boolean run(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] charArray = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        for (char c : charArray) {
            if (map1.putIfAbsent(c, 1) != null) {
                int value1 = map1.get(c) +1 ;
                map1.put(c, value1 );
            }
        }
        for (char c : charArray2) {
            if (map2.putIfAbsent(c, 1) != null) {
                int value1 = map2.get(c) +1 ;
                map2.put(c, value1 );
            }
        }
        return map1.equals(map2);
    }

    static boolean run2(String s, String t) {
        char[] charArray = s.toCharArray();
        char[] charArray1 = t.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray1);

        return Arrays.equals(charArray, charArray1);

    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

//        System.out.println(run(s, t));
        System.out.println(run2(s, t));


    }



}
