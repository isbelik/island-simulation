package factory;

import model.Organism;
import model.animals.Boa;

public class BoaFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Boa();
    }
}
