package medium;


/*
https://leetcode.com/problems/container-with-most-water/description/
* */

public class ContainerWithMostWater {

    //Basically the same as two sum
    //Calculate the area between two pointers and move the smaller one till they meet
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int waterArea = 0;
            if (height[l] < height[r]) {
                waterArea = height[l] * (r - l);
                l++;
            } else {
                waterArea = height[r] * (r - l);
                r--;
            }
            if (waterArea > max) {
                max = waterArea;
            }

        }

        return max;
    }


}
