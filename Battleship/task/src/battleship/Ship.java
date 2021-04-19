package battleship;

public enum Ship {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5, new int[5]),
    BATTLESHIP("Battleship", 4, new int[4]),
    SUBMARINE("Submarine", 3, new int[3]),
    CRUISER("Cruiser", 3, new int[3]),
    DESTROYER("Destroyer", 2, new int[2]);

    public String name;
    public int size;
    public int[] loc;


    public int[] getLoc() {
        return loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }

    Ship(String name, int size, int[] loc) {
        this.name = name;
        this.size = size;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
