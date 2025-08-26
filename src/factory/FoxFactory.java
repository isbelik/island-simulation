package factory;

import model.Organism;
import model.animals.Fox;

public class FoxFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Fox();
    }
}
