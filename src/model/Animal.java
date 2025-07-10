package model;

public abstract class Animal extends IslandEntity {
    protected final int maxSpeed;
    protected final double maxFood;

    public Animal(double weight, int maxCountPerCell, int maxSpeed, double maxFood) {
        super(weight, maxCountPerCell);
        this.maxSpeed = maxSpeed;
        this.maxFood = maxFood;
    }

    public abstract void eat();
    public abstract void move();

}
