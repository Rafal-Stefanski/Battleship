package battleship;

import battleship.ship.*;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {


    public static void main(String[] args) {

        // Write your code here

        Board.prepareBoard();
        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        Battleship battleship = new Battleship();
        Submarine submarine = new Submarine();
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();

        addShip(aircraftCarrier);
//
        addShip(battleship);


    }


    public static void addShip(Ship ship) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n\n> ");
        String coordinate1 = scanner.next();
        String coordinate2 = scanner.next();

//        boolean horizontal = false, vertical = false, shipLength = false;

        // coordinates on board
        int x1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
        int y1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)

        int x2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
        int y2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)

        // checking and validating coordinates range and placement on the board
        if (x1 > 0 && y1 > 0 && x1 <= 10 && y1 <= 10 && x2 > 0 && y2 > 0 && x2 <= 10 && y2 <= 10) {
            if (x1 == x2) {
//                horizontal = true;    // it's horizontal
                if ((y2 - y1 + 1) == ship.getSize()) {
//                    shipLength = true;
                    System.out.println("size OK!");
                    for (int i = y1; i <= y2; i++) {
                            Board.board[x1][i] = "O";
                        }
                    Board.printBoard();

                } else {
                    System.out.println("Error! Wrong ship size! Try again.");
                    addShip(ship);
                }
            } else if (y1 == y2) {
//                vertical = true;    // it's vertical!
                if ((x2 - x1 + 1) == ship.getSize()) {
//                    shipLength = true;
                    System.out.println("size OK!");
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


//    public static void addShip(Ship ship) {
//
//
////        System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n\n> ");
////        String coordinate1;
////        String coordinate2;
////        scanner.close();
//
////            boolean pickLoop = true;
//        boolean whileTrue = true;
//
//        while (true) {
//
//            label:
//            while (true) {
//                try (Scanner scanner = new Scanner(System.in)) {
//
//
//                    System.out.print("Enter the coordinates of the " + ship.getName() + " (" + ship.getSize() + " cells):\n\n> ");
//                    String coordinate1 = scanner.next();
//                    String coordinate2 = scanner.next();
//
//                    boolean ifHorizontal = false, ifVertical = false;
//
//                    // coordinates on board
//                    int i1 = Character.toUpperCase(coordinate1.charAt(0)) - 'A' + 1;  // letter (horizontal)
//                    int j1 = Integer.parseInt(coordinate1.substring(1));               // number (vertical)
//
//                    int i2 = Character.toUpperCase(coordinate2.charAt(0)) - 'A' + 1;  // letter (horizontal)
//                    int j2 = Integer.parseInt(coordinate2.substring(1));               // number (vertical)
//
//                    if (i1 == i2) {
//                        ifHorizontal = true;
//                    } else if (j1 == j2) {
//                        ifVertical = true;
//                    } else {
//                        System.out.println("Error! Wrong ship location! Try again:");
//                        break label;
//                    }
//
//
////                if (ifHorizontal || ifVertical) {
//                    if (j2 - j1 == ship.getSize() - 1) {
//                        for (int i = j1; i <= j2; i++) {
//                            Board.board[i1][i] = "O";
//                        }
//                    } else if (i2 - i1 == ship.getSize() - 1) {
//                        for (int i = i1; i <= i2; i++) {
//                            Board.board[i][j1] = "O";
//                        }
//                    } else {
//                        System.out.println("Error! Wrong size of ship, sorry mate. Try again:");
//                        break label;
//                    }
////                }
//                    System.out.println("i1 = " + i1);
//                    System.out.println("j1 = " + j1);
//                    break;
//                } catch (NumberFormatException NoSuchElementException) {
//                    System.out.println("ups");
//                }
//            }
//        }
//    }

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