package battleship;

public class Board {
    private String[][] board = new String[11][11];
    private String[][] hiddenBoard = new String[11][11];

    public String[][] getBoard() {
        return board;
    }

    public String[][] getHiddenBoard() {
        return hiddenBoard;
    }

    public void prepareBoardAndHiddenBoard() {

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

    public void printBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public void printHiddenBoard() {
        for (int i = 0; i < 11; i++) {
            System.out.println();
            for (int j = 0; j < 11; j++) {
                System.out.print(hiddenBoard[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public boolean checker(int x, int y) {
        boolean shipLeft = false;
        int no = 0;

        if (x < 10) {
            if (board[x - 1][y].equals("O") || board[x + 1][y].equals("O")) {
                shipLeft = true;
                no++;
            } else {
                shipLeft = false;
            }
        } else if (x == 10) {
            if (board[x - 1][y].equals("O")) {
                shipLeft = true;
                no++;
            } else {
                shipLeft = false;
            }
        }
        if (y < 10) {
            if (board[x][y - 1].equals("O") || board[x][y + 1].equals("O")) {
                shipLeft = true;
                no++;
            } else {
                shipLeft = false;
            }
        } else if (y == 10) {
            if (board[x][y - 1].equals("O")) {
                shipLeft = true;
                no++;
            } else {
                shipLeft = false;
            }
        }

        if (no > 1) {
            shipLeft = true;
        }
        return shipLeft;
    }
}
