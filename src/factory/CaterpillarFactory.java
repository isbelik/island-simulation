package factory;

import model.Organism;
import model.animals.Caterpillar;

public class CaterpillarFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Caterpillar();
    }
}
