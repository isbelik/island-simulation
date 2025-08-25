package model;

public enum EntityType {
    WOLF("Wolf", 50.0, 30, 3, 8.0),
    BOA("Boa", 15.0, 30, 1, 3.0),
    FOX("Fox", 8.0, 30, 2, 3.0),
    BEAR("Bear", 500.0, 5, 2, 80.0),
    EAGLE("Eagle", 6.0, 20, 3, 1.0),
    HORSE("Horse", 400.0, 20, 4, 60.0),
    DEER("Deer", 300.0, 20, 4, 50.0),
    RABBIT("Rabbit", 2.0, 150, 2, 0.45),
    MOUSE("Mouse", 0.05, 500, 1, 0.01),
    GOAT("Goat", 60.0, 140, 3, 10.0),
    SHEEP("Sheep", 70.0, 140, 3, 15.0),
    BOAR("Boar", 400.0, 50, 2, 5.0),
    BUFFALO("Buffalo", 700.0, 10, 3, 100.0),
    CATERPILLAR("Caterpillar", 0.01, 1000, 0, 0),
    GRASS("Grass", 1.0, 200, 0, 0);

    private final String name;
    private final double weight;
    private final double maxPerCell;
    private final int speed;
    private final double maxSatiety;

    EntityType(String name, double weight, double maxPerCell, int speed, double maxSatiety) {
        this.name = name;
        this.weight = weight;
        this.maxPerCell = maxPerCell;
        this.speed = speed;
        this.maxSatiety = maxSatiety;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxPerCell() {
        return maxPerCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }
}