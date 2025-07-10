package model;

public class Wolf extends Animal{
    public Wolf() {
        super(50, 30, 3, 8);
    }

    @Override
    public void eat() {
        System.out.println("Wolf is eating.");
    }

    @Override
    public void move() {
        System.out.println("Wolf is moving.");
    }

    @Override
    public IslandEntity reproduce() {
        return new Wolf();
    }
}
