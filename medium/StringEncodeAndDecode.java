package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://neetcode.io/problems/string-encode-and-decode
* */
public class StringEncodeAndDecode {
    //NOTE:
    //You are not allowed to use global variables to solve this problem
    //Both encode and decode have to be stateless
    //Which I didn't know and had to rewrite my code :D

    static String encode(List<String> strs) {
        char delimiter = '@';
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            //For ex: "h i" will be "3@h i"
            builder.append(str.length()).append(delimiter).append(str);
        }
        return builder.toString();
    }

    static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int length = str.length();
        int subStringLen;
        //This condition is to check empty lists
        while (length > 0) {
            StringBuilder subStrLenStr = new StringBuilder();
            //Extract string length
            for (int j = i; j < length; j++) {
                if (str.charAt(j) == '@') {
                    //i now points at the 1st char of the string
                    i = j + 1;
                    break;
                }
                //Collecting the length as string
                subStrLenStr.append(str.charAt(j));
            }
            subStringLen = Integer.parseInt(subStrLenStr.toString());
            //Extracting sub string and reassigning i to point at the
            //length of the next substring
            list.add(str.substring(i, i += subStringLen));
            if (i >= length) {
                break;
            }

        }
        return list;
    }
    




    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of(
                "The quick brown fox","jumps over the","lazy dog",
                "1234567890","abcdefghijklmnopqrstuvwxyz"
        ));
//        ArrayList<String> list = new ArrayList<>(List.of(""));
//        ArrayList<String> list = new ArrayList<>();
        System.out.println(encode(list));
        System.out.println(decode(encode(list)));

    }




}
