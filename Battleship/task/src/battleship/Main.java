package battleship;

import java.util.Arrays;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Board board = new Board();
        game.prepareBoard();

//        game.addShip(Ship.AIRCRAFT_CARRIER);
        game.addShip(Ship.BATTLESHIP);
        game.addShip(Ship.SUBMARINE);
//        game.addShip(Ship.CRUISER);
//        game.addShip(Ship.DESTROYER);


//        System.out.println("******* test section ********");
////        System.out.println(">> testing ship's locations array:\n>> " + Ship.AIRCRAFT_CARRIER + Arrays.toString(Ship.AIRCRAFT_CARRIER.getLoc()));
//        System.out.println(Ship.BATTLESHIP + Arrays.toString(Ship.BATTLESHIP.getShipLocation()));
//        System.out.println(Ship.SUBMARINE + Arrays.toString(Ship.SUBMARINE.getShipLocation()));
//        System.out.println("******* test section ********");

        game.play();
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