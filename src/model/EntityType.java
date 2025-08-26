package model;

public enum EntityType {
    WOLF("Wolf", 50.0, 30, 3, 8.0, 0.08),
    BOA("Boa", 15.0, 30, 1, 3.0, 0.05),
    FOX("Fox", 8.0, 30, 2, 3.0, 0.15),
    BEAR("Bear", 500.0, 5, 2, 80.0, 0.03),
    EAGLE("Eagle", 6.0, 20, 3, 1.0, 0.02),
    HORSE("Horse", 400.0, 20, 4, 60.0, 0.04),
    DEER("Deer", 300.0, 20, 4, 50.0, 0.12),
    RABBIT("Rabbit", 2.0, 150, 2, 0.45, 0.25),
    MOUSE("Mouse", 0.05, 500, 1, 0.01, 0.30),
    GOAT("Goat", 60.0, 140, 3, 10.0, 0.18),
    SHEEP("Sheep", 70.0, 140, 3, 15.0, 0.16),
    BOAR("Boar", 400.0, 50, 2, 5.0, 0.15),
    BUFFALO("Buffalo", 700.0, 10, 3, 100.0, 0.04),
    DUCK("Duck", 1, 200, 4, 0.15, 0.20),
    CATERPILLAR("Caterpillar", 0.01, 1000, 0, 0, 0.40),
    GRASS("Grass", 1.0, 200, 0, 0, 0.80);

    private final String name;
    private final double weight;
    private final int maxPerCell;
    private final int speed;
    private final double maxSatiety;
    private final double reproductionProbability;

    EntityType(String name, double weight, int maxPerCell, int speed, double maxSatiety, double reproductionProbability) {
        this.name = name;
        this.weight = weight;
        this.maxPerCell = maxPerCell;
        this.speed = speed;
        this.maxSatiety = maxSatiety;
        this.reproductionProbability = reproductionProbability;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxPerCell() {
        return maxPerCell;
    }

    public int getSpeed() {
        return speed;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    public double getReproductionProbability() {
        return reproductionProbability;
    }
}