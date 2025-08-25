package factory;

import model.Organism;
import model.animals.Deer;

public class DeerFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Deer();
    }
}
