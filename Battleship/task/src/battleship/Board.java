package battleship;

public class Board {
    public static String[][] board = new String[11][11];
    public static String[][] hiddenBoard = new String[11][11];

    public static void prepareBoard() {

        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    board[i][j] = " ";
                    hiddenBoard[i][j] = " ";
                } else if (i == 0) {
                    board[i][j] = Integer.toString(j);
                    hiddenBoard[i][j] = Integer.toString(j);
                } else if (j == 0) {
                    board[i][j] = Character.toString(64 + i);
                    hiddenBoard[i][j] = Character.toString(64 + i);
                } else {
                    board[i][j] = "~";
                    hiddenBoard[i][j] = "~";
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

    public static void printHiddenBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                System.out.print(hiddenBoard[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public static boolean checker(int x, int y) {
        boolean shipLeft = false;

        if (x < 10) {
            shipLeft = Board.board[x - 1][y].equals("O") || Board.board[x + 1][y].equals("O");
        } else if (x == 10) {
            shipLeft = Board.board[x - 1][y].equals("O");
        }
        if (y < 10) {
            shipLeft = Board.board[x][y - 1].equals("O") || Board.board[x][y + 1].equals("O");
        } else if (y == 10) {
            shipLeft = Board.board[x][y - 1].equals("O");
        }
        return shipLeft;
    }
}
