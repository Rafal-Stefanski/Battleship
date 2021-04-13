import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        int length = String.valueOf(digit).length();
        int random = (int) (Math.random() * 100);

        if (length == 4) {

            int left = digit / 100;
            int firstRight = digit / 10 - 10 * left;
            int secondRight = digit % 10;

            if (secondRight * 10 + firstRight == left) {
                System.out.println(1);
            } else {
                System.out.println(random);
            }

        } else {
            System.out.println(random);
        }
    }
}