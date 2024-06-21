package medium;

import java.util.Arrays;

/*
https://leetcode.com/problems/koko-eating-bananas/description/
*/
public class KokoEatingBananas {

    static int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int bananaNum = max;
        int l = 1;
        int r = max;
        while (l <= r) {
            int m = (l + r) / 2;
            long time = calculateTime(piles, m);
            if (time > h) {
                l = m + 1;
            } else {
                r = m - 1;
                if (m < bananaNum) {
                    bananaNum = m;
                }
            }
        }

        return bananaNum;
    }

    //One annoying thing with this problem is that """ONE""" test case requires result to be long
    //Which is really unnecessary and doesn't add anything to the problem itself just some1 being annoying
    static Long calculateTime(int[]piles, int m) {
        long result = 0L;
        for (int pile : piles) {
            result += Math.ceilDiv(pile,m);
        }
        return result;
    }



}
