package factory;

import model.Organism;
import model.plants.Grass;

public class GrassFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Grass();
    }
}
