package easy;

/*
https://leetcode.com/problems/valid-palindrome/description/
* */
public class ValidPalindrome {

    //Less efficient
    static boolean run(String s) {
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String palindromString = builder.toString();
        length = palindromString.length();
        for (int i = 0; i < length / 2; i++) {
            if (palindromString.charAt(i) != palindromString.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //More efficient using two pointers and no extra string
    static boolean run2(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            //If char is not alphanumerical keep incrementing left or right
            while (left < right &&
                    !(Character.isLetter(s.charAt(left)) ||
                            Character.isDigit(s.charAt(left)))) {
                left++;
            }
            while (right > left
            && !(Character.isLetter(s.charAt(right)) ||
                    Character.isDigit(s.charAt(right)))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(right))
                    != Character.toLowerCase(s.charAt(left))) {
                return false;
            }
            //Increment both pointers at the end to move to next char
            left++;
            right--;
        }

        return true;
    }




    public static void main(String[] args) {
//        String s = "0P";
//        String s = "tab a cat";
//        String s = "Was it a car or a cat I saw?";
//        String s = ".,";
        String s = "No lemon, no melon";

        System.out.println(run2(s));


    }

}
