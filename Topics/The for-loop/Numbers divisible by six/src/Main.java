import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < number; i++) {
            int num = scanner.nextInt();
            if (num % 6 == 0) {
                sum = sum + num;
            }
        }
        System.out.println(sum);
    }
}