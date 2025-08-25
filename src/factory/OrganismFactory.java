package factory;

import model.Organism;

@FunctionalInterface
public interface OrganismFactory {
    Organism createOrganism();
}
