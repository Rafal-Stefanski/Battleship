package battleship;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {
    public static void main(String[] args) {

        Board.prepareBoard();

        Game.addShip(Ship.AIRCRAFT_CARRIER);
//        Game.addShip(Ship.BATTLESHIP);
//        Game.addShip(Ship.SUBMARINE);
//        Game.addShip(Ship.CRUISER);
//        Game.addShip(Ship.DESTROYER);

        Game.play();
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