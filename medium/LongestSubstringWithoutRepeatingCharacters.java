package medium;

import java.util.*;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
* */
public class LongestSubstringWithoutRepeatingCharacters {


    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int max = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar) && l < map.get(currChar) + 1) {
                l = map.get(currChar) + 1;
            }
            map.put(currChar, i);
            max = i - l + 1;
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    
    //Same solution but ranks higher
    static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int max = 0;
        int l = 0;
        int i = 0;
        while (i < s.length()) {
            char currChar = s.charAt(i);
            if (!map.containsKey(currChar)) {
                map.put(currChar, i);
            } else {
                if (l < map.get(currChar) + 1) {
                    l = map.get(currChar) + 1;
                }
                map.put(currChar, i);
            }

            max = i - l + 1;
            if (max > result) {
                result = max;
            }
            i++;
        }

        return result;
    }


    public static void main(String[] args) {

//        String s = "dvdf";
//        String s = "dmklvabcvdf";
        String s = "thequickbrownfoxjumpsoverthelazydogthequickbrownfoxjumpsovert";
//        String s = "jumpsoverthelazydog";
//        lazydogthequickbr
        System.out.println(lengthOfLongestSubstring(s));


    }


}
