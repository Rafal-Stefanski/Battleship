
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here
        int[][] reversedDimArray = new int[twoDimArray.length][twoDimArray[0].length];

        int reversedCounter = 0;

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = twoDimArray[0].length - 1; j >= 0; j--) {
                reversedDimArray[i][j] = twoDimArray[i][reversedCounter];
                reversedCounter++;
            }
            reversedCounter = 0;
        }

        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[0].length; j++) {
                twoDimArray[i][j] = reversedDimArray[i][j];
            }
        }

    }
}