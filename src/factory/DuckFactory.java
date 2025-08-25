package factory;

import model.Organism;
import model.animals.Duck;

public class DuckFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Duck();
    }
}
