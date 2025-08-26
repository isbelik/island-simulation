package factory;

import model.Organism;
import model.animals.Sheep;

public class SheepFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Sheep();
    }
}
