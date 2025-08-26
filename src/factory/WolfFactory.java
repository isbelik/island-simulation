package factory;

import model.Organism;
import model.animals.Wolf;

public class WolfFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Wolf();
    }
}
