package factory;

import model.Organism;
import model.animals.Bear;

public class BearFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Bear();
    }
}
