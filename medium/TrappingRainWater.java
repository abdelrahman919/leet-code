package medium;

//UNSOLVED
public class TrappingRainWater {

    public static void printTowerGraph(int[] heights) {
        int maxHeight = findMaxHeight(heights);

        for (int i = maxHeight; i > 0; i--) {
            for (int height : heights) {
                if (height >= i) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static int findMaxHeight(int[] heights) {
        int max = 0;
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }


    public static void main(String[] args) {

//        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] heights = {2, 0, 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] heights = {0, 1, 0, 1, 1, 0, 1, 2, 2, 1, 2, 1};
        int[] heights = {7,2,0,6,1,1,5,2,7};
        printTowerGraph(heights);
    }






}
