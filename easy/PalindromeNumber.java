package easy;

import java.util.ArrayList;

public class PalindromeNumber {
    static int x = 121;



    public static void main(String[] args) {
        var list = new ArrayList<>();
        if (x < 0) {
            System.out.println(false);
        }
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }

        int iterations = list.size() / 2;

        for (int i = 0; i < iterations; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);



    }

}
