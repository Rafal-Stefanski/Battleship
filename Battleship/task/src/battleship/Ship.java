package battleship;

public enum Ship {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship",4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    public String name;
    public int size;
    public int[] location;

    Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.location = new int[getSize()];
    }

    Ship(String name, int[] location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
