package battleship.ship_unused;

public class Destroyer implements Ship{
    public static final String NAME = "Destroyer";
    public static final int SIZE = 2;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}
