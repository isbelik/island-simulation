package model;

public class Rabbit extends Animal   {
    public Rabbit() {
        super(2, 150, 2, 0.45);
    }

    @Override
    public void eat() {
        System.out.println("Rabbit is eating.");
    }

    @Override
    public void move() {
        System.out.println("Rabbit is moving.");
    }

    @Override
    public IslandEntity reproduce() {
        return new Rabbit();
    }
}
