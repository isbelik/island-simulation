package factory;

import model.Organism;
import model.animals.Eagle;

public class EagleFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Eagle();
    }
}
