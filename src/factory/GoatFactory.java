package factory;

import model.Organism;
import model.animals.Goat;

public class GoatFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Goat();
    }
}
