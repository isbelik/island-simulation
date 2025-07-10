package model;

public abstract class IslandEntity {
    protected final double weight;
    protected final int maxCountPerCell;

    public IslandEntity(double weight, int maxCountPerCell) {
        this.weight = weight;
        this.maxCountPerCell = maxCountPerCell;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountPerCell() {
        return maxCountPerCell;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public abstract IslandEntity reproduce();
}
