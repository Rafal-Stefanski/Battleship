import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int large = 0;
        int small = 0;
        int perfect = 0;
        int[] control = new int[n]; //{0, -1, -1, 1, 0, 0, 0, 0, 0, 1, 0, -1, 1, -1};

        for (int i = 0; i < control.length; i++) {
            control[i] = scanner.nextInt();
        }

        for (int j : control) {
            if (j == 1) {
                large++;
            } else if (j == -1) {
                small++;
            } else if (j == 0) {
                perfect++;
            }
        }
        System.out.println(perfect + " " + large + " " + small);
    }
}