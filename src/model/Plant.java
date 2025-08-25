package model;

public abstract class Plant extends Organism {

    public Plant(EntityType type) {
        super(type, type.getWeight(), type.getMaxPerCell());
    }
}
