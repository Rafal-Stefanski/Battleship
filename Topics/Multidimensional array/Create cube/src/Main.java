//import java.util.Arrays;

class ArrayOperations {
//    public static void main(String[] args) {
//        int[][][] arr;
//        arr=createCube();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print("\t" + Arrays.toString(arr[i][j]));
//            }
//            System.out.println();
//        }
//    }

    public static int[][][] createCube() {
        // write your code here
        int[][][] array3d = new int[3][3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    array3d[i][j][k] = k;
                    if (j == 1) {
                        array3d[i][j][k] = k + 3;
                    } else if (j == 2) {
                        array3d[i][j][k] = k + 6;
                    }
                }
            }
        }
        return array3d;
    }
}