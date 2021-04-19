import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int[] array = new int[l];
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        System.out.println(minValue);
    }
}