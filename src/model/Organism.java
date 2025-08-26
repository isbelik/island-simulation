package model;

public abstract class Organism {
    private final EntityType type;
    private final double weight;
    private final int maxPerCell;

    public Organism(EntityType type, double weight, int maxPerCell) {
        this.type = type;
        this.weight = weight;
        this.maxPerCell = maxPerCell;
    }

    public EntityType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxPerCell() {
        return maxPerCell;
    }
}
