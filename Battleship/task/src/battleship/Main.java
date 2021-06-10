package battleship;

/**
 * Rules of the game Battleship https://en.wikipedia.org/wiki/Battleship_(game)
 */

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Board boardPlayer1 = new Board();
        Board boardPlayer2 = new Board();

        System.out.println("Player 1, place your ships on the game field");
        boardPlayer1.prepareBoardAndHiddenBoard();

        boardPlayer1.addShips();

        Game.promptEnterKey();
        System.out.println("Player 2, place your ships on the game field");
        boardPlayer2.prepareBoardAndHiddenBoard();

        boardPlayer2.addShips();

        Game.promptEnterKey();

        game.playTwoPlayers(boardPlayer1, boardPlayer2);

    }
}
