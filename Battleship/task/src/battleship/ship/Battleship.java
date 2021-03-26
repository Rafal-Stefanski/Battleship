package battleship.ship;

public class Battleship implements Ship{
    public static final String NAME = "Battleship";
    public static final int SIZE = 4;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
