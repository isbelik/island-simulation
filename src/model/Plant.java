package model;

import factory.OrganismFactories;
import factory.OrganismFactory;
import map.Cell;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Plant extends Organism {

    public Plant(EntityType type) {
        super(type, type.getWeight(), type.getMaxPerCell());
    }

    public void grow(Cell cell) {
        if (cell.canAddOrganism(getType())) {
            double reproductionChance = getType().getReproductionProbability();
            if (ThreadLocalRandom.current().nextDouble() < reproductionChance) {
                OrganismFactory factory = OrganismFactories.getFactoryFor(EntityType.GRASS);
                cell.addOrganism(factory.createOrganism());
            }
        }
    }
}
