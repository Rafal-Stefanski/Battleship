import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] inputArray = new int[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                inputArray[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        int temp = b;
        b = a;
        a = temp;

        for (int i = 0; i < a; i++) {
            for (int j = b - 1; j >= 0; j--) {
                System.out.print(inputArray[j][i] + " ");
            }
            System.out.println();
        }
    }
}