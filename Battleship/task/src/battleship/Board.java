package battleship;

public class Board {
    final private String[][] board = new String[11][11];
    final private String[][] hiddenBoard = new String[11][11];

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


    public void shipHitCounter(int x, int y) {

        int[] aircraftCarrierLoc = Ship.AIRCRAFT_CARRIER.getShipLocation();
        int[] battleshipLoc = Ship.BATTLESHIP.getShipLocation();
        int[] submarineLoc = Ship.SUBMARINE.getShipLocation();
        int[] cruiserLoc = Ship.CRUISER.getShipLocation();
        int[] destroyerLoc = Ship.DESTROYER.getShipLocation();

        int hit = checker(x, y, submarineLoc);
        System.out.println("checker = " + hit + " x = " + x + ", y = " + y);


//        System.out.println("******* test section / ********");
//        if (checker(x, y, aircraftCarrierLoc) != aircraftCarrierLoc.length) {
//            System.out.println("You hit " + Ship.AIRCRAFT_CARRIER.getName() + ". There are: " + checker(x, y, aircraftCarrierLoc) + ", segments left.");
//        }
//        if (checker(x, y, battleshipLoc) != battleshipLoc.length) {
//            System.out.println("You hit " + Ship.BATTLESHIP.getName() + ". There are: " + checker(x, y, battleshipLoc) + ", segments left.");
//        }
//        if (checker(x, y, submarineLoc) != submarineLoc.length) {
//            System.out.println("You hit " + Ship.SUBMARINE.getName() + ". There are: "  + ", segments left.");
//        }
//        if (checker(x, y, cruiserLoc) != cruiserLoc.length) {
//            System.out.println("You hit " + Ship.CRUISER.getName() + ". There are: " + checker(x, y, cruiserLoc) + ", segments left.");
//        }
//        if (checker(x, y, destroyerLoc) != destroyerLoc.length) {
//            System.out.println("You hit " + Ship.DESTROYER.getName() + ". There are: " + checker(x, y, destroyerLoc) + ", segments left.");
//        }
//        System.out.println("******* / test section ********");

    }

    public int checker(int x, int y, int[] shipArrayLoc) {
        int shipLengthLeft = shipArrayLoc.length;
        System.out.println("shipArrayLoc.length " + shipLengthLeft);

        for (int i = 0; i < shipArrayLoc.length; i++) {
            if (shipArrayLoc[i] == (x * 10 + y)) {
                shipArrayLoc[i] = 0;
                System.out.print("\nYou hit a ship! Try again:\n\n> ");
            }
        }
        for (int j = 0; j < shipArrayLoc.length; j++) {
            if (shipArrayLoc[j] == 0) {
                shipLengthLeft--;
            }
        }
        if (shipLengthLeft == 0) {
            System.out.println("You sank a ship!");
        }
        return shipLengthLeft;
    }


    // old checker method


    // if (contains(aircraftCarrierLoc, 2)) {
    //            System.out.println("Hello 2");
    //        }
    //
    //        boolean shipLeft = false;
    //
    //        if (x < 10) {
    //            if (board[x - 1][y].equals("O") || board[x + 1][y].equals("O")) {
    //                shipLeft = true;
    //            } else {
    //                shipLeft = false;
    //            }
    //        } else if (x == 10) {
    //            if (board[x - 1][y].equals("O")) {
    //                shipLeft = true;
    //            } else {
    //                shipLeft = false;
    //            }
    //        }
    //        if (y < 10) {
    //            if (board[x][y - 1].equals("O") || board[x][y + 1].equals("O")) {
    //                shipLeft = true;
    //            } else {
    //                shipLeft = false;
    //            }
    //        } else if (y == 10) {
    //            if (board[x][y - 1].equals("O")) {
    //                shipLeft = true;
    //            } else {
    //                shipLeft = false;
    //            }
    //        }


//    public static boolean contains(final int[] array, final int v) {
//        boolean result = false;
//        for(int i : array){
//            if(i == v){
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }

}
