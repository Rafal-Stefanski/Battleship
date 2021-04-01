import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int number;
        int count = 0;

        do  {
            number = scanner.nextInt();
            count++;
        } while (number != 0);
        System.out.println(count - 1);
    }
}