import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        boolean asymmetric = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    asymmetric = true;
                }
            }
        }
        if (!asymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
