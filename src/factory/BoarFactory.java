package factory;

import model.Organism;
import model.animals.Boar;

public class BoarFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Boar();
    }
}
