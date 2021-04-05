package battleship;

import java.util.Scanner;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {
    public static void main(String[] args) {

        Board.prepareBoard();

        addShip(Ship.AIRCRAFT_CARRIER);
        addShip(Ship.BATTLESHIP);
        addShip(Ship.SUBMARINE);
        addShip(Ship.CRUISER);
        addShip(Ship.DESTROYER);
    }

    public static void addShip(Ship ship) {

        // lets get some coordinates
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n\n> ");
        String coordinate1 = scanner.next();
        String coordinate2 = scanner.next();

        // coordinates on board
        int x1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
        int y1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)

        int x2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
        int y2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)

        // checking and validating coordinates range and placement on the board
        if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10 && x2 > 0 && y2 > 0 && x2 <= 10 && y2 <= 10) {
            // changing places when first value is larger
            if (x1 > x2) {
                int tempX1 = x2;
                x2 = x1;
                x1 = tempX1;
            }
            if (y1 > y2) {
                int tempY1 = y2;
                y2 = y1;
                y1 = tempY1;
            }

            // checking positions
            if (x1 == x2) {                             // it's horizontal!
                if ((y2 - y1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");
                    for (int i = y1; i <= y2; i++) {
                        Board.board[x1][i] = "O";
                    }
                    Board.printBoard();
                } else {
                    System.out.println("Error! Wrong ship size! Try again.");
                    addShip(ship);
                }
            } else if (y1 == y2) {                      // it's vertical!
                if ((x2 - x1 + 1) == ship.getSize()) {  // ship size is OK!
//                    System.out.println("size OK!");
                    for (int i = x1; i <= x2; i++) {
                        Board.board[i][y1] = "O";
                    }
                    Board.printBoard();
                } else {
                    System.out.println("Error! Wrong ship size! Try again.");
                    addShip(ship);
                }
            } else {
                System.out.println("Error! Wrong ship location! Looks like it's cross-draw. Try again.");
                addShip(ship);
            }
        } else {
            System.out.println("Error! Wrong ship location! Looks like it's out of board range. Try again.");
            addShip(ship);
        }
    }


    public static void fastCheck() {

//        Pattern p = Pattern.compile("[a-jA-J]([1-9]|10)\\s[a-jA-J]([1-9]|10)");
//        Matcher m = p.matcher(coordinates);
//
//        if (m.matches()) {
//            System.out.println("coordinates are in range.");
//            return true;
//        } else {
//            System.out.println("coordinates doesn't match");
//            return false;
//        }


//        System.out.println("**** fast check ****");
//        System.out.println("i1 = " + i1);
//        System.out.println("j1 = " + j1);
//        System.out.println("i2 = " + i2);
//        System.out.println("j2 = " + j2);
//        System.out.println("****   ******   ****");
    }
}