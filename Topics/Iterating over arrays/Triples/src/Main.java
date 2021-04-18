import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int arLength = scanner.nextInt();
        int[] array = new int[arLength];
        int count = 0;

        for (int i = 0; i < arLength; i++) {
            array[i] = scanner.nextInt();
            if (i > 1) {
                if (array[i] == array[i - 1] + 1) {
                    if (array[i - 1] == array[i - 2] + 1)
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}