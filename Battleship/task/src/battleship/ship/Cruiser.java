package battleship.ship;

public class Cruiser implements Ship{
    public static final String NAME = "Cruiser";
    public static final int SIZE = 3;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
