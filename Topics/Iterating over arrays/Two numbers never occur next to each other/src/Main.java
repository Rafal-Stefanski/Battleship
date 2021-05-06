import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean neverOccur = true;

        if (length > 2) {
            for (int i = 1; i < array.length - 1; i++) {
                if (array[i] == n) {

                    neverOccur = array[i - 1] != m && array[i + 1] != m;
                }
                if (array[i] == m) {

                    neverOccur = array[i - 1] != n && array[i + 1] != n;
                }
            }
        } else {
            if (array[0] == m && array[1] == n || array[0] == n && array[1] == m) {
                neverOccur = false;
            }
        }

        System.out.println(neverOccur);
    }
}