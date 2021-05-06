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
        int number = scanner.nextInt();
        boolean contain = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                contain = true;
                break;
            }
        }
        if (contain) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}