package battleship;

import java.util.Scanner;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {

    public static String[][] board = new String[11][11];

    public static void main(String[] args) {

        // Write your code here

        prepareBoard();
        addShip();
        printBoard();

    }

    public static void prepareBoard() {

//        String[][] board = new String[11][11];

        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = " ";
                } else if (i == 0) {
                    board[i][j] = Integer.toString(j);
                } else if (j == 0) {
                    board[i][j] = Character.toString(64 + i);
                } else {
                    board[i][j] = "~";
                }
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public static void printBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {

                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public static String[][] addShip() {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                System.out.print("Enter the coordinates of the Aircraft Carrier (5 cells):\n\n> ");
                String coordinate1 = scanner.next();
                String coordinate2 = scanner.next();
                scanner.close();
                boolean ifHorizontal = false, ifVertical = false;

                // coordinates on board
                int i1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
                int j1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)

                int i2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
                int j2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)

                if (i1 == i2) {
                    ifHorizontal = true;
                } else if (j1 == j2) {
                    ifVertical = true;
                } else {
                    System.out.println("Error! Wrong ship location! Try again:");

                }


                if (ifHorizontal || ifVertical) {
                    if (j2 - j1 == 4) {
                        for (int i = j1; i <= j2; i++) {
                            board[i1][i] = "O";
                        }
                    } else if (i2 - i1 == 4) {
                        for (int i = i1; i <= i2; i++) {
                            board[i][j1] = "O";
                        }
                    } else {
                        System.out.println("Error! Wrong size of ship, sorry mate. Try again:");
                    }
                }
            }

        }

//        System.out.println("i1 = " + i1);
//        System.out.println("j1 = " + j1);


//        return board;

    }
}
