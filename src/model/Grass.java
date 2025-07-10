package model;

public class Grass extends Plant{
    public Grass() {
        super(1.0, 200);
    }

    @Override
    public IslandEntity reproduce() {
        return new Grass();
    }

}
