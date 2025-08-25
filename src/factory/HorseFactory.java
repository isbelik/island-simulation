package factory;

import model.Organism;
import model.animals.Horse;

public class HorseFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Horse();
    }
}
