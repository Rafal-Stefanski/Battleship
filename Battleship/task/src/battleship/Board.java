package battleship;

public class Board {
    public static String[][] board = new String[11][11];

    public static void prepareBoard() {

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
}
