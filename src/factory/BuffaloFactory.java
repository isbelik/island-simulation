package factory;

import model.Organism;
import model.animals.Buffalo;

public class BuffaloFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Buffalo();
    }
}
